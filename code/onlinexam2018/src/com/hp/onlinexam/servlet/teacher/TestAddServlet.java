package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/testAddServlet")
public class TestAddServlet extends HttpServlet{

	private ICourseService cs = new CourseService();
	private IStuClassService ss = new StuClassService();
	private IQuestionService qs = new QuestionService();
	private IStuClassService scs = new StuClassService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 在用户登入的时候把用户的信息放到Session里
		 */
		Teacher t = (Teacher)req.getSession().getAttribute("user");
		List courseList = cs.findCoursesByTeacherId(t.getTid());
		List classesList = ss.findStuClassesByTeacherId(t.getTid());
		req.setAttribute("courseList", courseList);
		req.setAttribute("classesList", classesList);
		req.getRequestDispatcher("teacher/testadd.jsp").forward(req, resp);
	}
	/*
	 * 组合
	 * 1、从页面上获取试卷基本信息，把基本信息传递到下一个页面
	 * 2、获取试卷题目的相关信息，随机抽题组卷，把尸体传递到下一个页面
	 * 3、页面跳转
	 */
	/*
	 * 为了封装成text对象，并把记录插入到数据库
	 * 1、日期格式的转换
	 * 2、班级id号的格式转换
	 * 3、根据试题的数量随机出题（集合），封装到text对象
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String  courseId = req.getParameter("courseid");
		String  sinNum = req.getParameter("sinnum");
		if("".equals(sinNum))
			sinNum = "0";
		
		List<Map<String,Object>> quesList = qs.collectQuestions(Integer.valueOf(courseId), Integer.valueOf(sinNum));
		String questionIds = qs.testQuestionIds(quesList);
		
		String  testName = req.getParameter("testname");
		String  sinScores = req.getParameter("sinscores");
		String  testTime = req.getParameter("testtime");
		
		String  endDate = req.getParameter("enddate");
		endDate += " 00:00:00";
		
		Timestamp date = Timestamp.valueOf(endDate);
		
		String[]  classCheckIdList = req.getParameterValues("classCheck");
		String classIds = ToolUtil.arraytoString(classCheckIdList);
		String  classNames = scs.findClassNamesByIds(classIds);
		
		Teacher teacher = (Teacher)req.getSession().getAttribute("user");
		Test t = new Test(testName, Integer.valueOf(courseId), date, Integer.valueOf(testTime), questionIds, teacher.getTid(),classIds, sinScores);
		Course c = cs.findCourseById(Integer.valueOf(courseId));
		
		req.getSession().setAttribute("test", t);
		req.setAttribute("c", c);
		req.setAttribute("classNames", classNames);
		req.setAttribute("quesList", quesList);
		req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
	}
	
}
