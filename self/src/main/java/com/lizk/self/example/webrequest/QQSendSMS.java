package com.lizk.self.example.webrequest;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.xml.XmlPage;




public class QQSendSMS {
	public static void main(String[] args) throws FailingHttpStatusCodeException, IOException {
		String vcode = "848475709753";
		String path = "https://shenghuo.alipay.com/home/queryUserStatus.json?timeSnap=1442468167529&ua=089YlJgThc3UTYWOBgrdkN1RXFAe0ByRmY5Zg%3D%3D%7CYVJ8T3lPf0l9R3RDcUJ1Rhk%3D%7CYFB%2BJwdGLFwxXjkZNxcmFTUbO24FaQ9iF2ZGGUY%3D%7CZ1RkSmoMeyNvXTJgNWYPVRlNAFEUTzR3FCJxO1tqAGUtW29fMxNM%7CZlVuQBkpBz0LJRYiDCxcfhdxTiBYcgVkASoTZAVgQB9A%7CZV9xUXEu%7CZF9xUXEu%7Ca1hrRRw8ViBWJFVtQG0cdhF9GHIFaEQnSSJQM0hkBWgHKls8UDYbaQpxHnkVY04qQS9BbQdxHiN%2BCGUUfhl%2BCDdBMUYhBVgqTBphE3RLKEwtTi5JKEgrTypPKk4qTCZOL0VlS2tLFEs%3D%7Calt1LB4wAiwfJBYnCToJOAwiESoaKAY1Bz0PIRIpGSsFNgQyAF8A%7CaVpoRmY%2FDDcFMwIsclJhV2FSYVNhVWFUY1JoFiQIPwgyCToMPAc1ADYFNw05Z0dpWgUleg%3D%3D%7CaF5wKQltAHAzXDFGKlx8UmlebEJzRnxSZlxoN2g%3D%7Cb1h2Lw9kFmBPPlk6SitBbgdgGzsVTHZMeFZnVG4xHy0DIwMtHiwaLXIt%7Cblt1LAxnFWNMPVo5SShCbQRjGDgWJQs4CjwLVAs%3D%7CbVt1LAxnFWNMPVo5SShCbQRjGDgWLBYiDD0ONBoqHyQUSxQ%3D%7CbFh2Lw9kFmBPPlk6SitBbgdgGzsVJhYnCTsVJBctHUId%7Cc0ZoMRF6CH5RIEckVDVfcBl%2BBSULORcmFS4USxQ%3D%7CckRqMxMzHS4cKRI8Cz4NIxImEiZ5Jg%3D%3D%7CcUdpMBAwHiQVLgAxBDMdJxAkEk0S%7CcEZoMRF6CH5RIEckVDVfcBl%2BBSULMQU%2FESATKAY8BjMHWAc%3D%7Cd0BuNxd8DnhXJkEiUjNZdh94AyMNVG5aYU9%2BTXwjDT8RMRE%2FBDYEN2g3%7CdkNtNBR%2FDXtUJUIhUTBadRx7ACAOPRMoGigbRBs%3D%7CdUFvNhZ9D3lWJ0AjUzJYdx55AiIMOgEvHTMAMgUzB1gH%7CdEBuNxd8DnhXJkEiUjNZdh94AyMNOg4gEjwPPAs4CVYJ%7Ce09hOBhzAXdYKU4tXTxWeRB3DCwCNQMtHzECMgE2BlkG%7Cek5gORlyAHZZKE8sXD1XeBF2DS0DNQ4gEjwPPw4%2BCFcI%7CeU1jOhpxA3VaK0wvXz5UexJ1Di4ANwUrGTcENAM1BVoF%7CeExiOxtwAnRbKk0uXj9VehN0Dy8BNgcpGzUGNg0%2BC1QL%7Cf0tlPBx3BXNcLUopWThSfRRzCCgGMQIsHjADMgA2BlkG%7CfkpkPR12BHJdLEsoWDlTfBVyCSkHMAAuHDIBMAAzAl0C%7CfUlnPh51B3FeL0grWzpQfxZxCioEMwUrGTcENQIxA1wD%7CfEhmPx90BnBfLkkqWjtRfhdwCysFMwgmFDoJOA02BFsE%7CQ3VbAiJJO01iE3QXZwZsQypNNhY4AzQFKxoqGDYFMwQzBFsE%7CQnZYASFKOE5hEHcUZAVvQClONRU7DD8RIw0%2BCTsLOmU6%7CQXdZACAALhUgEjwNOQgmFSITJxNMEw%3D%3D%7CQHZYASFFKFgbdBluAnRUekF0Q21caV1zQHREcUIdQg%3D%3D%7CR3BeBycHKXBLcUNtXGhdAiweMBAwHi0YKx4qdSo%3D%7CRnNdBCRPPUtkFXIRYQBqRSxLMBA%2BDCIRJBciFkkW%7CRXNBc11vQXFfbFppR3ZBdFptVnhNelRnVGJMf1FqWXdDbV5oRndCbF1zQ3NdbFp0RmhHdFp1RWtfcUF6VGdQfk17VWZXeUp6VGdUekl7VW5AelRhT3tVekl%2BUGZIZ1RhT2BTaUdoW2lHdEUa&rdsToken=duZN0mPWQkXNVOSGYyAa4QHb3hgJt62n&account=18612534613&_input_charset=utf-8&r=1442468167529&ctoken=vuGii70fZyFlyduqc6Zvb%2BrFCTadPO&_callback=arale.cache.callbacks.jsonp6";
		
		WebClient webClient  = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(true);
		webClient.getOptions().setCssEnabled(false);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
		webClient.getOptions().setTimeout(35000); 
	    webClient.getOptions().setThrowExceptionOnScriptError(false); 
	    JavaScriptPage page = webClient.getPage(path);
	    System.out.println(page.getContent());
		
		
//		HtmlTextInput  qqinput =  page.getHtmlElementById("qq");
//		qqinput.setText("249177236");
		
		
		//WebDriver  driver = new HtmlUnitDriver();
		
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
		
	
		
		
		
		
		
	
		
	}
}
