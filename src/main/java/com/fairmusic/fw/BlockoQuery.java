package com.fairmusic.fw;

public class BlockoQuery {
	
	public static String EMP_login
	= "select * from employee where id = ? and pass =? ";
public static String ID_CHECK
	= "select * from employee where id = ?";
public static String EMP_insert
	= "insert into employee values(?,?,?,?,?,?,?,?)";
public static String EMP_search
	 =  "select e.id,e.pass,e.name,e.addr,e.hiredate," 
			  + "e.grade,e.point,e.deptno, d.deptname " 
			  + "from employee e,kitridept d " 
			  + "where d.deptno=? " 
			  + "and e.deptno = d.deptno";
}
