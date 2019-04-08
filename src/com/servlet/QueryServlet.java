package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.PageBean;
import com.domain.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

public class QueryServlet extends HttpServlet {
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
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		int currentPage = 1;
		if (request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		StudentService service = new StudentServiceImpl();
		PageBean<Student> pageBean= service.VagueQuery(sname, gender,currentPage);
//		System.out.println(list.get(0).toString());
//		request.setAttribute("list", list);
		request.setAttribute("pageBean", pageBean);
		request.getRequestDispatcher("stu_list.jsp").forward(request, response);
	}

}