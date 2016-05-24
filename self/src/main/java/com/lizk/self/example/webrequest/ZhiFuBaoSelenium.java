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

import bsh.Capabilities;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.FrameWindow;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class ZhiFuBaoSelenium {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
		capabilities.setJavascriptEnabled(true);
		WebDriver driver = new HtmlUnitDriver(capabilities);
		driver.get("https://auth.alipay.com/login/index.htm");
		
		WebElement ele =  driver.findElement(By.id("J-input-user"));
		ele.clear();
		ele.sendKeys("lzkmm@sina.com");
		System.out.println(driver.getPageSource());
		
		ele =  driver.findElement(By.id("password_rsainput"));
		ele.clear();
		ele.sendKeys("love@mei520");
		ele =  driver.findElement(By.id("J-login-btn"));
		
		ele.click();
		
		ele = driver.findElement(By.linkText("转 账"));
		System.out.println("=============="+ele.getText());
		ele.click();
		
		
		
		ele =  driver.findElement(By.id("ipt-search-key"));
		ele.clear();
		ele.sendKeys("18600909357");
		ele =  driver.findElement(By.id("amount"));
		ele.clear();
		ele.sendKeys("1");
		ele =  driver.findElement(By.xpath("//*[@id=\"hiddenInfoForm\"]/div[1]/div/div/div/div/div[1]/div"));
		System.out.println(ele.getText());
		
	}
}
