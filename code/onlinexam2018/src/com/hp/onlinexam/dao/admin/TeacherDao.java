package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class TeacherDao implements ITeacherDao {

	private DBUtil db = new DBUtil();

	@Override
	public List<Teacher> findAllTeacherByInfo(String tname) {
		String sql = "select * from teacher";
		if(!"".equals(tname)) {
			sql += " where tname like '%" + tname + "%'";
		}
		List teaList = new ArrayList();
		try {
			teaList = db.getQueryList(sql);
		}
		catch (Exception e) {
			/*
			 * 如果不加new，teaList可能会是null或者出现异常，导致程序不能执行
			 */
			teaList = new ArrayList();
			e.printStackTrace();
		}
		return teaList;
	}

	@Override
	public void addTeacher(Teacher teacher) {
		String sql = "insert into teacher(tname,tpwd,deptName) values(?,?,?)";
		try {
			db.execute(sql, new Object[] {teacher.getTname(),teacher.getTpwd(),teacher.getDeptName()});
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	} 	

	@Override
	public void updateTeacher(Teacher teacher, int oldId) {
		String sql = "update teacher set tname = ?,tpwd = ?,deptName = ? where tid = ?";
		try {
			db.execute(sql, new Object[] {teacher.getTname(),teacher.getTpwd(),teacher.getDeptName(),oldId});
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from teacher where tid = ?";
		Map<String,Object> teacherMap = new HashMap<String,Object>();
		try {
			teacherMap = db.getObject(sql, new Object[] {id});
		} 
		catch (Exception e) {
			teacherMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return teacherMap;
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void deleteTeacher(int tid) {
		String sql = "delete from teacher where tid = ?";
		try {
			db.execute(sql, new Object[] {tid});
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
