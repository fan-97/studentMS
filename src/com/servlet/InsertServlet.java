package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.print.attribute.ResolutionSyntax;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;
import com.util.MyUtils;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 获取表单数据
		String type = request.getParameter("type");
		String name = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String hobby = Arrays.toString(request.getParameterValues("hobby"));
		String info = request.getParameter("info");
		hobby = hobby.substring(1, hobby.length() - 1);
		if (MyUtils.checkBirthday(birthday)) {
			request.setAttribute("info", "操作成功");
			StudentService service = new StudentServiceImpl();
			try {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				Student student = new Student(name, gender, phone, date, hobby, info);
				// 写入到数据库中
				if ("insert".equals(type)) {
					service.insert(student);
				} else {
					int sid = Integer.parseInt(request.getParameter("sid"));
					student.setSid(sid);
					service.updateStu(student);
				}
			} catch (ParseException | SQLException e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("info", "请严格按照给定格式和常识来输入日期");
		}
		// 跳转页面
//		response.sendRedirect("StudentListServlet");
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

}