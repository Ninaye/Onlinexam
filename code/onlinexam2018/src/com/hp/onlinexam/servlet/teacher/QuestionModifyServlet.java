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
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionModifyServlet")
public class QuestionModifyServlet extends HttpServlet {

	private IQuestionService qs = new QuestionService();
	private ICourseService cs = new CourseService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qid = req.getParameter("id");
		Map<String, Object> queMap = qs.findQuestionById(Integer.valueOf(qid));
		List courseList = cs.findAllCourses();
		req.setAttribute("que", queMap);
		req.setAttribute("courseList", courseList);
		req.getRequestDispatcher("teacher/quesmodify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qid = req.getParameter("id");
		String courseId = req.getParameter("courseId");
		int queType = 1;
		String queTitle = req.getParameter("queTitle");
		String choiceA = req.getParameter("choiceA");
		String choiceB = req.getParameter("choiceB");
		String choiceC = req.getParameter("choiceC");
		String choiceD = req.getParameter("choiceD");
		String ans = req.getParameter("ans");
		int queExist = 1;
		Question q = new Question(Integer.valueOf(qid), Integer.valueOf(courseId), queType, queTitle, choiceA, choiceB, choiceC, choiceD, ans, queExist);
		qs.updateQuestionInfo(q);
		req.getRequestDispatcher("/questionQueryServlet").forward(req, resp);
	}

}
