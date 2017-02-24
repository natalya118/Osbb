<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Osbb Registration Form</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div class="generic-container">


		<div class="well lead">Osbb Registration Form 2</div>
		<form:form method="POST" modelAttribute="osbb" action="/SpringMVCHibernateWithSpringSecurityExample/newosbb"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Osbb name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm" />

					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="city">City</label>
					<div class="col-md-7">
						<form:input type="text" path="city" id="city"
							class="form-control input-sm" />

					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="osbbCode">Osbb
						code</label>
					<div class="col-md-7">

						<form:input type="text" path="osbbCode" id="osbbCode"
							class="form-control input-sm" />

					</div>
				</div>
			</div>
			<div class="form-actions">

				<input type="submit" value="Add" class="btn btn-primary " />
				</div>
		</form:form>



	</div>
</body>
</html>