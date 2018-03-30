package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Paper;
import com.hp.onlinexam.util.DBUtil;

public class PapersDao implements IPapersDao {

	private DBUtil db = new DBUtil();
	@Override
	public void save(Paper paper) {
		String sql = "insert into paper(testId,courseId,time,score,wrongQueIds,wrongAns,studentId,createDate) values(?,?,?,?,?,?,?,CURRENT_TIME)";
		try {
			db.execute(sql, new Object[] {paper.getTestId(),paper.getCourseId(),paper.getTime(),paper.getScore(),paper.getWrongQueIds(),paper.getWrongAns(),paper.getStudentId()});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List getPaperByStudentId(int studentId, int testId) {
		return null;
	}

	@Override
	public List getPaperByStudentId(int studentId) {
		String sql = "select c.cname,t.name,p.time,p.createDate,p.score from course c,paper p,test t,student s where p.courseId = c.cid and t.id = p.testId and s.sid = ?";
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[] {studentId});
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

	@Override
	public List getPaperCompare(int teaId) {
		String sql = "SELECT stuclass.scname,stuclass.deptName,course.cname,test.`name`,test.endDate,avg(paper.score) as avgScore from stuclass,course,test,paper,student where test.courseId = course.cid and find_in_set(student.classId,test.classIds) and test.teacherId = ? and paper.testId = test.id and paper.studentId = student.sid and student.classId = stuclass.scid and test.endDate < CURRENT_TIMESTAMP group by student.classId,test.id";
		List paperList = new ArrayList();
		try {
			paperList = db.getQueryList(sql, new Object[] {teaId});
		} catch (Exception e) {
			paperList = new ArrayList();
			e.printStackTrace();
		}
		return paperList;
	}

}
