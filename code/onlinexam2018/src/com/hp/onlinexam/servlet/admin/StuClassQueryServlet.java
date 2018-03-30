package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;

/*
 * 用于查询班级信息
 * @author Ninaye
 * 
 */
@WebServlet("/stuClassQueryServlet")
public class StuClassQueryServlet extends HttpServlet {

	private IStuClassService scs = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * Servlet的职能：
		 * 1、接受用户的请求
		 * 2、从业务层获取结果
		 * 3、把结构封装并传递到页面
		 * 4、页面跳转
		 */
		List stuClassList = scs.findAll();
		/*
		 * 使用requst.setAttribute把结果放到页面
		 * 第一个参数是key，第二个是value
		 */
		req.setAttribute("stuclassList", stuClassList);
		req.getRequestDispatcher("manager/stuclassmanage.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}