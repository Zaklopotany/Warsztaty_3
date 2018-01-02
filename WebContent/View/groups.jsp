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
	<jsp:include page="/View/header.jsp" /><br>
	<a href="<c:url value="/Groups?id=0"/>">Dodaj Nową Grupę</a>
	<table>
		<thead align="left">
			<tr>
				<th>Id</th>
				<th>Nazwa grupy</th>
				<th>Akcje</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${fn:length(groups) > 0}">
				<c:forEach begin="0" step="1" end="${fn:length(groups) - 1}"
					varStatus="status">
					<tr>
						<td>${groups[status.index].getId() }</td>
						<td><a
							href="<c:url 
						value ="/groupDetails?id=
						${groups[status.index].getId()}"/>">
								${groups[status.index].getName() }</a></td>
						<td><a
							href="<c:url value="/Groups?id=
							${groups[status.index].getId() }"/>">
							Edycja</a></td>
					</tr>

				</c:forEach>
			</c:if>
		</tbody>
	</table>
</body>
</html>