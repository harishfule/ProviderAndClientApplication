package com.atoc.nrs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atoc.nrs.client.RestClient;
import com.atoc.nrs.model.Employee;
import com.atoc.nrs.util.JsonUtil;


public class InsertDataServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.reading params
			String eid=request.getParameter("eid");
			String ename=request.getParameter("ename");
			String email=request.getParameter("email");
			String esal=request.getParameter("esal");

			//2.convert the values
			int empId=Integer.parseInt(eid);
			double empSal=Double.parseDouble(esal);
			
			//3.create object(empty)
			Employee emp=new Employee();
			//4.set the values
			emp.setEmpId(empId);
			emp.setEmpName(ename);
			emp.setEmpMail(email);
			emp.setEmpSal(empSal);
			
			
			//5.convert obj to json
			String json=JsonUtil.convertObjToJson(emp);
			
			//6.get response msg back
			String msg=RestClient.connectToProvider(json);
			request.setAttribute("msg",msg);
			
			//7.dispatch to UI
			request.getRequestDispatcher("Register.jsp")
			.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
