package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {

	private ITestService ts = new TestService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Test t = (Test)req.getSession().getAttribute("test");
		ts.createTest(t);
		req.getSession().removeAttribute("test");
		req.getRequestDispatcher("testQueryServlet").forward(req, resp);
	}
}
