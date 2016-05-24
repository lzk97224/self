package com.lizk.self.example.interesting;

import java.lang.reflect.Field;

public class TwoAddTwo {
	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException { 
		 
	      Class cache = Integer.class.getDeclaredClasses()[0]; //1 
	      Field myCache = cache.getDeclaredField("cache"); //2 
	      myCache.setAccessible(true);//3 
	      
	      //获取Integer中的小整数缓存
	      Integer[] newCache = (Integer[]) myCache.get(cache); //4 
	      
	      //修改Integer中的小整数缓存，把4修改为5，使2+2=5
	      newCache[132] = newCache[133]; //5 
	 
	      int a = 2; 
	      int b = a + a; 
	      System.out.printf("%d + %d = %d", a, a, b); // 
	    } 
}
