<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chats</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>

	<div class="generic-container">
		<%@include file="authheader.jsp"%>

		<div class="well lead">Chats</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Topic</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${chats}" var="chat">
					<tr>
						<td>${chat.topic}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="well">
			<a href="<c:url value='/newchat' />">Add New Chat</a>
		</div>
	</div>
</body>
</html>