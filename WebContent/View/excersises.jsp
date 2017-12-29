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
	<table>

		<thead>
			<tr>
				<th>Nazwa</th>
				<th>Akcja</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach varStatus="status" begin="0" step="1"
				end="${fn:length(excersise) - 1}">
				<tr>
					<td>${excersise[status.index].getTitle()}</td>
					<td>
						<a href="<c:url value="/ExcersiseDetail?id=${excersise[status.index].getId()}"/>">Szczegóły</a>&nbsp; 
						<a href="<c:url value=""/>">Edycja</a>&nbsp;
						<a href="<c:url value=""/>">Usuń</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>