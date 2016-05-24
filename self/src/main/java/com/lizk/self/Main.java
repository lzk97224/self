package com.lizk.self;

/**
 * Hello world!
 * 
 */
public class Main {
	public boolean isWord (String str){
		if(str == null){
			return false;
		}else{
			return str.matches(".*[\\u4e00-\\u9fa5]+.*");
		}
	}
}
