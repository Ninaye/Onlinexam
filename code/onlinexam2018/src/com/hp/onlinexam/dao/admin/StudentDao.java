package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.StudentClassView;

public class StudentDao implements IStudentDao {

	private DBUtil db = new DBUtil();

	@Override
	public void addStudent(Student s) {
		String sql = "insert into student(sid,sname,spwd,school,sex,born,classId) values(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[] { s.getSid(), s.getSname(), s.getSpwd(), s.getSchool(), s.getSex(),
					s.getBorn().toString(), s.getClassId() });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudentById(int sid) {
		String sql = "delete from student where sid = ?";
		try {
			db.execute(sql, new Object[] { sid });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql = "update student set sname = ?,spwd = ?,school = ?,sex = ?,classId = ?,born = ? where sid = ?";
		try {
			db.execute(sql, new Object[] { s.getSname(), s.getSpwd(), s.getSchool(), s.getSex(),
					s.getClassId(), s.getBorn().toString(), s.getSid() });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Student findStudentById(int id) {
		String sql = "select * from student where sid = ?";
		Student s = new Student();
		try {
			s = (Student) db.getObject(Student.class, sql, new Object[] { id });
		} catch (Exception e) {
			s = new Student();
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		String sql = "select student.sid,student.sname,student.spwd,student.sex,student.born,stuclass.scname,stuclass.deptName,student.school,student.classId from student,stuclass where student.classId = stuclass.scid";
		List studentList = new ArrayList();
		try {
			studentList = db.getQueryList(StudentClassView.class, sql, new Object[] {});
		} catch (Exception e) {
			studentList = new ArrayList();
			e.printStackTrace();
		}
		return studentList;
	}
}
