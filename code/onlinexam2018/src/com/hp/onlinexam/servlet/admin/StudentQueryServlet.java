package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StudentService;

@WebServlet("/studentQueryServlet")
public class StudentQueryServlet extends HttpServlet {

	private IStudentService ss = new StudentService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List studentList = ss.findAll();
		req.setAttribute("studentList", studentList);
		req.getRequestDispatcher("manager/studentmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
