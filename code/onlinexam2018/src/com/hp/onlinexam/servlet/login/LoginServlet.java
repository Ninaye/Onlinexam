package com.hp.onlinexam.servlet.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.login.ILoginService;
import com.hp.onlinexam.service.login.LoginService;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private ILoginService ls = new LoginService();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String pwd = req.getParameter("password");
		String role = req.getParameter("role");
		if ("admin".equals(role)) {
			if("Ninaye".equals(userName) && "ninaye".equals(pwd)) {
				req.getSession().setAttribute("user", userName);
				req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("./login.jsp").forward(req, resp);
			}
		} else if ("teacher".equals(role)) {
			Teacher t = new Teacher();
			t.setTname(userName);
			t.setTpwd(pwd);
			t = ls.canLogin(t);
			if (null != t) {
				req.getSession().setAttribute("user", t);
				req.getRequestDispatcher("/testQueryServlet").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("./login.jsp").forward(req, resp);
			}
		} else if ("student".equals(role)) {
			Student s = new Student();
			s.setSname(userName);
			s.setSpwd(pwd);
			s = ls.canLogin(s);
			if(null != s) {
				req.getSession().setAttribute("user", s);
				req.getRequestDispatcher("/recentTestServlet").forward(req, resp);
			}
			else {
				req.getRequestDispatcher("./login.jsp").forward(req, resp);
			}
		}
		else {
			req.getRequestDispatcher("./login.jsp").forward(req, resp);
		}
	}
}
