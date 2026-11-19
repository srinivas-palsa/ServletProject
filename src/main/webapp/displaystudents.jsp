
<%@page import="com.alpha.jsp.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>THIS IS DISPLAY STUDENT PAGE</h2>
	<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	%>

	<%
	for (Student student : students) {
	%>
	<h2 style="color:red"><%=student.getName() %></h2>
	<h2 style="color:green"><%=student.getId() %></h2>
	<h2 style="color:hotpink"><%=student.getAge() %></h2>
	<h2 style="color:yellow"><%=student.getAddress() %></h2>
	<%
	}
	%>
</body>
</html>