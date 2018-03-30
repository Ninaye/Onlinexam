package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/scheduleAddServlet")
public class ScheduleAddServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();
	private IStuClassService scs = new StuClassService();
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List stuclassList = scs.findAll();
		List teacherList = ts.findTeachers("");
		List courseList = cs.findAllCourses();
		
		req.setAttribute("stuclass", stuclassList);
		req.setAttribute("teacher", teacherList);
		req.setAttribute("course", courseList);
		req.getRequestDispatcher("manager/scheduleadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tcCourseId = req.getParameter("course");
		String tcTeacherId = req.getParameter("teacher");
		String tcStuClassId = req.getParameter("stuClass");
		System.out.println(tcCourseId);
		System.out.println(tcTeacherId);
		System.out.println(tcStuClassId);
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(tcCourseId),Integer.valueOf(tcTeacherId),Integer.valueOf(tcStuClassId));
		cs.addSchedule(tc);
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
	}
}
