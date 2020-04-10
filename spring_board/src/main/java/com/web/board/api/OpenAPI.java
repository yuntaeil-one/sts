package com.web.board.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Component
public class OpenAPI {
	
	Logger logger = Logger.getLogger(OpenAPI.class);
	
	public String getKoreaexim() {
		
		String reqUrl = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON";
		String result = "";
		
		try {

			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			StringBuilder builder = new StringBuilder();
			builder.append("&authkey=");
			builder.append("&data=AP01");
			bufferedWriter.write(builder.toString());
			bufferedWriter.flush();
			
			// 1 : ����, 2 : DATA�ڵ� ����, 3 : �����ڵ� ����, 4 : ��������Ƚ�� ����
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				result += line;
			}

			System.out.println("response body : " + result );	
			
			// Gson ���̺귯���� ���Ե� Ŭ������ JSON �Ľ� ��ü ����
//			JsonParser parser = new JsonParser();
//			JsonElement element = parser.parse(result);
			
//			// ��ȸ ���
//			String RESULT = element.getAsJsonObject().get("RESULT").getAsString();
//			// ��ȭ�ڵ�
//			String CUR_UNIT = element.getAsJsonObject().get("CUR_UNIT").getAsString();
//			// ����/��ȭ��
//			String CUR_NM = element.getAsJsonObject().get("CUR_NM").getAsString();
//			// ����ȯ(�۱�) ������
//			String TTB = element.getAsJsonObject().get("TTB").getAsString();
//			// ����ȯ(�۱�) ������
//			String TTS = element.getAsJsonObject().get("TTS").getAsString();
//			// �Ÿ� ������
//			String DEAL_BAS_R = element.getAsJsonObject().get("DEAL_BAS_R").getAsString();
//			// ��ΰ���
//			String BKPR = element.getAsJsonObject().get("BKPR").getAsString();			
//			// ��ȯ������
//			String YY_EFEE_R = element.getAsJsonObject().get("YY_EFEE_R").getAsString();	
//			// 10��ȯ������
//			String TEN_DD_EFEE_R = element.getAsJsonObject().get("TEN_DD_EFEE_R").getAsString();	
//			// ����ܱ�ȯ�߰� �Ÿű�����
//			String KFTC_DEAL_BAS_R = element.getAsJsonObject().get("KFTC_DEAL_BAS_R").getAsString();	
//			// ����ܱ�ȯ�߰� ��ΰ���
//			String KFTC_BKPR = element.getAsJsonObject().get("KFTC_BKPR").getAsString();	

//			map.put("RESULT", RESULT);
//			map.put("CUR_UNIT", CUR_UNIT);
//			map.put("CUR_NM", CUR_NM);
//			map.put("TTB", TTB);
//			map.put("TTS", TTS);
//			map.put("DEAL_BAS_R", DEAL_BAS_R);
//			map.put("BKPR", BKPR);
//			map.put("YY_EFEE_R", YY_EFEE_R);
//			map.put("TEN_DD_EFEE_R", TEN_DD_EFEE_R);
//			map.put("KFTC_DEAL_BAS_R", KFTC_DEAL_BAS_R);
//			map.put("KFTC_BKPR", KFTC_BKPR);
			
			bufferedReader.close();
			bufferedWriter.close();
			
		} catch (Exception e) {
			logger.error(e.getStackTrace());
		}
		return result;
		
	}
	
}
