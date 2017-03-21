package com.durgasoft;

public class EmployeeDaoFactory {
	static EmployeeDao dao;
	static{
		dao=new EmployeeDaoImpl();
	}
	public static EmployeeDao getEmployeeDao(){
		return dao;
	}

}
