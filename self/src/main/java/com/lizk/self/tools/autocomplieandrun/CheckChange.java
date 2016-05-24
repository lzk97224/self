package com.lizk.self.tools.autocomplieandrun;

import java.io.File;
import java.util.Map;

public class CheckChange implements Runnable{
	
	
	
	String classFilePath = null; //存储需要检查的路径
	Map<String,Long> fileMap = null; //存储文件与修改时间的对应关系
	
	boolean isChange = false; //记录目录里的文件是否被修改
	
	LoadClass loadClass = null;  //如果文件被修改，需要告知的类
	
	CheckChange(LoadClass loadClass){
		this.classFilePath = loadClass.getPath();
		this.fileMap = loadClass.getFileMap();
		this.loadClass  = loadClass;
	}
	@Override
	public void run(){
		
		while(true){
			if(isChange()){
				//通知loadClass，目录里的文件已经被修改
				loadClass.setChange(true);
				System.out.println("目录有变化");
			}else{
				System.out.println("目录没有变化");
			}
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean isChange(){
		//初始化isChange标志位为false，没有文件修改
		isChange = false;
		File file = new File(classFilePath);
		//检查是否有文件修改
		checkAllFile(file);
		
		//存储返回结果
		boolean result = isChange;
		//恢复标志位为false
		isChange = false;
		//返回检查结果
		return result;
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
			String fileName = file.getAbsolutePath()+file.getName();
			Long tmpLastModified = fileMap.get(fileName);
			
			//如果不一致，那么把新的修改日期记录到fileMap中，并修改isChange为true
			if(tmpLastModified==null||tmpLastModified!=lastModified){
				fileMap.put(fileName, lastModified);
				isChange = true;
			}
		}
	}
	

	public static void main(String[] args) {
		//CheckChange cc = new CheckChange("D:/classdir");
		//new Thread(cc).start();
	}
}
