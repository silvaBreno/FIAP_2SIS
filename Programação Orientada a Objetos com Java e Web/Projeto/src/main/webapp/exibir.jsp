<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Boa noite!</h1>
	<% String nome = (String)request.getAttribute("nome"); %>
	
	<h1>Boa noite <% out.print(nome); %></h1>
</body>
</html>