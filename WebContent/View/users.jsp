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
	<h1>Lista użytkowników</h1>
	
	<table>
		<thead>
			<tr>
				<th>Nazwa użytkownika</th>
				<th>Email</th>
				<th>Grupa użytkownika</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="0" end="${fn:length(users) - 1 }" step="1"
				varStatus="s">
				<tr>
					<td>${users[s.index].getUserName() }</td>
					<td>${users[s.index].getEmail() } </td>
					<td>${users[s.index].getPersonGroupId() } </td>
					<td><a href="<c:url value="/User?id=${users[s.index].getId()}"/>">Edycja</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>