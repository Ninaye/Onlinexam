package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.PaperService;

@WebServlet("/papersCompareServlet")
public class PapersCompareServlet extends HttpServlet{

	private IPaperService ps = new PaperService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		List pcList = ps.getPaperCompare(teacher.getTid());
		req.setAttribute("paperList", pcList);
		req.getRequestDispatcher("teacher/classpapers.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
