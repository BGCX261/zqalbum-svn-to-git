package com.littleqworks.commons.util;

public class Test {

	public static void main(String[] args) {
		//System.out.println(RegExUtils.isMatch("tml@gmail.com", "\\w@(\\w.)[a-z]{2,3}"));
		String createTime=DateTimeUtils.getTimestamp();
		String updateTime=createTime;
		System.out.println("createTime="+createTime);
		System.out.println("updateTime="+updateTime);
	}

}
