package com.durgasoft;

public interface EmployeeDao {
	public EmployeeTo getEmployee(String eid);
	public String add(String eid, String ename, String eaddr, String egender, String edoj);
	public EmployeeTo search(String eid);
	public String update(String eid, String ename, String eaddr, String egender,String edoj);
	public String delete(String eid);
}
