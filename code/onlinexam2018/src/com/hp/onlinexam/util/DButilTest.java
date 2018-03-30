package com.hp.onlinexam.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Test;

/*
 * 第三天
 * 
 * 如果一个方法是静态方法、可以使用类名.方法使用
 * 如果一个方法是普通方法,则需要使用构造方法创建对象调用
 * 
 * 数组:一旦创建了数组,数组大小不可变
 * 集合框架 :List,Set,Map
 * Map的优势在于,使用键值对,使用键值对的好处在于,键是唯一的,可以通过键直接获取值
 * <>表示泛型，泛型的好处在于，对键值做类型描述
 * map遍历使用iterator
 * map的存储方式使用键值对，entry可以理解文键值对
 * Map<String,Object> getObject(String sql)适用场景
 * 1、sql语句已知
 * 2、参数较少，写到sql语句里
 * 3、可以用来获取对象，获取对象的形式是键值对
 * 4、尤其适用于多表无法封装成一个对象的场景
 * 
 * 如果调用的方法体上抛异常throws **Exception
 * 在调用方法的使用有两种解决方式
 * 1、try-catch包裹起来，异常处理
 * 2、继续在调用本方法的方法体上继续抛出异常
 * 
 * debug模式和run模式
 * 开发的时候使用debug模式,可以看到中间的过程，能够在自己关注的代码暂停
 * 就能一行行的执行代码
 * 在自己关注的代码的左侧双击，就可以打断点
 * 如果debug模式没有断点就和run模式一致
 * 
 * F6 一步一步的执行
 */

public class DButilTest {
	public static void main(String[] args) throws Exception {
		String sql = "select * from course";
		DBUtil db = new DBUtil();
		Map<String, Object> courseMap = db.getObject(sql);
		// System.out.println(courseMap);
		Iterator<Entry<String, Object>> it = courseMap.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> entry = (Entry<String, Object>) it.next();
			System.out.println(entry.getKey() + " ### " + entry.getValue());
		}

		String sql2 = "select * from course where cname = ?";
		Map<String, Object> courseMap2 = db.getObject(sql2, new Object[] { "sdf" });
		System.out.println(courseMap2);

		String sql3 = "select * from test where courseId = ? && teacherId = ?";
		Map<String, Object> courseMap3 = db.getObject(sql3, new Object[] { "1", "2" });
		System.out.println(courseMap3);

		
		/*
		 * Object getObject(class<?> type, String sql,Object[] ParamList)
		 * 第一个参数表示要封装成的类的类型
		 * type需要是我们提供的po或vo.String这样的不行
		 * 返回的结果是封装好的po或vo,需要强制类型转换
		 */
		Test T = (Test)db.getObject(Test.class, sql3, new Object[] { "1", "2" });
		System.out.println(T.toString());
	}
}
