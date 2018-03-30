package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;

public interface IStudentService {
	public void addStudent(Student s);

	public void deleteStudentById(int sid);

	public void updateStudent(Student s);

	public Student findStudentById(int id);

	public List<Map<String, Object>> findAll();
}
