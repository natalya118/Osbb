<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chats</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>


<link
	href="<c:url value='/static/resources/bootstrap-3.3.7-dist/fonts/pe-icon-7-stroke.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/animate.min.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/style.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/resources/css/chat.css' />"
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
</head>

<body>
<div class="supreme-container">
	<%@include file="left_menu.jsp"%>
	
	<div class="container clearfix">
		<div class="people-list" id="people-list">
			<button class="new-dialog" data-toggle="modal"
				data-target="#new-dialog-modal">
				<i class="fa fa-plus"></i><span>Новий діалог</span>
			</button>

			<div class="search">
				<input type="text" placeholder="search" /> <i class="fa fa-search"></i>
			</div>


			<ul class="list">
				<c:forEach items="${chats}" var="chat">
					<li class="clearfix"><img
						src="http://static.boredpanda.com/blog/wp-content/uploads/2016/04/beautiful-fluffy-cat-british-longhair-2.jpg"
						alt="avatar" />
						<div class="about">
							<div class="name">
								<a href="<c:url value='/chats/${chat.id}' />"
									class="tochat${chat.id}">${chat.topic}</a>
							</div>
							<div class="status">
								<i class="fa fa-circle online"></i> в мережі
							</div>
							<div class="last-messsage">
								<div class="last-message-text">Останнє повідомлення</div>
								<div class="last-message-time">10:10, Сьогодні</div>
							</div>
						</div></li>

				</c:forEach>

			</ul>
		</div>
	</div>
</div>
	<div id="new-dialog-modal" class="modal fade" role="dialog">
	<form:form method="POST" modelAttribute="osbb_creator"
			action="/osbb/newosbb" id="msform">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Новий діалог</h4>
				</div>
				<div class="modal-body">
					<input type="text" placeholder="Назва бесіди" id="new-dialog-input" />
					<div class="new-dialog-list">
						<ul class="list">
							<li class="clearfix">
								<div class="about">
									<div class="name">Котя</div>
									<div class="status">
										<i class="fa fa-circle online"></i> в мережі
									</div>
									<div class="toggles">
										<input type="checkbox" name="checkbox1" id="checkbox1"
											class="ios-toggle" /> <label for="checkbox1"
											class="checkbox-label" data-off="Додати до бесіди"
											data-on="Видалити з бесіди"></label>
									</div>
								</div></li>
							<li class="clearfix">
								<div class="about">
									<div class="name">Котя</div>
									<div class="status">
										<i class="fa fa-circle online"></i> в мережі
									</div>
									<div class="toggles-container">
										<div class="toggles">
											<input type="checkbox" name="checkbox2" id="checkbox2"
												class="ios-toggle" /> <label for="checkbox2"
												class="checkbox-label" data-off="Додати до бесіди"
												data-on="Видалити з бесіди"></label>
										</div>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="add-dialog-btn">Додати</button>
				</div>
			</div>

		</div>
		</form:form>
	</div>
</body>
</html>