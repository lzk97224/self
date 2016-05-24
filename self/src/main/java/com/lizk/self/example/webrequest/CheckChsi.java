package com.lizk.self.example.webrequest;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




public class CheckChsi {
	public static void main(String[] args) throws MalformedURLException {
		String vcode = "848475709753";
		
		WebDriver driver = new HtmlUnitDriver();
		
		/*driver.get("http://w.qq.com/");
		System.out.println(driver.getPageSource());
		WebElement ele =  driver.findElement(By.id("u"));
		ele.clear();
		ele.sendKeys("972241995");
		ele = driver.findElement(By.id("p"));
		ele.clear();
		ele.sendKeys("love@mei520");
		ele = driver.findElement(By.id("login_button"));
		ele.click();
		ele = driver.findElement(By.xpath("//*[@id=\"mainTopAll\"]/div[1]/span[2]"));
		System.out.println(ele.getText());*/
		
		
		
		
		
		
		
		
		//学信网
		String path  = "http://www.chsi.com.cn/xlcx/bg.do?vcode="+vcode+"&ln=cn&srcid=qrcode";
		System.out.println(path);
		driver.get(path);
		
		System.out.println(driver.getPageSource());
//		driver.get("http://www.baidu.com");
		//System.out.println(driver.getPageSource());
				
		WebElement ele =  driver.findElement(By.xpath("//*[@id=\"fixedPart\"]/table[1]/tbody/tr[3]/td[4]/div"));
		System.out.println(ele.getText());
		
	}
}
