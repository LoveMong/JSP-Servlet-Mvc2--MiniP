<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DBCP 연동 확인</title>
</head>
<body>
<h4>디비 연동</h4>
	<%
 	 Context initContext = new InitialContext();
	 Context envContext = (Context) initContext.lookup("java:/comp/env");
	 DataSource ds = (DataSource) envContext.lookup("jdbc/Mysql");
	 Connection conn = ds.getConnection();
	 out.println("DBCP 연동 성공");
	%> 
</body>
</html>