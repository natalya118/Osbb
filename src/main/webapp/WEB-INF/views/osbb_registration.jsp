<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">
		<%@include file="authheader.jsp"%>

		<div class="well lead">Main Registration Form</div>
		<form:form method="POST" class="form-horizontal">

			
			<spring:bind path="osbb.id">
				<input type="hidden" id="id" />
			</spring:bind>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">First Name</label>
					<div class="col-md-7">
						<spring:bind path="user.firstName">
							<input type="text" id="firstName" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Last Name</label>
					<div class="col-md-7">
						<spring:bind path="user.lastName">
							<input type="text" id="lastName" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Email</label>
					<div class="col-md-7">
						<spring:bind path="user.email">
							<input type="text" id="email" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Login</label>
					<div class="col-md-7">
						<spring:bind path="user.ssoId">
							<input type="text" id="ssoId" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Password</label>
					<div class="col-md-7">
						<spring:bind path="user.password">
							<input type="password" id="password" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Osbb code</label>
					<div class="col-md-7">
						<spring:bind path="osbb.osbbCode">
							<input type="text" id="osbbCode" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Osbb name</label>
					<div class="col-md-7">
						<spring:bind path="osbb.name">
							<input type="text" id="name" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable">Osbb city</label>
					<div class="col-md-7">
						<spring:bind path="osbb.city">
							<input type="text" id="city" class="form-control input-sm" />
						</spring:bind>
					</div>
				</div>
			</div>

			<input type="submit" value="Create" />
		</form:form>

	</div>
</body>
</html>