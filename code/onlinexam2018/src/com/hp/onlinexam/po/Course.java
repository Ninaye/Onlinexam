package com.hp.onlinexam.po;

/**
 * 实体类用po 课程类，描述课程实体
 */

public class Course {
	/**
	 * java数据类型有基本数据类型和应用数据类型
	 * 基本数据类型有8种，byte,short,int,long,float,double,char,boolean 应用数据类型：类、接口、数组
	 */
	private int cid;
	private String cname;

	public Course() {
	}

	public Course(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}

}