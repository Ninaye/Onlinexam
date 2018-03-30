package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/scheduleDeleteServlet")
public class ScheduleDeleteServlet extends HttpServlet {

	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tcId = req.getParameter("id");
		cs.deleteTeacherCourse(Integer.valueOf(tcId));
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
	}
}
