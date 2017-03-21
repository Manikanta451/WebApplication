package com.durgasoft;

public interface EmployeeDao {
	public EmployeeTo getemployee(String eid);
	public String add(String eid, String ename, String eaddr, String egender);
	public EmployeeTo search(String eid);
	public String update(String eid, String ename, String eaddr, String egender);
	public String delete(String eid);
}
