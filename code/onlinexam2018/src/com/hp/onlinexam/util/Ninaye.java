package com.hp.onlinexam.util;

import java.util.List;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.po.Test;

public class Ninaye {

	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		
		System.out.println("第一小题");
		String sql1 = "select student.sname,papers.score from student,papers where student.sname like '张%' && student.sid = papers.studentId";
		List questionsList1 = db.getQueryList(sql1);
		for(Object o : questionsList1) {
			System.out.println(o);
		}
		
		System.out.println("第二小题");
		String sql2 = "select teacher.tname,teachercourse.* from teacher,teachercourse where teacher.tname = 'lisi' && teacher.tid = teachercourse.teacherId";
		List questionsList2 = db.getQueryList(sql2);
		for(Object o : questionsList2) {
			System.out.println(o);
		}
		
		System.out.println("第三小题");
		String sql3 = "select * from questions";
		List<Class<?>> questionsList3 = db.getQueryList(Question.class, sql3, new Object[] {});
		for (int i = 0; i < questionsList3.size(); i++) {
			Object o = questionsList3.get(i);
			Question ques = (Question)o;
			System.out.println(ques.toString());
		}
	}
}