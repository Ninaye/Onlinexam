package com.hp.onlinexam.po;

public class StuClass {
	private int scid;
	private String scname;
	private String deptName;

	public StuClass() {
		
	};
	public StuClass(int scid,String scname,String deptName) {
		this.scid = scid;
		this.scname = scname;
		this.deptName = deptName;
	}
	public int getScid() {
		return scid;
	}

	public void setScid(int scid) {
		this.scid = scid;
	}

	public String getScname() {
		return scname;
	}

	public void setScname(String scname) {
		this.scname = scname;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "StuClassView [scid=" + scid + ", scname=" + scname + ", deptName=" + deptName + "]";
	}

}
