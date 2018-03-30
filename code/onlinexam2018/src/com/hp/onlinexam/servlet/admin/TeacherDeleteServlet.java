package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet {
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tid = req.getParameter("id");
		ts.deleteTeacherById(Integer.valueOf(tid));
		req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}

}
