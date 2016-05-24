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

public class QQKongJian {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		WebClient webClient  = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
		webClient.getOptions().setTimeout(35000); 
	    webClient.getOptions().setThrowExceptionOnScriptError(false); 
	    
	    HtmlPage page = webClient.getPage("http://xui.ptlogin2.qq.com/cgi-bin/xlogin?proxy_url=http%3A//qzs.qq.com/qzone/v6/portal/proxy.html&daid=5&pt_qzone_sig=1&hide_title_bar=1&low_login=0&qlogin_auto_login=1&no_verifyimg=1&link_target=blank&appid=549000912&style=22&target=self&s_url=http%3A//qzs.qq.com/qzone/v5/loginsucc.html?para=izone&pt_qr_app=手机QQ空间&pt_qr_link=http%3A//z.qzone.com/download.html&self_regurl=http%3A//qzs.qq.com/qzone/v6/reg/index.html&pt_qr_help_link=http%3A//z.qzone.com/download.html");
	    System.out.println(page.asXml());
	    
	    DomElement ele = page.getElementById("switcher_plogin");
	    System.out.println(ele.asText());
	    
	    
	    
	    
//	    
//		driver.get("http://qzone.qq.com/");
//		
//		
//		WebElement ele =  driver.findElement(By.id("switcher_plogin"));
//		ele.click();
//		ele =  driver.findElement(By.id("u"));
//		ele.clear();
//		ele.sendKeys("3175450284");
//		
//		ele =  driver.findElement(By.id("p"));
//		ele.clear();
//		ele.sendKeys("lizhikui");
//		
//		ele.submit();
//		
//		List<WebElement> infos = driver.findElements(By.className("f-info"));
//		for(int i = 0 ; i < infos.size() ; i ++){
//			System.out.println(infos.get(i));
//		}
//		
		
	}
}
