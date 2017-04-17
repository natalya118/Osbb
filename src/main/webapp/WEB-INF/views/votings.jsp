<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<title>ОСББ</title>
<link
	href="<c:url value='/static/resources/bootstrap-3.3.7-dist/css/bootstrap.css' />"
	rel="stylesheet" />
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

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>

<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
<script type="text/javascript"
	src="<c:url value='/static/resources/js/circle-progress.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/static/resources/js/polling.js' />"></script>

<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">




<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/chat.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/news.css' />"
	rel="stylesheet" />


</head>

<body>

	<%@include file="left_menu.jsp"%>

	<div class="supreme-container">
		<div class="container clearfix">
			<div class="osbb-news-list pol" id="osbb-news-list">
				<button class="new-poll" data-toggle="modal"
					data-target="#new-news-modal">
					<i class="fa fa-plus"></i><span>Додати голосування</span>
				</button>
				<div class="search">
					<input type="text" placeholder="search" /> <i class="fa fa-search"></i>
				</div>
				<ul class="news-list">
					<c:forEach items="${allvotings}" var="v">
						<li class="clearfix polling">
							<button type="button" class="close" data-toggle="modal"
								data-target="#delete-modal">&times;</button>
							<div class="about poll">
								<div class="name">${v.topic}</div>
								<div class="poll-info">
									<div>${v.topic}</div>
									<div id="more-news${v.id}" class="collapse more-news">
										${v.description}</div>
									<button class="show-more" data-toggle="collapse"
										data-target="#more-news${v.id}">Детальніше</button>
								</div>
								<div class="details polli">

									<c:if test="${! v.voted}">
										<c:forEach items="${v.variants}" var="var">
											<div class="col-sm-2 col-xs-6 col-lg-2 col-md-2 first">
												<div class="ch-item ch-img-1 btn-poll">
													<div class="ch-info">
														<h1 style="font-size:100px; text-align: center;"><i class="pe pe-7s-like"></i></h1>
														

													</div>
													</div>
													<div class="answer">${var.variant}</div>
												

											</div>
										</c:forEach>
									</c:if>

								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<img id="back" src="111.png">
	</div>
	<div id="new-news-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<form:form modelAttribute="newVoting" method="POST"
				action="/osbb/votings/newvoting">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Додати голосування</h4>
					</div>
					<div class="modal-body">
						<form:input path="topic" type="text"
							placeholder="Заголовок голосування" id="new-news-input-title" />
						<form:textarea path="description" placeholder="Текст голосування"
							id="new-news-input-text"></form:textarea>
						<div id="variants">
							<form:input path="v1" type="text" placeholder="Варіант №1"
								class="variant" />
							<form:input path="v2" type="text" placeholder="Варіант №2"
								class="variant" />
							<form:input path="v3" type="text" placeholder="Варіант №3"
								class="variant" />
							<form:input path="v4" type="text" placeholder="Варіант №4"
								class="variant" />
							<form:input path="v5" type="text" placeholder="Варіант №5"
								class="variant" />
						</div>
						<button type="button" class="add-variant">Додати варіант</button>
						<div class="modal-footer">
							<div class="form-actions">
								<input type="submit" class="add-news-btn" value="Додати" />
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<div id="delete-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Видалити голосування</h4>
				</div>
				<div class="modal-body">Ви дійсно бажаєте видалити це
					голосування?</div>
				<div class="modal-footer">
					<button type="button" class="yes-btn" data-dismiss="modal">Так</button>
					<button type="button" class="no-btn" data-dismiss="modal">Ні</button>
				</div>
			</div>
		</div>
	</div>

	<div id="votedForThis" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Проголосували за цей варіант</h4>
				</div>
				<div class="modal-body">
					<ul class="list">
						<li class="clearfix">
							<div class="about">
								<div class="name">Котя</div>
								<div class="status">
									<i class="fa fa-circle online"></i> в мережі
								</div>
								<div class="last-messsage">
									<div class="last-message-text">Проголосував</div>
									<div class="last-message-time">10:10, Сьогодні</div>
								</div>
							</div>
						</li>

						<li class="clearfix">
							<div class="about">
								<div class="name">Котя</div>
								<div class="status">
									<i class="fa fa-circle offline"></i> був 10 хвилин назад
								</div>
								<div class="last-messsage">
									<div class="last-message-text">Проголосував</div>
									<div class="last-message-time">10:10, Сьогодні</div>
								</div>
							</div>
						</li>

						<li class="clearfix">
							<div class="about">
								<div class="name">Котя</div>
								<div class="status">
									<i class="fa fa-circle online"></i> в мережі
								</div>
								<div class="last-messsage">
									<div class="last-message-text">Проголосував</div>
									<div class="last-message-time">10:10, Сьогодні</div>
								</div>
							</div>
						</li>

						<li class="clearfix">
							<div class="about">
								<div class="name">Котя</div>
								<div class="status">
									<i class="fa fa-circle online"></i> в мережі
								</div>
								<div class="last-messsage">
									<div class="last-message-text">Проголосував</div>
									<div class="last-message-time">10:10, Сьогодні</div>
								</div>
							</div>
						</li>

						<li class="clearfix">
							<div class="about">
								<div class="name">Котя</div>
								<div class="status">
									<i class="fa fa-circle online"></i> в мережі
								</div>
								<div class="last-messsage">
									<div class="last-message-text">Проголосував</div>
									<div class="last-message-time">10:10, Сьогодні</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
				<div class="modal-footer">
					<button type="button" data-dismiss="modal" class="add-news-btn">Закрити</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>