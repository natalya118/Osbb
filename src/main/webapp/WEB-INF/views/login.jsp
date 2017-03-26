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
<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />
</head>

<body>
	<c:url var="loginUrl" value="/login" />
	<form action="${loginUrl}" method="post" class="sign-up">
		<h1 class="sign-up-title">Увійти в систему</h1>
		<c:if test="${param.error != null}">
			<div class="alert alert-danger">
				<p>Invalid username and password.</p>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<p>You have been logged out successfully.</p>
								</div>
							</c:if>
		<input type="text" id="username" name="ssoId" class="sign-up-input" placeholder="Логін" autofocus>
		<input type="password" id="password" name="password" class="sign-up-input" placeholder="Пароль">



		<div class="input-group input-sm">
			<div class="checkbox">
				<label><input type="checkbox" id="rememberme"
					name="remember-me"> Remember Me</label>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<div class="form-actions">
			<input type="submit" class="sign-up-button"
				value="Увійти">
		</div>
	</form>
		<img
			src="<c:url value='/static/houses.png'/>" />
</body>
</html>