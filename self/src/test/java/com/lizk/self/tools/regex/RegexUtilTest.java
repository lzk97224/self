package com.lizk.self.tools.regex;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lizk.self.tools.regexutil.RegexUtil;


public class RegexUtilTest {
	@Test
	public void test(){
		RegexUtil regex = new RegexUtil();
		assertTrue(regex.isContainChinese("123"));
	}
}
