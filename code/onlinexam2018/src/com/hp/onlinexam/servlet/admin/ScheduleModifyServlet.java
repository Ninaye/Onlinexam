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
import com.hp.onlinexam.vo.TeacherCourseView;

@WebServlet("/scheduleModifyServlet")
public class ScheduleModifyServlet extends HttpServlet {

	private IStuClassService scs = new StuClassService();
	private ITeacherService ts = new TeacherService();
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		List stuclassList = scs.findAll();
		List teacherList = ts.findTeachers("");
		List courseList = cs.findAllCourses();
		TeacherCourse tc = cs.findTeacherCourseById(Integer.valueOf(id));
		
		req.setAttribute("tc", tc);
		req.setAttribute("stuclass", stuclassList);
		req.setAttribute("teacher", teacherList);
		req.setAttribute("course", courseList);
		req.getRequestDispatcher("manager/schedulemodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tcId = req.getParameter("id");
		String courseId = req.getParameter("course");
		String teacherId = req.getParameter("teacher");
		String stuClassId = req.getParameter("stuClass");
		TeacherCourse tc = new TeacherCourse(Integer.valueOf(tcId),Integer.valueOf(courseId),Integer.valueOf(teacherId),Integer.valueOf(stuClassId));
		cs.updateSchedule(tc);
		req.getRequestDispatcher("/scheduleQueryServlet").forward(req, resp);
	}

}
