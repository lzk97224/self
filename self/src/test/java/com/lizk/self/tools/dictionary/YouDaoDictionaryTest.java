package com.lizk.self.tools.dictionary;

import org.junit.Test;

public class YouDaoDictionaryTest {
	@Test
	public void test(){
		YouDaoDictionary youdao = new YouDaoDictionary();
		System.out.println(youdao.getEnglishBuChinese("包含"));
	}
}
