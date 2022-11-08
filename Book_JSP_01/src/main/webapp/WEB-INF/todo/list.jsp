<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Page</h1>

<ul>
	<c:forEach var="dto" items="${list}">
		<li>${dto}</li>
	</c:forEach>
</ul>

<c:set var="target" value="5"></c:set>
<ul>
	<c:forEach var="num" begin="1" end="10">
		<c:if test="${num==target}">
			 num is target
		 </c:if>
	</c:forEach>
</ul>

</body>
</html>