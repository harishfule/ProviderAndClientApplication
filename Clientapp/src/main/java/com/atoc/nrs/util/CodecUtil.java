package com.atoc.nrs.util;

import org.apache.commons.codec.binary.Base64;

public class CodecUtil {

	public static String doEncode(String nrmlStr){
		String encStr=null;
		try {
			//convert string to byte[]
			byte[] arr=nrmlStr.getBytes();
			//call encodeBase64
			byte[] encArr=Base64.encodeBase64(arr);
			//convert byte[] to String
			encStr=new String(encArr);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encStr;
	}
}
