package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet{
	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tid = req.getParameter("id");
		Map<String,Object> teacherMap = ts.findTeacherInfo(Integer.valueOf(tid));
		req.setAttribute("teacher", teacherMap);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/teachermodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tid = req.getParameter("teacherId");
		String tname = req.getParameter("teachername");
		String tpwd = req.getParameter("teacherpwd");
		String deptName = req.getParameter("depInfo");
		Teacher t = new Teacher(tname,tpwd,deptName);
		ts.updateTeacher(t, Integer.valueOf(tid));
		req.getRequestDispatcher("/teacherQueryServlet").forward(req, resp);
	}
}
