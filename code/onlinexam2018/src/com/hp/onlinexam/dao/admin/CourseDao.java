package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {

	private DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		String sql = "select teachercourse.tcId,teachercourse.tcCourseId,course.cname,stuclass.deptName,teachercourse.tcTeacherId,teacher.tname,teachercourse.tcStuClassId,stuclass.scname from teachercourse,course,stuclass,teacher where teachercourse.tcCourseId = course.cid && teachercourse.tcTeacherId = teacher.tid && teachercourse.tcStuClassId = stuclass.scid";
		List teacherCourseViewList = new ArrayList();
		try {
			teacherCourseViewList = db.getQueryList(TeacherCourseView.class, sql, new Object[] {});
		} catch (Exception e) {
			teacherCourseViewList = new ArrayList();
			e.printStackTrace();
		}
		return teacherCourseViewList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "select * from teachercourse where tcId = ?";
		TeacherCourse tc = new TeacherCourse();
		try {
			tc = (TeacherCourse) db.getObject(TeacherCourse.class, sql, new Object[] { id });
		} catch (Exception e) {
			tc = new TeacherCourse();
			e.printStackTrace();
		}
		return tc;
	}

	@Override
	public void addCourse(String name) {
		String sql = "insert into course(cname) values(?)";
		try {
			db.execute(sql, new Object[] { name });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set cname = ? where cid = ?";
		try {
			db.execute(sql, new Object[] { course.getCname(), course.getCid() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where cid = ?";
		Course c = new Course();
		try {
			c = (Course) db.getObject(Course.class, sql, new Object[] { id });
		} catch (Exception e) {
			c = new Course();
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {
		String sql = "insert into teachercourse(tcCourseId,tcTeacherId,tcStuClassId) values(?,?,?)";
		try {
			db.execute(sql, new Object[] { tc.getTcCourseId(), tc.getTcTeacherId(), tc.getTcStuClassId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses() {
		String sql = "select * from course";
		List cList = new ArrayList<Course>();
		try {
			cList = db.getQueryList(sql);
		} catch (Exception e) {
			cList = new ArrayList<Course>();
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {
		String sql = "update teachercourse set tcCourseId = ?,tcTeacherId = ?,tcStuClassId = ? where tcId = ?";
		try {
			db.execute(sql,
					new Object[] { tc.getTcCourseId(), tc.getTcTeacherId(), tc.getTcStuClassId(), tc.getTcId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql = "delete from teachercourse where tcId = ?";
		try {
			db.execute(sql, new Object[] { tcId });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql = "select * from course where cid in(select tccourseId from teachercourse where tcTeacherId = ?)";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[] { teaId });
		} catch (Exception e) {
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

}
