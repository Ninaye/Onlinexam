package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Test;

/*public class DBUtilQueryTest {

	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from test where courseId = ? && teacherId = ?";
		List<Map<String, Object>> testList = db.getQueryList(sql, new Object[] { "1", "2" });
		for (int i = 0; i < (int) testList.size(); i++) {
			Map<String, Object> testMap = testList.get(i);
			Iterator<Entry<String, Object>> it = testMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, Object> entry = (Entry<String, Object>) it.next();
				System.out.println(entry);
			}
			System.out.println("");
		}
	}
}*/

/*
 * 数组是一类相同数据类型的集合
 * 声明，仅仅是定义数据类型和变量名
 * 定义：除了声明外，有赋值
 * 数组声明，[]可以放变量前，也可以放变量后
 */

public class DBUtilQueryTest {
	
	public static void main(String[] args) throws Exception {
		DBUtil db = new DBUtil();
		String sql = "select * from test where courseId = ? && teacherId = ?";
		List<Class<?>> testList = db.getQueryList(Test.class, sql, new Object[] { 1, 2 });
		
		/*
		 * 第一种遍历方式
		 */
		for (int i = 0; i < testList.size(); i++) {
			Object o = testList.get(i);
			System.out.println(((Test)o).toString());
		}
		
		/*
		 * 第二种遍历方式
		 */
		for(Object o : testList) {
			Test t = (Test) o;
			System.out.println(t);
		}
	}
}
