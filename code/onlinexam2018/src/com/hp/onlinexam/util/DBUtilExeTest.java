package com.hp.onlinexam.util;

public class DBUtilExeTest {

	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "insert into course(cname) values('数据结构');";
		db.execute(sql);
		
		String sql2 = "insert into course(cname) values(?)";
		db.execute(sql2, new Object[] {"sds"});
		
		String sql3 = "delete from course where cname = ?";
		db.execute(sql3, new Object[] {"sds"});
	}
}
