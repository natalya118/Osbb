<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html">
<title>ОСББ</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>
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
<script
	src="<c:url value='static/resources/bootstrap-3.3.7-dist/js/bootstrap.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<c:url value='/static/resources/css/news.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/chat.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/osbbpage.css' />"
	rel="stylesheet" />
</head>

<body>
	<%@include file="left_menu.jsp"%>
	<div class="supreme-container">
		<div id="snav" class="en">
			<ul>
				<li><a href="#"> <i class="pe pe-7s-user"></i> <span>Home</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-chat"></i> <span>Чат</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-light"></i> <span>Счетчики</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-cash"></i> <span>Счета</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-help1"></i> <span>Помощь</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-search"></i> <span>Поиск</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-search"></i> <span>Поиск</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-search"></i> <span>Поиск</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-search"></i> <span>Поиск</span>
				</a></li>
				<li><a href="#"> <i class="pe pe-7s-search"></i>
				</a></li>
			</ul>
		</div>
		<div class="container clearfix">
			<div class="osbb-cont">
				<div class="img-cont">
					<img
						src="http://s3-us-west-1.amazonaws.com/witty-avatars/default-avatar-5-l.jpg"
						class="osbb-pic">
				</div>
				<div class="information">
					<h1 class="osbb-title">КотоОсбб</h1>
					<div class="address">
						<p class="address1">Київ, р-н Подільський</p>
					</div>
				</div>
				<c:forEach items="${houses}" var="house">
					<div class="home">
						<div class="address">
							<span class="address2" data-toggle="collapse"
								data-target="#table${house.id}">${house.street},
								${house.number}</span> <span class="pdf" data-toggle="modal"
								data-target="#pdf-modal">pdf</span> <span
								class="config pe-7s-config" data-toggle="modal"
								data-target="#config-home-modal"></span>
						</div>

						<div class="table collapse" id="table${house.id}">
							<table>
								<thead>
									<tr>
										<th>Ім'я</th>
										<th>Прізвище</th>
										<th>№ квартири</th>
										<th>e-mail</th>
										<th>Логін</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${house.realties}" var="realty">
										<tr>
											<td class="name">${realty.owner.firstName}</td>
											<td class="lastname">${realty.owner.lastName}</td>
											<td class="apartment">${realty.realtyNumber}</td>
											<td class="email">${realty.owner.email}</td>
											<td class="login">${realty.owner.ssoId}</td>
											<td data-toggle="modal" data-target="#delete-modal"
												class="delete"><button type="button" class="close"
													data-dismiss="modal">&times;</button></td>
										</tr>
										
										</c:forEach>
										
								</tbody>
							</table>
						</div>

					</div>
				</c:forEach>


				<button class="new-home" data-toggle="modal"
					data-target="#new-home-modal">
					<i class="fa fa-plus"></i><span>Додати будинок</span>
				</button>
			</div>
		</div>
		<img id="back" src="111.png">
	</div>

	<div id="new-home-modal" class="modal fade" role="dialog">
		<form:form modelAttribute="newhouse" method="POST"
			action="/osbb/newhouse">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Додати будинок</h4>
					</div>
					<div class="modal-body">
						<form:input path="street" type="text" placeholder="Вулиця"
							class="new-home-input" />
						<form:input path="number" type="text" placeholder="Номер"
							class="new-home-input" />
						<form:input path="flatsFrom" type="text"
							placeholder="Квартири від" class="new-home-input half-input" />
						<form:input path="flatsTo" type="text" placeholder="до"
							class="new-home-input half-input" />
					</div>

					<div class="modal-footer">
						<div class="form-actions">
							<button type="submit" class="add-news-btn">Додати</button>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<div id="delete-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Скинути користувача</h4>
				</div>
				<div class="modal-body">
					Ви дійсно бажаєте скинути цього користувача?
					<div class="tip">
						<i class="fa fa-question"></i><span class="tip-text">Система
							згенерує нові дані для входу</span>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="yes-btn" data-dismiss="modal">Так</button>
					<button type="button" class="no-btn" data-dismiss="modal">Ні</button>
				</div>
			</div>
		</div>
	</div>

	<div id="config-home-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Редагувати будинок</h4>
				</div>
				<div class="modal-body">
					<input type="text" placeholder="Вулиця" class="config-home-input" />
					<input type="text" placeholder="Номер" class="config-home-input" />
					<button type="button" class="delete-home-btn" data-dismiss="modal"
						data-toggle="modal" data-target="#delete-home-modal">Видалити
						будинок</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="add-news-btn">Зберегти</button>
				</div>
			</div>
		</div>
	</div>

	<div id="delete-home-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Видалити будинок</h4>
				</div>
				<div class="modal-body">
					Ви дійсно бажаєте видалити цей будинок?
					<div class="modal-footer">
						<button type="button" class="yes-btn" data-dismiss="modal">Так</button>
						<button type="button" class="no-btn" data-dismiss="modal">Ні</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div id="pdf-modal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Згенерувати pdf-файл з даними для
						входу</h4>
				</div>
				<div class="modal-body">
					<div class="qq">
						<section class="section section--aava">
							<div class="toggle-button toggle-button--aava"
								data-toggle="collapse" data-target="#coll">
								<input id="toggleButton" type="checkbox" checked> <label
									for="toggleButton" data-on-text="для всіх"
									data-off-text="оберіть квартири"></label>
								<div class="toggle-button__icon"></div>
							</div>
						</section>
					</div>
					<div class="for-all"></div>
					<div class="new-dialog-list collapse" id="coll">
						<ul class="list">
							<li class="clearfix">
								<div class="about">
									<div class="name">квартира №666</div>
									<div class="toggles">
										<input type="checkbox" name="checkbox1" id="checkbox1"
											class="ios-toggle" /> <label for="checkbox1"
											class="checkbox-label"></label>
									</div>
								</div>
							</li>
							<li class="clearfix">
								<div class="about">
									<div class="name">квартира №667</div>
									<div class="toggles-container">
										<div class="toggles">
											<input type="checkbox" name="checkbox2" id="checkbox2"
												class="ios-toggle" /> <label for="checkbox2"
												class="checkbox-label"></label>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="add-dialog-btn">Згенерувати</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>