package com.lizk.self.tools.autocomplieandrun;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		LoadClass lc = new LoadClass("D:/classdir/");
		while (true) {

			Map<String, Long> map = lc.getFileMap();
			Set<String> set = map.keySet();
			for (String tmpClass : set) {
				
				try {
					if(tmpClass.startsWith("main")){
						
						Thread.sleep(5000);
						System.out.println("调用" + tmpClass + "的main方法开始");
						lc.exeMethodOfClass("main", tmpClass);
						System.out.println("调用" + tmpClass + "的main方法结束");
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}