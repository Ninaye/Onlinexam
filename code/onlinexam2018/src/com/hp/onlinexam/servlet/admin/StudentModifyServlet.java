package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {

	private IStudentService ss = new StudentService();
	private IStuClassService scs = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sid = req.getParameter("id");
		Student student = ss.findStudentById(Integer.valueOf(sid));
		List stuclassList = scs.findAll();
		req.setAttribute("student", student);
		req.setAttribute("stuclassList", stuclassList);
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studetnId = req.getParameter("studentId");
		String studentName = req.getParameter("studentName");
		String studenSchool = req.getParameter("school");
		String studentpwd = req.getParameter("studentpwd");
		String studentSex = req.getParameter("sex");
		String studentBorn = req.getParameter("date");
		String stuClassId = req.getParameter("stuClass");
		java.sql.Date date = java.sql.Date.valueOf(studentBorn);
		Student s = new Student(Integer.valueOf(studetnId), studentName, studentpwd, studenSchool, studentSex,
				date, Integer.valueOf(stuClassId));
		ss.updateStudent(s);
		req.getRequestDispatcher("/studentQueryServlet").forward(req, resp);
	}

}
