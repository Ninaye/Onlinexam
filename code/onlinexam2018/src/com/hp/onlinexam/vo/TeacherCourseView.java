package com.hp.onlinexam.vo;

public class TeacherCourseView {
	private int tcId;
	private int tcCourseId;
	private String cname;
	private int tcTeacherId;
	private String tname;
	private int tcStuClassId;
	private String scname;
	private String deptName;

	public int getTcId() {
		return tcId;
	}

	public int getTcCourseId() {
		return tcCourseId;
	}

	public String getCname() {
		return cname;
	}

	public int getTcTeacherId() {
		return tcTeacherId;
	}

	public String getTname() {
		return tname;
	}

	public int getTcStuClassId() {
		return tcStuClassId;
	}

	public String getScname() {
		return scname;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public void setTcCourseId(int tcCourseId) {
		this.tcCourseId = tcCourseId;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setTcTeacherId(int tcTeacherId) {
		this.tcTeacherId = tcTeacherId;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public void setTcStuClassId(int tcStuClassId) {
		this.tcStuClassId = tcStuClassId;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "TeacherCourseView [tcId=" + tcId + ", tcCourseId=" + tcCourseId + ", cname=" + cname + ", tcTeacherId="
				+ tcTeacherId + ", tname=" + tname + ", tcStuClassId=" + tcStuClassId + ", scname=" + scname
				+ ", deptName=" + deptName + "]";
	}

}
