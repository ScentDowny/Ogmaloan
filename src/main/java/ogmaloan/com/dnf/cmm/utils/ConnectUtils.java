package ogmaloan.com.dnf.cmm.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectUtils {

	private static final String BASE_URL = "https://api.neople.co.kr";			// BASE_URL
	private static final String APP_KEY = "OPOR9bRfXlEGaYH4rq1qNIqCUSvPzQVA";	// APP_KEY
	private static final String API_METHOD = "GET";								// API_METHOD
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectUtils.class);
	
	/* 파라미터 미포함 URL Connection */
	public static JSONObject apiConnect(String url) throws Exception {
		return ConnectUtils.apiConnection(url);
	}
	
	/* 파라미터 포함 (map) URL Connection */
	public static JSONObject apiConnect(String url, Map<String, Object> map) throws Exception {
		url += "?";
		
		Iterator<String> keys = map.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			if ("?".equals(url)) {
				url += key + "=" + map.get(key);
			} else {
				url += "&" + key + "=" + map.get(key);
			}
		}
		logger.info("apiConnect / url : [" + url + "]");

		return ConnectUtils.apiConnection(url);
	}
	
	/* URL Connection 및 response > JSONObject 변환 */
	private static JSONObject apiConnection(String url) throws Exception {
		JSONParser parser = new JSONParser();
		String apiUrl = BASE_URL + url;
		URL apiConnectUrl = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) apiConnectUrl.openConnection();
		
		con.setRequestMethod(API_METHOD);
		con.setRequestProperty("apikey", APP_KEY);
		con.setDoOutput(true);
		
		// Response
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode==200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			response.append(inputLine);
		}
		br.close();
		String json = response.toString();
		JSONObject jsonObj = (JSONObject) parser.parse(json);
		
		logger.debug("[Result / JSON Object] :: " + jsonObj);
		
		return jsonObj;
	}
	
	/* UTF-8 인코딩 처리 */
	public static String encodeURIComponent(String component) throws Exception {	 
		
		try {
			component = URLEncoder.encode(component, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			component = "";
		}
		
		return component;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
