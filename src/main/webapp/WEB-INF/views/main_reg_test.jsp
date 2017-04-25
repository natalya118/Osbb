<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/resources/bootstrap-3.3.7-dist/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/bootstrap-3.3.7-dist/fonts/pe-icon-7-stroke.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/animate.min.css' />" rel="stylesheet" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
<script src="<c:url value='/static/resources/jquery-ui/jquery-ui.js' />"></script>
<script type="text/javascript" src="<c:url value='/static/resources/js/courses-script.js' />"></script>
<script src="<c:url value='static/resources/bootstrap-3.3.7-dist/js/bootstrap.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />
</head>

<body>
	<div class="generic-container">
		<img
			src="<c:url value='/static/houses.png'/>" />
		<form:form method="POST" modelAttribute="osbb_creator"
			action="/osbb/newosbb" id="msform" accept-charset="UTF-8">
			<form:input type="hidden" path="creator.id" id="id" />
			<form:input type="hidden" path="osbb.id" id="ido" />
			<div id="connector12"></div>
			<div id="connector23"></div>
			<ul id="progressbar">
				<li class="active">Інформація про себе</li>
				<li>Інформація про ОСББ</li>
				<li>Підтвердження</li>
			</ul>
			<fieldset>
				<h2 class="fs-title">Введіть інформацію про себе</h2>
				<form:input type="text" path="creator.firstName" name="fname" placeholder="Ім'я" /> 
				<form:input type="text" path="creator.lastName" name="lname" placeholder="Прізвище" /> <form:input
					type="text" path="creator.ssoId" name="ssoid" placeholder="Логін" /> <form:input
					type="password" path="creator.password"  name="pass" placeholder="Пароль" /> <form:input
					type="text" path="creator.email" name="email" placeholder="E-mail" /> <input
					type="button" name="next" class="next action-button" value="Далі" />
			</fieldset>
			<fieldset>
				<h2 class="fs-title">Введіть інформацію про Ваше ОСББ</h2>
				<form:input type="text" name="osbbcode" path="osbb.osbbCode" placeholder="Код ЄДРПОУ" /> <form:input
					type="text" name="osbbname" path="osbb.name" placeholder="Назва ОСББ" /> <form:input
					type="text" name="osbbcity" path="osbb.city" placeholder="Місто" /> <input
					type="button" name="previous" class="previous action-button"
					value="Назад" /> <input type="button" name="next"
					class="next action-button" value="Далі" />
			</fieldset>
			<fieldset>
				<h2 class="fs-title">Готово!</h2>
				<h3 class="fs-subtitle">Перевірте введену інформацію і натисніть "Зареєструватися"</h3>
				<input type="button" name="previous" class="previous action-button"
					value="Назад" /> 
		
					<div class="form-actions">

				<input type="submit" value="Реєстрація" class="btn  action-button" />
				</div>
			</fieldset>

		</form:form>

	</div>
</body>
</html>