package com.atoc.nrs.validator;

public class EmpValidator {

	public static boolean doValidate(String un,String pwd){
		boolean flag=false;
		if("admin".equals(un) && "harsh".equals(pwd)){
			flag=true;
		}
		return flag;
	}
}
