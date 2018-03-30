package com.hp.onlinexam.vo;

import java.sql.Date;

public class StudentClassView {
	private int sid;
	private String sname;
	private String spwd;
	private String school;
	private String deptName;
	private String sex;
	private Date born;
	private int classId;
	private String scname;

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}

	public String getSpwd() {
		return spwd;
	}

	public String getSchool() {
		return school;
	}

	public String getDeptName() {
		return deptName;
	}

	public String getSex() {
		return sex;
	}

	public Date getBorn() {
		return born;
	}

	public int getClassId() {
		return classId;
	}

	public String getScname() {
		return scname;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	@Override
	public String toString() {
		return "StudentClassView [sid=" + sid + ", sname=" + sname + ", spwd=" + spwd + ", school=" + school
				+ ", deptName=" + deptName + ", sex=" + sex + ", born=" + born + ", classId=" + classId + ", scname="
				+ scname + "]";
	}
}
