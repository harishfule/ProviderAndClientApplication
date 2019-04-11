package com.atoc.nrs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atoc.nrs.model.EmpData;
import com.atoc.nrs.util.ConnectionUtil;

public class EmpDaoImpl implements IEmpDao{

	public boolean isEmpExist(int empId){
		String sql="select count(eid) from emp_tbl where eid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			conn=ConnectionUtil.getConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,empId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				int count=rs.getInt(1);
				if(count>0) flag=true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int insertEmp(EmpData e) {
		String sql="insert into emp_tbl values(?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			con=ConnectionUtil.getConn();
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, e.getEmpId());
			pstmt.setString(2,e.getEmpName());
			pstmt.setDouble(3, e.getEmpSal());
			pstmt.setString(4, e.getEmpMail());
			
			count=pstmt.executeUpdate();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return count;
	}
	
}
