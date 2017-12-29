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

	<h2>Szcegóły zadania: ${excersise.getTitle()}</h2>
	<a>${excersise.getDescription()} </a>
	<h3>Rozwiązania zadania:</h3>

	<table>
		<thead>
			<tr>
				<th>Id użykownika</th>
				<th>Data utworzenia</th>
				<th>Akcja</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach begin="0" end="${fn:length(solution) - 1 }" step="1"
				varStatus="s">
				<tr>
					<td>${solution[s.index].getUsersId() }</td>
					<td>${solution[s.index].getCreated() } </td>
					<td><a href="<c:url value="/solDetail?id=${solution[s.index].getId()}"/>">Szczegóły</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>