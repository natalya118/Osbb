<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Особистий кабінет</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>


<link
	href="<c:url value='/static/resources/bootstrap-3.3.7-dist/fonts/pe-icon-7-stroke.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/animate.min.css' />"
	rel="stylesheet" />

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
<script src="<c:url value='/static/resources/jquery-ui/jquery-ui.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/static/resources/js/courses-script.js' />"></script>

<script type="text/javascript"
	src="<c:url value='/static/resources/js/courses-script.js'/>"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>
<script src="<c:url value='/static/resources/bootstrap.js' />"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">

<link href="<c:url value='/static/resources/css/style.css' />"
	rel="stylesheet" />
	<link href="<c:url value='/static/resources/css/chat.css' />"
	rel="stylesheet" />
	<link href="<c:url value='/static/resources/css/news.css' />"
	rel="stylesheet" />
	<link href="<c:url value='/static/resources/css/osbbpage.css' />"
	rel="stylesheet" />
</head>

<body>
        <div class="supreme-container">
        
	<%@include file="left_menu.jsp"%>
    <div class="container clearfix" style="min-height:100%;">
        <div class="osbb-cont">
        <div class="img-cont">
            <img src="http://s3-us-west-1.amazonaws.com/witty-avatars/default-avatar-5-l.jpg" class="osbb-pic">
        </div>
        <div class="information">
            <h1 class="osbb-title">Мій кабінет</h1>
            <img
						src="http://s3-us-west-1.amazonaws.com/witty-avatars/default-avatar-5-l.jpg"
						class="osbb-pic" style="z-index:100;">
            <div class="address">
                <p class="address1" style="color:#777">Моя адреса</p>
                <p class="address1" style="color:#aaa">${realty.house.street}, ${realty.house.number}, кв. ${realty.realtyNumber}, </p>
            </div>
        </div>
            <h2>Інформація про мене</h2>
            <form:form modelAttribute="chat_users" method="POST" 
			action="/osbb/edit-user-${loggedinuser}">
			<h3>Ім'я</h3>
            <input type="text" class="cab-input" placeholder="Ім'я" autofocus><br>
            <h3>Прізвище</h3>
            <input type="text" class="cab-input" placeholder="Прізвище"><br>
            <h3>Логін</h3>
            <input type="text" class="cab-input" placeholder="${loggedinuser}"><br>
            <input type="submit" value="Змінити" class="cab-button">
            </form:form>
        </div>
    </div>
        
        </div>
</body>
</html>