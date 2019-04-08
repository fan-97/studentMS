package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AdminService;
import com.service.impl.AdminServiceImpl;

public class LoginServlet extends HttpServlet {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		AdminService service = new AdminServiceImpl();
		if (service.login(username, password)) {
			//跳转主页面
//			request.
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			//提示错误信息
			String err = "账号或密码错误";
			request.setAttribute("err", err);
//			response.getWriter().println("<font color = 'red'> 账号或密码错误！</font>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}