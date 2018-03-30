package com.hp.onlinexam.po;

import java.sql.Date;

public class Paper {
	private int pid;
	private int testId;
	private int courseId;
	private String time;
	private double score;
	private String wrongQueIds;
	private String wrongAns;
	private int studentId;
	private Date createDate;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getWrongQueIds() {
		return wrongQueIds;
	}

	public void setWrongQueIds(String wrongQueIds) {
		this.wrongQueIds = wrongQueIds;
	}

	public String getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Papers [pid=" + pid + ", testId=" + testId + ", courseId=" + courseId + ", time=" + time + ", score="
				+ score + ", wrongQueIds=" + wrongQueIds + ", wrongAns=" + wrongAns + ", studentId=" + studentId
				+ ", createDate=" + createDate + "]";
	}
	
}