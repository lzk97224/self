package com.lizk.self.example.webrequest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GetBlackCustNameList {
	public static void main(String[] args) {
		WebDriver driver = new HtmlUnitDriver();
		
		//网贷信用黑名单
		
		int index = 1; 
		driver.get("http://www.p2pblack.com/index.htm?Page="+index);
		
		WebElement element = driver.findElement(By.className("cengter_biaotou"));
		while(element!=null){
			
			element = driver.findElement(By.className("cengter_biaotou"));
			System.out.println(element.getText());
			
			List<WebElement> elements = driver.findElements(By.className("xiabian"));
			
			for(int i = 0 ;  i < elements.size() ; i ++){
				
				System.out.println(elements.get(i).getText());
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			index ++;
			driver.get("http://www.p2pblack.com/index.htm?Page="+index);
		}
		
		
		
		
		
		
		
		
		
		
	}
}
