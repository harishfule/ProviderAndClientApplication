package com.atoc.nrs.dao;

import com.atoc.nrs.model.EmpData;

public interface IEmpDao {

	public boolean isEmpExist(int empId);
	public int insertEmp(EmpData e);
}
