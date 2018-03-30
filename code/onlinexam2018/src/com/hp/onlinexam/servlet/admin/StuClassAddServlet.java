package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {

	private IStuClassService scs = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("deptList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		/*
		 * 获取请求参数
		 */
		String stuName = req.getParameter("stuname");
		String depInfo = req.getParameter("depInfo");
		/*
		 * 把请求参数封装成对象 封装的目的是为了调用业务层的方法
		 */
		StuClass sc = new StuClass();
		sc.setScname(stuName);
		sc.setDeptName(depInfo);
		scs.addstuClass(sc);
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req, resp);
	}

}
