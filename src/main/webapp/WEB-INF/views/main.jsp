<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/resources/css/style.css' />"
	rel="stylesheet" />
</head>

<body>
<div id="clouds">
	<div class="cloud x1"></div>
	<!-- Time for multiple clouds to dance around -->
	<div class="cloud x2"></div>
	<div class="cloud x3"></div>
	<div class="cloud x4"></div>
	<div class="cloud x5"></div>
</div>
        <div class="join">
             <h1 style="margin-bottom: 30px;">Вітаємо!</h1>
        <a href="<c:url value='/newosbb' />">Зареєструвати ОСББ</a>
        <a href="<c:url value='/login' />">Увійти</a>
        </div>
        <img class="q" src="<c:url value='/static/houses.png'/>">
</body>
</html>