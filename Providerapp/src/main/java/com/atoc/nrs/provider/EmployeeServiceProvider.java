package com.atoc.nrs.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.atoc.nrs.model.EmpData;
import com.atoc.nrs.util.CodecUtil;
import com.atoc.nrs.validator.EmpValidator;


@Path("/empservice")
public class EmployeeServiceProvider {
	@POST
	@Path("/insertEmp")
	/*@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)*/
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String processReq(EmpData e,
			@HeaderParam("user")String eun,
			@HeaderParam("password")String epwd){
		
		String msg="";
		
		//1.decode un,pwd
		String un=CodecUtil.doDecode(eun);
		String pwd=CodecUtil.doDecode(epwd);
		
		//2. validate input
		boolean flag=EmpValidator.doValidate(un, pwd);
		
		if(flag){
			//3. if true call service
			msg=EmpDataService.insertAndSendEmail(e);
		}
		else{
			//4.false return with msg
			msg="Invalid user...";
		}
		return msg;
	}
}
