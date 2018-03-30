package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.PaperService;

@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet{

	private IPaperService ps = new PaperService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student s = (Student)req.getSession().getAttribute("user");
		List paperList = ps.getPaperByStudentId(s.getSid());
		req.setAttribute("paperList", paperList);
		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}
}