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
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.FrameWindow;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class ZhiFuBao {
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		WebClient webClient  = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(true);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
		webClient.getOptions().setTimeout(35000); 
	    webClient.getOptions().setThrowExceptionOnScriptError(false); 
	    
	    HtmlPage page = webClient.getPage("https://auth.alipay.com/login/index.htm");
	    System.out.println(page.asXml());
	    
	    DomElement ele = page.getElementById("J-input-user");
	    ((HtmlTextInput)ele).setValueAttribute("lzkmm@sina.com");
	    ele = page.getElementById("password_rsainput");
	    ((HtmlPasswordInput)ele).setValueAttribute("love@mei520");
	    ele = page.getElementById("J-login-btn");
	    page = ((HtmlSubmitInput)ele).click();
	    
	    page = webClient.getPage("https://shenghuo.alipay.com/send/payment/fill.htm");
	    
	    System.out.println(page.asXml());
	    
	    ele = page.getElementById("ipt-search-key");
	    ((HtmlTextInput)ele).setValueAttribute("18600909357");
	    ele = page.getElementById("amount");
	    ((HtmlTextInput)ele).setValueAttribute("1");
	    HtmlSubmitInput submit = page.getForms().get(0).getInputByValue("下一步");
	    System.out.println(submit.getValueAttribute());
	    ele = page.getElementById("ipt-search-key");
	    System.out.println(ele.getAttribute("value"));
//	    page = submit.click();
//	    System.out.println(page.asXml());
//	    System.out.println(page.getForms().get(0).asXml());
//	    DomNodeList<DomElement> list = page.getElementsByTagName("div");
//	    for(int i = 0 ;i < list.size();i++){
//	    	if("fn-left recipient-text".equals(list.get(i).getAttribute("class"))){
//	    		System.out.println(list.get(i).asText());
//	    	}
//	    }
	    
	    
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
