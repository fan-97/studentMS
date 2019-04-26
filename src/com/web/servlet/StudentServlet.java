package com.web.servlet;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.dao.impl.StudentDaoImpl;
import com.domain.PageBean;
import com.domain.Student;
import com.service.AdminService;
import com.service.StudentService;
import com.service.impl.AdminServiceImpl;
import com.service.impl.StudentServiceImpl;
import com.util.CookieUtil;
import com.util.MyUtils;

public class StudentServlet extends BaseServlet {
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		//清除session
		request.getSession().removeAttribute("user");
		//clean cookie
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtil.getCookie(cookies, "userLogin");
		cookie.setMaxAge(0);
		cookie.setValue("");
		response.addCookie(cookie);
		return "redirect:StudentServlet?method=loginUI";
	}
	
	public String insertUI(HttpServletRequest request, HttpServletResponse response) {
		return "insert.jsp";
	}

	public String insertOne(HttpServletRequest request, HttpServletResponse response) {
		// 获取表单数据
		String name = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String hobby = Arrays.toString(request.getParameterValues("hobby"));
		String info = request.getParameter("info");
		String grade = request.getParameter("grade");
		hobby = hobby.substring(1, hobby.length() - 1);
		if (MyUtils.checkBirthday(birthday)) {
			request.setAttribute("info", "操作成功");
			StudentService service = new StudentServiceImpl();
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				Student student = new Student(name, gender, phone, date, hobby, info, grade);
				// 写入到数据库中
				service.insert(student);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("info", "请严格按照给定格式和常识来输入日期");
		}
		return "index.jsp";
	}

	public String loginUI(HttpServletRequest request, HttpServletResponse response) {
		return "login.jsp";
	}

	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminService service = new AdminServiceImpl();
		if (service.login(username, password)) {
			//在主页面显示欢迎信息
			request.getSession().setAttribute("username", username);
			//存入session中
			request.getSession().setAttribute("user", "username####password");
			//将登录信息保存在cookie中，7天内免登录
			Cookie cookie = new Cookie("userLogin", "username####password");
			cookie.setMaxAge(60*60*24*7);//保存时间为7天
			cookie.setPath("/");
			response.addCookie(cookie);
			// 跳转主页面
			return "index.jsp";
		} else {
			// 提示错误信息
			String err = "账号或密码错误";
			request.setAttribute("err", err);
			return "login.jsp";
		}
	}

	public String updataUI(HttpServletRequest request, HttpServletResponse response) {
		int sid = Integer.parseInt(request.getParameter("sid"));
		StudentService service = new StudentServiceImpl();
		Student stu = service.getStuById(sid);
		request.setAttribute("stu", stu);
		return "updata.jsp";
	}

	public String updata(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String hobby = Arrays.toString(request.getParameterValues("hobby"));
		String info = request.getParameter("info");
		String grade = request.getParameter("grade");
		hobby = hobby.substring(1, hobby.length() - 1);
		request.setAttribute("info", "操作成功");
		StudentService service = new StudentServiceImpl();
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			Student student = new Student(name, gender, phone, date, hobby, info, grade);
			// 写入到数据库中
			int sid = Integer.parseInt(request.getParameter("sid"));
			student.setSid(sid);
			service.updateStu(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 跳转页面
		return "index.jsp";
	}

	public String listStudent(HttpServletRequest request, HttpServletResponse response) {
		StudentService service = new StudentServiceImpl();
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageBean pageBean = service.getCurrentPageUser(currentPage);
		// 2.传递参数值
		request.setAttribute("pageBean", pageBean);
		return "stu_list.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int sid = Integer.parseInt(request.getParameter("sid"));
		StudentService service = new StudentServiceImpl();
		service.delStuById(sid);// 执行删除
		return "index.jsp";// 跳转页面
	}

	public String queryStudent(HttpServletRequest request, HttpServletResponse response) {
		StudentService service = new StudentServiceImpl();
		int currentPage = 1;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		String name = request.getParameter("sname");
		String gender = request.getParameter("gender");
		System.out.println(gender);
		if (MyUtils.isEmptyStr(name)&&MyUtils.isEmptyStr(gender)) {
			//如果都为空，那么显示全部
			return "redirect:index.jsp";
		}
		PageBean pageBean = service.VagueQuery(name, gender, currentPage);
		// 传递参数
		request.setAttribute("pageBean", pageBean);
		return "stu_list.jsp";// 跳转页面
	}
	public String goHead(HttpServletRequest request, HttpServletResponse response) {
		return "index.jsp";
	}
}
