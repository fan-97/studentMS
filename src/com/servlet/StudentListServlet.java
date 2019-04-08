package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PageBean;
import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

public class StudentListServlet extends HttpServlet {
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
		StudentService service = new StudentServiceImpl();
		// // 1.查询所有学生
		// List<Student> list = service.findAll();
		// // 2.将值保存到域中
		// request.setAttribute("list", list);
		// 1.获取当前页的数据
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageBean<Student> pageBean = service.getCurrentPageUser(currentPage);
		// 2.传递参数值
		request.setAttribute("pageBean", pageBean);
		// 3.跳转页面
		request.getRequestDispatcher("stu_list.jsp").forward(request, response);
	}

}