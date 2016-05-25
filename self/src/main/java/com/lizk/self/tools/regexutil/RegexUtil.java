package com.lizk.self.tools.regexutil;

public class RegexUtil {
	
	
	/**
	 * 判断字符串是否不为空
	 * @return
	 */
	public boolean isNotBlank(String str){
		return !isBlank(str);
	}
	
	
	/**
	 * 判断字符串是否为空
	 * @return
	 */
	public boolean isBlank(String str){
		boolean result = false;
		if(str == null){
			result = true;
		}else{
			result = str.equals("");
		}
		return result;
	}
	
	
	/**
	 * 判断字符串中是否包换汉字
	 * @param str
	 * @return
	 */
	public boolean isContainChinese(String str){
		boolean result = false;
		if(isNotBlank(str)){
			result = str.matches(".*[\\u4e00-\\u9fa5]+.*");
		}
		return result;
	}
	
	
}
