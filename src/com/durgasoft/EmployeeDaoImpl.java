package com.durgasoft;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection con;
	String status="";
	EmployeeTo eto;
	PreparedStatement pst;
	ResultSet rs;
	public EmployeeDaoImpl(){
		con=ConnectionFactory.getConnection();
	}
	@Override
	public String add(String eid, String ename, String eaddr, String egender) {
		try {
			pst=con.prepareStatement("select * from employee where eid=?");
			pst.setString(1, eid);
			rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true){
				status="existed";
			}else{
				pst=con.prepareStatement("insert into employee values(?,?,?,?)");
				pst.setString(1, eid);
				pst.setString(2, ename);
				pst.setString(3, eaddr);
				pst.setString(4, egender);
				pst.executeUpdate();
				status="success";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
	public EmployeeTo search(String eid){
		eto=getemployee(eid);
		return eto;
	}
	public EmployeeTo getStudent(String eid){
		try {
			pst=con.prepareStatement("select * from employee where eid=?");
			pst.setString(1, eid);
			rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true){
				eto=new EmployeeTo();
				eto.setEid(rs.getString("EID"));
				eto.setEname(rs.getString("ENAME"));
				eto.setEaddr(rs.getString("EADDR"));
				eto.setEgender(rs.getString("EGENDER"));
				
			}else{
				eto=null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eto;
	}
	@Override
	public String update(String eid, String ename, String eaddr, String egender) {
		try {
			pst=con.prepareStatement("update employee set ename=?,eaddr=? where eid=?");
			pst.setString(1, ename);
			pst.setString(2, eaddr);
			pst.setString(3, eid);
			pst.setString(4,egender);
			pst.executeUpdate();
			status="success";
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String eid) {
		try {
			pst=con.prepareStatement("select * from employee where eid=?");
			pst.setString(1, eid);
			rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true){
				pst=con.prepareStatement("delete from employee where eid=?");
				pst.setString(1, eid);
				pst.executeUpdate();
				status="success";
			}else{
				status="notexisted";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public EmployeeTo getemployee(String eid) {
		return null;
	}

}
