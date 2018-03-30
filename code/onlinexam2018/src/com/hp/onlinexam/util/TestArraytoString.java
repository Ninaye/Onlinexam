package com.hp.onlinexam.util;

public class TestArraytoString {
	
	public static void main(String[] args) {
		String [] strArray = new String[] {"1","2","3","4","5"};
		String sql = "";
		for(int i = 0; i < strArray.length; i++) {
			if(i == strArray.length-1) {
				sql += strArray[i];
				sql += ";";
			}
			else {
				sql += strArray[i];
				sql += ",";
			}
		}
		System.out.println(sql);
	}
}
