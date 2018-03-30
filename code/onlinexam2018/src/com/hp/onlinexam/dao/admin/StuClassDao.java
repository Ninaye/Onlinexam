package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.StuClass;
import com.hp.onlinexam.util.DBUtil;

public class StuClassDao implements IStuClassDao {

	private DBUtil db = new DBUtil();

	@Override
	public List findAllStuClassInfo() {
		String sql = "select * from stuclass";
		List stuclassList = new ArrayList();
		try {
			stuclassList = db.getQueryList(StuClass.class, sql, new Object[] {});
		} catch (Exception e) {
			stuclassList = new ArrayList();
			e.printStackTrace();
		}
		return stuclassList;
	}

	@Override
	public Map<String, Object> findStuClassById(int classId) {
		String sql = "select * from stuclass where scid = ?";
		Map<String,Object> stuMap = new HashMap<String,Object>();
		try {
			stuMap = db.getObject(sql, new Object[] {classId});
		}
		catch(Exception e){
			stuMap = new HashMap<String,Object>();
			e.printStackTrace();
		}
		return stuMap;
	}

	@Override
	public void addStuClass(StuClass sc) {
		String sql = "insert into stuclass(scname,deptName) values(?,?)";
		try {
			db.execute(sql, new Object[] {sc.getScname(),sc.getDeptName()});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStuClassById(StuClass sc) {
		String sql = "update stuclass set scname = ?,deptName = ? where scid = ?";
		try {
			db.execute(sql, new Object[] {sc.getScname(),sc.getDeptName(),sc.getScid()});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deteleStuClassById(int ClassId) {
		String sql = "delete from stuclass where scid = ?";
		try {
			db.execute(sql,new Object[] {ClassId});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findClassNamesByIds(String ids) {
		String sql = "select scname from stuclass where scid in (" + ids + ")";
		List<Map<String,Object>> scnameList = new ArrayList();
		try {
			scnameList = db.getQueryList(sql);
		} catch (Exception e) {
			scnameList = new ArrayList();
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < scnameList.size(); i++) {
			if(i < scnameList.size()-1)
				sb.append(scnameList.get(i).get("scname") + " ");
			else
				sb.append(scnameList.get(i).get("scname"));
		}
		return sb.toString();
	}

	@Override
	public List<StuClass> findStuClassesByTeacherId(int teaId) {
		String sql = "select * from stuclass where scid in(select tcStuClassId from teachercourse where tcTeacherId = ?)";
		List stuClassList = new ArrayList();
		try {
			stuClassList = db.getQueryList(StuClass.class, sql, new Object[] {teaId});
		} catch (Exception e) {
			stuClassList = new ArrayList();
			e.printStackTrace();
		}
		return stuClassList;
	}

	public static void main(String[] args) {
		/*
		 * 在声明的时候一般会向上转型，向上转型有父类和子类的关系
		 * 有接口和实现类之间的关系
		 * 优点之一：如果接口有多个实现，使用向上转型直接改定义这一行即可
		 */
		IStuClassDao scd = new StuClassDao();
		List scList = scd.findAllStuClassInfo();
	}

}
