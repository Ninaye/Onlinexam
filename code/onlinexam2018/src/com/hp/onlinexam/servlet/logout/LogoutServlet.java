package com.hp.onlinexam.servlet.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 *	把当前的session失效
		 */
		req.getSession().invalidate();
		req.getRequestDispatcher("./login.jsp").forward(req, resp);
	}
}