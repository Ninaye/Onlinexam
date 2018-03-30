package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.util.DBUtil;

public class TestDao implements ITestDao {

	private DBUtil db = new DBUtil();

	@Override
	public void createTest(Test t) {
		String sql = "insert into test(name,courseId,endDate,testTime,questions,teacherId,classIds,scores) value(?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { t.getName(), t.getCourseId(), t.getEndDate(), t.getTestTime(),
					t.getQuestions(), t.getTeacherId(), t.getClassIds(), t.getScores() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findTestsByTeaId(int teaId) {
		String sql = "select t.*,c.cname,GROUP_CONCAT(sc.scname) as classNames from test t,course c,stuclass as sc where t.courseId = c.cid and t.endDate > CURRENT_TIMESTAMP and FIND_IN_SET(sc.scid,t.classIds) and t.teacherId = ? GROUP BY t.id";
		List testList = new ArrayList();
		try {
			testList = db.getQueryList(sql, new Object[] { teaId });
		} catch (Exception e) {
			testList = new ArrayList();
			e.printStackTrace();
		}
		return testList;
	}

	@Override
	public Map<String, Object> findTestById(int id, int teaId) {
		String sql = "select test.id,course.cname,test.name,test.endDate,test.testTime,test.classIds,test.scores,test.questions from course,test where test.teacherId = ? and test.courseId = course.cid and test.id = ?";
		Map<String, Object> testMap = new HashMap();
		try {
			testMap = db.getObject(sql, new Object[] { teaId, id });
		} catch (Exception e) {
			testMap = new HashMap();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public Map<String, Object> findStudentTestsById(int studentid, int testid) {
		String sql = "select t.*,c.cname,sc.scname from student s,test t,course c,stuclass sc where t.id = ? and s.sid = ? and t.courseId = c.cid and s.classId = sc.scid and t.id not in(select testId from paper where paper.studentId = ?)";
		Map<String,Object> testMap = new HashMap<String,Object>();
		try {
			testMap = db.getObject(sql, new Object[] {testid,studentid,studentid});
		} catch (Exception e) {
			testMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return testMap;
	}

	@Override
	public List<Map<String, Object>> getTestByStudent(int sid) {
		String sql = "select test.*,course.cname from test,student,course where student.sid = ? and student.classId in (test.classIds) and test.endDate > CURRENT_TIMESTAMP and test.courseId = course.cid and test.id not in (select testId from paper where paper.studentId = ?)";
		List<Map<String, Object>> testList = new ArrayList<Map<String, Object>>();
		try {
			testList = db.getQueryList(sql, new Object[] { sid,sid });
		} catch (Exception e) {
			testList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return testList;
	}
}
