package com.atoc.nrs.provider;

import com.atoc.nrs.model.EmpData;
import com.atoc.nrs.dao.EmpDaoImpl;
import com.atoc.nrs.dao.IEmpDao;

public class EmpDataService {

	public static String insertAndSendEmail(EmpData e){
		String msg=null;
		
		//1.read id from object
		int empId=e.getEmpId();
		//2. call isEmpExits
		IEmpDao dao=new EmpDaoImpl();
		boolean flag=dao.isEmpExist(empId);
		
		//3. if true return
		if(flag){
			msg="Employee already exist with id:"+empId;
		}else{
			//4.else insert data
			//5.on insert also send email.
			//Here email service implementation is pending
			int count=dao.insertEmp(e);
			if(count>0)
				msg="Employee record inserted with id:"+empId;
		}
		//return msg back to service provider
		return msg;
	}
}
