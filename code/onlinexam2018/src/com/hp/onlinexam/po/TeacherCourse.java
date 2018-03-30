package com.hp.onlinexam.po;

public class TeacherCourse {
	private int tcId;
	private int tcCourseId;
	private int tcTeacherId;
	private int tcStuClassId;

	public TeacherCourse() {
	}

	public TeacherCourse(int tcCourseId, int tcTeacherId, int tcStuClassId) {
		this.tcCourseId = tcCourseId;
		this.tcTeacherId = tcTeacherId;
		this.tcStuClassId = tcStuClassId;
	}
	
	public TeacherCourse(int tcId,int tcCourseId, int tcTeacherId, int tcStuClassId) {
		this.tcId = tcId;
		this.tcCourseId = tcCourseId;
		this.tcTeacherId = tcTeacherId;
		this.tcStuClassId = tcStuClassId;
	}

	public int getTcId() {
		return tcId;
	}

	public int getTcCourseId() {
		return tcCourseId;
	}

	public int getTcTeacherId() {
		return tcTeacherId;
	}

	public int getTcStuClassId() {
		return tcStuClassId;
	}

	public void setTcId(int tcId) {
		this.tcId = tcId;
	}

	public void setTcCourseId(int tcCourseId) {
		this.tcCourseId = tcCourseId;
	}

	public void setTcTeacherId(int tcTeacherId) {
		this.tcTeacherId = tcTeacherId;
	}

	public void setTcStuClassId(int tcStuClassId) {
		this.tcStuClassId = tcStuClassId;
	}

	@Override
	public String toString() {
		return "TeacherCourse [tcId=" + tcId + ", tcCourseId=" + tcCourseId + ", tcTeacherId=" + tcTeacherId
				+ ", tcStuClassId=" + tcStuClassId + "]";
	}

}
