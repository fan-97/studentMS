package com.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置响应类型和编码
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取方法
		String method = req.getParameter("method");

		if (method == null || method.equals("") || method.trim().equals("")) {
			method = "execute";
		}
		// 获取对象
		Class clazz = this.getClass();

		try {
			// 获取当前对象的方法
			Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			if (md != null) {
				String path = (String) md.invoke(this, req, resp);// 执行当前方法
				if (path!=null&&!path.trim().equals("")) {
					if (path.startsWith("redirect:")) {
						//重定向
						resp.sendRedirect(path.substring(9));
					}else {
						//请求转发当前路径
						req.getRequestDispatcher(path).forward(req, resp);
					}
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return null;// 不做任何跳转
	}
}
