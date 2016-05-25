package com.lizk.self.tools.dictionary;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class YouDaoDictionary {
	public String getEnglishBuChinese(String chinese){
		String result = "";
		
		WebDriver driver = new HtmlUnitDriver();
		driver.get("http://dict.youdao.com/w/eng/" + chinese + "/#keyfrom=dict2.index");
		
		List<WebElement> elements = driver.findElements(By.cssSelector("a[href$='E2Ctranslation']"));
		
		for(WebElement element : elements){
			result = result + "\n" + element.getText();
		}
		
		return result ;
	}
}
