package com.web.board.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jboss.logging.Logger;

public class OpenAPI {
	
	Logger logger = Logger.getLogger(OpenAPI.class);
	
	public String getKoreaexim(String key) {
		
		BufferedReader reader = null;
		String result = "";
		
		try {

			StringBuilder builder = new StringBuilder("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON");
//			builder.append("&" + URLEncoder.encode("authkey"))
//			
//			URL url = new URL(urlstr);
//			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//			urlConnection.setRequestMethod("GET");
//			reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
			
//			String line;
//			
//			while((line = reader.readLine()) != null) {
//				result = result + line + "\n";
//			}
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		 
		System.out.println(result);
		return result;
		
	}
	
}
