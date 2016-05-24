package com.lizk.self.tools.autocomplieandrun;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;



public class LoadClass {
	
	
	private Map<String,Long> fileMap = new HashMap<String,Long>();  //存储文件与修改时间的对应关系
	boolean isChange = true;//记录目录中的文件是否修改，isChange线程如果判断目录里的文件有修改，那么更新这个变量为true。
	URLClassLoader cl = null; 
	String path = null;  //加载class的路径，实例化类的时候初始化
	File rootfile = null;
	
	LoadClass(String path){
		this.path = path;
		rootfile = new File(path);
		checkAllFile(rootfile);
		CheckChange1 cc = new CheckChange1();
		new Thread(cc).start();
	}
	
	public void exeMethodOfClass(String methodName,String clazzName) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		if(isChange){//如果路径中的文件有修改或者是第一次执行，那么重新加载class
			System.out.println("重新加载class");
			cl=new URLClassLoader(new URL[]{new File(path).toURI().toURL()});
			//加载完成以后修改两个标志
			isChange = false;
		}	
		
		//利用反射调用对应class的方法
		Class<?> clazz = cl.loadClass(clazzName);
		Object ob = clazz.newInstance();
		Method method = clazz.getMethod(methodName);
		method.invoke(ob);
	}
	
	
	class CheckChange1 implements Runnable{

		@Override
		public void run() {
			while(true){
				checkAllFile(rootfile);
				if(isChange){
					System.out.println("目录变化");
				}else{
					System.out.println("目录没变");
				}
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	public void checkAllFile(File file){
		//如果是目录，那么循环检查每个目录里的文件
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File tmpFile :files){
				checkAllFile(tmpFile);
			}
		//如果是文件，那么比较文件最后修改日期和fileMap中存储的日期是否一直
		}else if(file.isFile()){
			long lastModified = file.lastModified();
			String fileName = file.getAbsolutePath().replace(rootfile.getAbsolutePath()+File.separator, "").replace(File.separator, ".").replace(".class", "");
				Long tmpLastModified = fileMap.get(fileName);
				
				//如果不一致，那么把新的修改日期记录到fileMap中，并修改isChange为true
				if(tmpLastModified==null||tmpLastModified!=lastModified){
					fileMap.put(fileName, lastModified);
					isChange = true;
				}
		}
	}

	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Long> getFileMap() {
		return fileMap;
	}

	public void setFileMap(Map<String, Long> fileMap) {
		this.fileMap = fileMap;
	}
	
	
	
	
	
}
