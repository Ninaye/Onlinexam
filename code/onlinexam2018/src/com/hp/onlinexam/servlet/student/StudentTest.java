package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.teacher.IPaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.PaperService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {

	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();
	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testId = req.getParameter("testId");
		Student s = (Student) req.getSession().getAttribute("user");
		
		Map<String, Object> testMap = ts.findStudentTestsById(s.getSid(), Integer.valueOf(testId));
		req.getSession().setAttribute("test", testMap);
		
		List quesList = qs.findQuestionByIds((String)testMap.get("questions"));
		req.getSession().setAttribute("quesList", quesList);
		
		double scoreperques = Integer.valueOf((String)testMap.get("scores"));
		scoreperques = scoreperques/quesList.size();
		req.setAttribute("scoreperques", scoreperques);
		req.getRequestDispatcher("student/exam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String time = req.getParameter("hidden1");
		List quesList = (List) req.getSession().getAttribute("quesList");
		Map testMap = (Map) req.getSession().getAttribute("test");
		if(null == quesList || quesList.size() < 1)
			return ;
		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();
		
		int wrongQueNum = 0;
		for(int i = 0; i < quesList.size(); i++) {
			Question q = (Question) quesList.get(i);
			String ans = req.getParameter("ques_"+q.getQid());
			if(!q.getAns().equals(ans)) {
				wrongQueId.append(q.getQid()).append(",");
				wrongAns.append(ans).append(",");
				wrongQueNum++;
			}
		}
		Paper p = new Paper();
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("courseId"));
		p.setTime(time);
		if (quesList.size()>wrongQueNum)
			p.setScore(1.0*Integer.parseInt((String) (testMap.get("scores")))/quesList.size()*(quesList.size()-wrongQueNum));
		else
			p.setScore(0);
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		if (wrongQueIdString.endsWith(",")){
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length()-1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length()-1);
		}
		p.setWrongQueIds(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		Student s = (Student) req.getSession().getAttribute("user");
		p.setStudentId(s.getSid());
		ps.save(p);
	    req.getRequestDispatcher("/recentTestServlet").forward(req, resp);
	}
}