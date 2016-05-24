package com.lizk.self.example.string;

public class RegexTest {
	public static void main(String[] args) {
		
		
		//判断字符串中是否包换汉字
		System.out.println("sjdfal我sasljdf".matches(".*[\\u4e00-\\u9fa5]+.*"));
	}
}
