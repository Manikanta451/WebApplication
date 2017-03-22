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
	public String add(String eid, String ename, String eaddr, String egender,String edoj) {
		try {
			pst=con.prepareStatement("select * from employee where eid=?");
			pst.setString(1, eid);
			rs=pst.executeQuery();
			boolean b=rs.next();
			if(b==true){
				status="existed";
			}else{
				pst=con.prepareStatement("insert into employee values(?,?,?,?,?)");
				pst.setString(1, eid);
				pst.setString(2, ename);
				pst.setString(3, eaddr);
				pst.setString(4, egender);
				pst.setString(5,  edoj);
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
		eto=getEmployee(eid);
		return eto;
	}
	public EmployeeTo getEmployee(String eid){
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
				eto.setEdoj(rs.getString("EDOJ"));
				
			}else{
				eto=null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eto;
	}
	@Override
	public String update(String eid, String ename, String eaddr, String egender,String edoj) {
		try {
			pst=con.prepareStatement("update employee set ename=?,eaddr=?,egender=? where eid=?");
			pst.setString(1, ename);
			pst.setString(2, eaddr);
			pst.setString(3, egender);
			pst.setString(4, eid);
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
	


}
