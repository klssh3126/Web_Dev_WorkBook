<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>절대경로로 이동한 게시글페이지 입니다.</h1>
	<%
	ResultSet rs=(ResultSet)request.getAttribute("list");
	while(rs.next()){
	%>
	<p><%=rs.getString("title") %> </p>
	
	<%	
	}		
	%>
	
</body>
</html>