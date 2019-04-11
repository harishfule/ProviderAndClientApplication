package com.atoc.nrs.util;

import org.codehaus.jackson.map.ObjectMapper;


public class JsonUtil {

	/**
	 * This code is used to
	 * convert object to json string
	 * input is any object and
	 * output is json String
	 * 
	 */
	
	public static String convertObjToJson(Object ob){
		String json=null;
		try {
			
			ObjectMapper om=new ObjectMapper();
			json=om.writeValueAsString(ob);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
