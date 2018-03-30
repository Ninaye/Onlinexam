package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.dao.admin.CourseDao;
import com.hp.onlinexam.dao.admin.ICourseDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService {

	private ICourseDao cd = new CourseDao();

	@Override
	public List<TeacherCourseView> findAll() {
		return cd.findAllTeaCourInfo();
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		return cd.findTeacherCourseById(id);
	}

	@Override
	public Course findCourseById(int id) {
		return cd.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses() {
		return cd.findAllCourses();
	}

	@Override
	public List<Course> findAllCourses(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		cd.deleteTourse(tcId);

	}

	@Override
	public void addCourse(String courseName) {
		cd.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		cd.updateCourse(course);
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		cd.addTeacherCourse(tc);
	}

	public void updateSchedule(TeacherCourse tc) {
		cd.updateTeacherCourse(tc);
	}
	
	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		return cd.findCoursesByTeacherId(teaId);
	}

}
