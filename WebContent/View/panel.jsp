<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/View/header.jsp"/>

<h1>Panel administracyjny</h1>
<p><a href="<c:url value ="/Excersises"/>">Lista zadań</a></p>
<p><a href="<c:url value ="/Groups"/>">Lista grup użytkowników</a></p>
<p><a href="<c:url value ="/User"/>">Lista wszystkich użytkowników</a></p>


</body>
</html>