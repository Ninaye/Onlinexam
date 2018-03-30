package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {

	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("id");
		Course c = cs.findCourseById(Integer.valueOf(cid));
		req.setAttribute("course", c);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cid = req.getParameter("courseId");
		String cname = req.getParameter("coursename");
		Course c = new Course(Integer.valueOf(cid),cname);
		cs.updateCourse(c);
		req.getRequestDispatcher("/courseQueryServlet").forward(req, resp);
	}

}
