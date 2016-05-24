package com.lizk.self.example.webrequest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.FrameWindow;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class QQKongJianSelenium {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		WebDriver driver = new HtmlUnitDriver(true);
		driver.get("http://i.qq.com/");
		driver.switchTo().frame("login_frame");
		
		WebElement ele =  driver.findElement(By.id("switcher_plogin"));
		ele.click();
		ele =  driver.findElement(By.id("u"));
		ele.clear();
		ele.sendKeys("3175450284");
		
		ele =  driver.findElement(By.id("p"));
		ele.clear();
		ele.sendKeys("lizhikui");
		ele =  driver.findElement(By.id("login_button"));
		
		ele.click();
		
		List<WebElement> infos = driver.findElements(By.className("f-info"));
		for(int i = 0 ; i < infos.size() ; i ++){
			System.out.println(infos.get(i).getText());
		}
		
		
	}
}
