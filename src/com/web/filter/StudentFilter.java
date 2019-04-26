package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.util.CookieUtil;

public class StudentFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf8");
		resp.setContentType("text/html;charset=utf8");
		// 如果是登录界面不用拦截
		String servletPath = req.getServletPath();
		if (servletPath.startsWith("/StudentServlet")) {
			if ("loginUI".equals(req.getParameter("method")) || "login".equals(req.getParameter("method"))) {
				chain.doFilter(req, resp);
				return;
			}
		}
		if (req.getRequestURI().endsWith("login.jsp")) {
			chain.doFilter(req, resp);
			return;
		}

		// 先从session里面获取用户名和密码 如果有并且正确就跳转
		AdminDao dao = new AdminDaoImpl();
		String session = (String) req.getSession().getAttribute("user");
		if (session == null) {
			//没有登录
			req.getRequestDispatcher("err.jsp").forward(req, resp);
			return ;
		}

		// 从cookie里面找用户登录信息
		Cookie cookie = CookieUtil.getCookie(req.getCookies(), "userLogin");
		if (null == cookie) {
			chain.doFilter(req, resp);
			return;
		}
		// 验证用户名和密码是否正确
		String value[] = cookie.getValue().split("####");
		String username = value[0];
		String password = value[1];
		if (!dao.login(username, password)) {
			//登录失败
			chain.doFilter(req, resp);
			return;
		}
		//将信息存入session
		req.getSession().setAttribute("user", username);
		req.getRequestDispatcher("err.jsp").forward(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {

	}

}
