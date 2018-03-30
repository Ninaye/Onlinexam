package com.hp.onlinexam.dao.teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Question;
import com.hp.onlinexam.util.DBUtil;

public class QuestionDao implements IQuestionDao {

	private DBUtil db = new DBUtil();

	@Override
	public List<Map<String, Object>> findAllQuestionInfo(String key, String value) {
		String sql = "select q.qid,q.courseId,q.queType,q.queTitle,q.choiceA,q.choiceB,q.choiceC,q.choiceD,q.ans,c.cname from question q,course c where c.cid = q.courseId and q.queExist = 1";
		if (null != key && !"".equals(key)) {
			sql += " and " + key + " like '%" + value + "%'";
		}
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] {});
		} catch (Exception e) {
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void addQuestion(Question q) {
		String sql = "insert into question(courseId,queType,queTitle,choiceA,choiceB,choiceC,choiceD,ans,queExist) values(?,?,?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns(), q.getQueExist() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findQuestionById(int id) {
		String sql = "select q.qid,q.courseId,q.queType,q.queTitle,q.choiceA,q.choiceB,q.choiceC,q.choiceD,q.ans,c.cname from question q,course c where c.cid = q.courseId and q.qid = ?";
		Map<String, Object> queMap = new HashMap<String, Object>();
		try {
			queMap = db.getObject(sql, new Object[] { id });
		} catch (Exception e) {
			queMap = new HashMap<String, Object>();
			e.printStackTrace();
		}
		return queMap;
	}

	@Override
	public List<Question> findQuestionByIds(String ids) {
		//String sql = "select * from question where FIND_IN_SET(qid,'" + ids + "')";
		String sql = "SELECT * FROM question WHERE qid IN(" + ids + ") ORDER BY INSTR('," + ids + ",',CONCAT(',',qid,','))";
		List quesList = new ArrayList();
		try {
			quesList = db.getQueryList(Question.class, sql, new Object[] {});
		} catch (Exception e) {
			quesList = new ArrayList();
			e.printStackTrace();
		}
		return quesList;
	}

	@Override
	public void updateQuestionInfo(Question q) {
		String sql = "update question set courseId = ?,queType = ?,queTitle = ?,choiceA = ?,choiceB = ?,choiceC = ?,choiceD = ?,ans = ?,queExist = ? where qid = ?";
		try {
			db.execute(sql, new Object[] { q.getCourseId(), q.getQueType(), q.getQueTitle(), q.getChoiceA(),
					q.getChoiceB(), q.getChoiceC(), q.getChoiceD(), q.getAns(), q.getQueExist(), q.getQid() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Map<String, Object>> findQuestionsByCourseId(int courseId) {
		String sql = "select * from question where courseId = ? and queExist = 1";
		List<Map<String, Object>> queList = new ArrayList<Map<String, Object>>();
		try {
			queList = db.getQueryList(sql, new Object[] { courseId });
		} catch (Exception e) {
			queList = new ArrayList<Map<String, Object>>();
			e.printStackTrace();
		}
		return queList;
	}

	@Override
	public void deleteQuestion(int id) {
		String sql = "update question set queExist = 0 where qid = ?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
