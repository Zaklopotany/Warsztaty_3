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
	<form method="post" action="<c:url value="/User"/>">
		<input type="hidden" name="id" value="${user.getId() }">
		Nazwa Użytkownika: 
		<input type="text" name="name" value="${user.getUserName()}"><br>
		Email: 
		<input type="text" name="email" value="${user.getEmail()}"><br>
		Hasło: 
		<input type="text" name="password" value=""><br>
		Id grupy: 		
		<input type="text" name="group" value="${user.getPersonGroupId()}"><br>
		<input type="submit">
	</form>

</body>
</html>