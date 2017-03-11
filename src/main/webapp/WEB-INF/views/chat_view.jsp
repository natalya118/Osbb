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

<script src="<c:url value='/js/jquery-3.1.1.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/app.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/sockjs-0.3.4.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/stomp.js' />" type="text/javascript"></script>
</head>

<body>

	<div class="generic-container">
		<%@include file="authheader.jsp"%>

		<div class="well lead">Chat</div>
		<button id="connect" class="btn btn-default" type="submit">Connect</button>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Author</th>
					<th>Message</th>

				</tr>
			</thead>
			<tbody >
				<c:forEach items="${messages}" var="message">
					<tr>
						<td>${message.authorId}</td>
						<td>${message.messageText}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="well">
			<form class="form-inline">
                <div class="form-group">
                    <label for="newmess">Input your message:</label>
                    <input type="text" id="newmess" class="form-control" placeholder="message">
                </div>
                <button id="send" class="btn btn-default" type="submit">Send</button>
            </form>
		</div>
	</div>
</body>
</html>