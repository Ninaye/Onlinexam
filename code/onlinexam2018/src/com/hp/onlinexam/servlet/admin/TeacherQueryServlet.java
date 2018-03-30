package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherQueryServlet")
public class TeacherQueryServlet extends HttpServlet {

	private ITeacherService ts = new TeacherService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherName = req.getParameter("teaname");
		if(null == teacherName)
			teacherName = "";
		List teacherList = ts.findTeachers(teacherName);
		/*
		 * 使用requst.setAttribute把结果放到页面 第一个参数是key，第二个是value
		 */
		req.setAttribute("teacherList", teacherList);
		req.getRequestDispatcher("manager/teachermanage.jsp").forward(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
