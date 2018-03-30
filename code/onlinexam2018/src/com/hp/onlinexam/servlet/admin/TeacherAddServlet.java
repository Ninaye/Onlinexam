package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teacheradd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherName = req.getParameter("teachername");
		String teacherPwd = req.getParameter("teacherpwd");
		String depInfo = req.getParameter("depInfo");
		Teacher t = new Teacher(teacherName,teacherPwd,depInfo);
		ts.addTeacher(t);
		req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}
}
