package com.hp.onlinexam.po;

public class Teacher {
	private int tid;
	private String tname;
	private String tpwd;
	private String deptName;

	public Teacher() {};
	public Teacher(String tname,String tpwd,String deptName) {
		this.tname = tname;
		this.tpwd = tpwd;
		this.deptName = deptName;
	}
	public Teacher(int tid,String tname,String tpwd,String deptName) {
		this.tid = tid;
		this.tname = tname;
		this.tpwd = tpwd;
		this.deptName = deptName;
	}
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTpwd() {
		return tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tpwd=" + tpwd + ", deptName=" + deptName + "]";
	}

}
