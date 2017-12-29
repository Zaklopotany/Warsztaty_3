<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	padding: 10px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<h2>Ostatnie rozwiązania</h2>

	<table>
		<thead align="left">
			<tr>
				<th>Id zadania</th>
				<th>Id autora</th>
				<th>Data dodania</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(solArr) > 0}">
				<c:forEach begin="0" step="1" end="${fn:length(solArr) - 1}"
					varStatus="status">
					<tr>
						<td>${solArr[status.index].getExcersiseId() }</td>
						<td>${solArr[status.index].getUsersId()}</td>
						<td>${solArr[status.index].getCreated()}</td>
						<td>
						<a href="<c:url 
						value ="/solDetail?id=${solArr[status.index].getId()}"/>">
						Szczegóły
						</a></td>
					</tr>

				</c:forEach>
			</c:if>
		</tbody>
	</table>


	<jsp:include page="footer.jsp" />
</body>
</html>