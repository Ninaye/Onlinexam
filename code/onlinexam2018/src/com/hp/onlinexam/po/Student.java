package com.hp.onlinexam.po;

import java.sql.Date;

public class Student {
	private int sid;
	private String sname;
	private String spwd;
	private String school;
	private String sex;
	private Date born;
	private int classId;

	public Student() {
	};

	public Student(int id, String name, String pwd, String school, String sex, Date born,
			int classId) {
		this.sid = id;
		this.sname = name;
		this.spwd = pwd;
		this.school = school;
		this.sex = sex;
		this.born = born;
		this.classId = classId;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpwd() {
		return spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd + ", school=" + school + ", sex=" + sex
				+ ", born=" + born + ", classId=" + classId + "]";
	}
}