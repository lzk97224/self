package com.lizk.self.example.kuaidi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String name = "shunfeng";
		String no = "976523749167";
		
		//String result = Main.sendRequest("http://www.kuaidi100.com/query?type="+name+"&postid="+no+"&id=19&valicode=&temp=2.23132","","GET");
		String result = Main.sendRequest("http://www.sf-express.com/sf-service-web/service/bills/"+no+"/routes?app=bill&lang=sc&region=cn&translate=","","GET");
		
		System.out.println(result);
//		JSONObject jsonObject = new JSONObject(result);
//		System.out.println(jsonObject.get("updatetime"));
//		System.out.println("-----------------------");
//		JSONArray jsonArrary = jsonObject.getJSONArray("data");
//		for(int i = 0 ; i < jsonArrary.length();i++){
//			JSONObject jsonObjectTmp = (JSONObject)jsonArrary.get(i);
//			System.out.println(jsonObjectTmp.get("time")+"--"+jsonObjectTmp.get("context"));
//		}
	}



	public static String sendRequest(String urlStr,String msg,String method) throws IOException {
		BufferedReader in = null;
		PrintWriter  out = null;
		String result = "";
		try{
			URL url = new URL(urlStr);
			HttpURLConnection  conn =  (HttpURLConnection )url.openConnection();
			conn.setRequestProperty("Cookie", "Hm_lvt_22ea01af58ba2be0fec7c11b25e88e6c=1454468693; Hm_lpvt_22ea01af58ba2be0fec7c11b25e88e6c=1454469041; kd_history=Hm_lvt_22ea01af58ba2be0fec7c11b25e88e6c=1454468693; Hm_lpvt_22ea01af58ba2be0fec7c11b25e88e6c=1454469041; kd_history=[{\"code\":\"shunfeng\",\"nu\":\"976523749167\",\"time\":\"2016-02-03T03:18:19.239Z\",\"ischeck\":\"1\"}]; toolbox_urls=; toolbox_urls=");
			
			if(method.equals("GET")){
				conn.setConnectTimeout(5*1000);
				conn.setRequestMethod(method);
			}else{
				conn.setDoOutput(true);
		        conn.setDoInput(true);
		        conn.setRequestMethod(method);
		        out = new PrintWriter(conn.getOutputStream());
		        out.print(msg);
		        out.flush();
			}
	        
	        in  = new BufferedReader(
	                new InputStreamReader(conn.getInputStream()));
	        String line;
	        result = "";
	        while ((line = in.readLine()) != null) {
	        	result += line;
	        }
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(out!=null){
					out.close();
			}
		}
        return result;
	}
}

