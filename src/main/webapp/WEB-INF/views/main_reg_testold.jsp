<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div class="generic-container">
		<%@include file="authheader.jsp" %>

		<div class="well lead">New Main Registration Form</div>
	 	<form:form method="POST" modelAttribute="osbb_creator" action="/osbb/newosbb" class="form-horizontal">
			<form:input type="hidden" path="creator.id" id="id"/>
			<form:input type="hidden" path="osbb.id" id="ido"/>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">First Name</label>
					<div class="col-md-7">
						<form:input type="text" path="creator.firstName" id="firstName" class="form-control input-sm"/>
					</div>
				</div>
			</div>
	
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Last Name</label>
					<div class="col-md-7">
						<form:input type="text" path="creator.lastName" id="lastName" class="form-control input-sm" />

					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">SSO ID</label>
					<div class="col-md-7">
	
								<form:input type="text" path="creator.ssoId" id="ssoId" class="form-control input-sm" />

					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Password</label>
					<div class="col-md-7">
						<form:input type="password" path="creator.password" id="password" class="form-control input-sm" />

					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="creator.email" id="email" class="form-control input-sm" />

					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="osbb_code">Osbb code</label>
					<div class="col-md-7">
						<form:input type="text" path="osbb.osbbCode" id="osbb_code" class="form-control input-sm" />

					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="osbb_name">Osbb name</label>
					<div class="col-md-7">
						<form:input type="text" path="osbb.name" id="osbb_name" class="form-control input-sm" />

					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="osbb_city">Osbb city</label>
					<div class="col-md-7">
						<form:input type="text" path="osbb.city" id="osbb_city" class="form-control input-sm" />

					</div>
				</div>
			</div>

			<div class="form-actions">

				<input type="submit" value="CREATE" class="btn btn-primary " />
				</div>
		</form:form>
		
	</div>
</body>
</html>