package com.lizk.self.example.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;



public class CreateExcelManyWorkbookByJxls {
	public static void main(String[] args) throws IOException, ParsePropertyException, InvalidFormatException {
		
		System.out.println( CreateExcelManyWorkbookByJxls.class.getResource("simple_export_input.xls"));
		InputStream is1 = CreateExcelManyWorkbookByJxls.class.getResourceAsStream("simple_export_input.xls");
		OutputStream os1 =   new FileOutputStream(CreateExcelManyWorkbookByJxls.class.getResource("").getPath()+"simple_export_output1.xls");
		
		List<Map<String,Object>> result =  new ArrayList<Map<String,Object>>(); 
		
		List<Object> objects =  new ArrayList<Object>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro1", "姓名");
		map.put("pro2", "李志奎");
		result.add(map);
		map = new HashMap<String,Object>();
		map.put("pro1", "年龄");
		map.put("pro2", "26");
		result.add(map);
		
		objects.add(result);
		
		result =  new ArrayList<Map<String,Object>>();
		map = new HashMap<String,Object>();
		map.put("pro1", "姓名");
		map.put("pro2", "胡雪梅");
		result.add(map);
		map = new HashMap<String,Object>();
		map.put("pro1", "年龄");
		map.put("pro2", "26");
		result.add(map);
		
		objects.add(result);
		
		
		List<String> newSheetNames = new ArrayList<String>();
		
		newSheetNames.add("1");
		newSheetNames.add("2");
		
		XLSTransformer transformer = new XLSTransformer();
		
		HSSFWorkbook  workBook = (HSSFWorkbook )transformer.transformMultipleSheetsList(is1, objects, newSheetNames, "result", new HashMap<Object,Object>(), 0);
		workBook.write(os1);
	
	}
}
