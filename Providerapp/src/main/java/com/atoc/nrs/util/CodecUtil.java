package com.atoc.nrs.util;

import org.apache.commons.codec.binary.Base64;


public class CodecUtil {

	public static String doDecode(String encStr){
		String nrmlStr=null;
		try {
			byte[] arr=encStr.getBytes();
			byte[] arr2=Base64.decodeBase64(arr);
			nrmlStr=new String(arr2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nrmlStr;
	}
}
