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
	<jsp:include page="/View/header.jsp" />
	<h1>Szczegóły użytkownika: ${user.getUserName()}</h1>

	<p>Nazwa: ${user.getUserName()}</p>
	<p>Email: ${user.getEmail()}</p>
	<br>
	<br>
	<p>
		<b>Dodane rozwiązania zadań:</b>
	</p>
	<br>

	<table>
		<thead align="left">
			<tr>
				<th>Tytuł zadania</th>
				<th>Data dodania</th>
				<th>Akcje</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(solution) > 0}">
				<c:forEach begin="0" step="1" end="${fn:length(solution) - 1}"
					varStatus="status">
					<tr>
						<td>${solution[status.index].getExcersiseId() }</td>
						<td>${solution[status.index].getCreated() }</td>
						<td><a
							href="<c:url 
						value ="/solDetail?id=${solution[status.index].getId()}"/>">
								Szczegóły</a></td>
					</tr>

				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>