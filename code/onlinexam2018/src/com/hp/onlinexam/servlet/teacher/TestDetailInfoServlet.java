package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testDetailInfoServlet")
public class TestDetailInfoServlet extends HttpServlet{

	private ITestService ts = new TestService();
	private IStuClassService scs = new StuClassService();
	private IQuestionService qs = new QuestionService();	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		Map testMap = ts.findTestById(Integer.valueOf(id), teacher.getTid());
		req.setAttribute("test", testMap);
		
		String  classNames = scs.findClassNamesByIds((String)testMap.get("classIds"));
		req.setAttribute("classNames", classNames);
		
		List<Question> quesList = qs.findQuestionByIds((String)testMap.get("questions"));
		req.setAttribute("quesList", quesList);
		
		req.getRequestDispatcher("teacher/viewtest.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/testQueryServlet").forward(req, resp);
	}
	
}
