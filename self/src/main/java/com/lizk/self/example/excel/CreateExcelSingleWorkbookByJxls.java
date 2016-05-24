package com.lizk.self.example.excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
/**
 * jxls用模板的方式生成excel表格
 * @author Administrator
 *
 */
public class CreateExcelSingleWorkbookByJxls {
	public static void main(String[] args) throws ParsePropertyException, InvalidFormatException, IOException {
		List<Map<String,Object>> result =  new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pro1", 11111111);
		map.put("pro2", 22222222);
		result.add(map);
		map = new HashMap<String,Object>();
		map.put("pro1", 11111111);
		map.put("pro2", 22222222);
		result.add(map);
		
		Map<String,Object> beans = new HashMap<String,Object>();
		beans.put("result",result);
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(CreateExcelSingleWorkbookByJxls.class.getResource("simple_export_input.xls").getPath() , beans, CreateExcelSingleWorkbookByJxls.class.getResource("").getPath()+"/simple_export_output1.xls");
	}
}
