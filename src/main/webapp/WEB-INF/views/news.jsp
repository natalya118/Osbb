
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Новини</title>
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet"></link>


<link
	href="<c:url value='/static/resources/bootstrap-3.3.7-dist/fonts/pe-icon-7-stroke.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/animate.min.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/css/style.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/resources/css/news.css' />"
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

<script>
	function setId() {
		var newsToDel = $('#delbutton').val();

		alert($('#delform').attr('action'));
	}
</script>
</head>

<body>
	<div class="supreme-container">
		<%@include file="left_menu.jsp"%>
		<div class="container clearfix">
			<div class="osbb-news-list" id="osbb-news-list">
			<sec:authorize access="hasRole('ADMIN')">
				<button class="new-news" data-toggle="modal"
					data-target="#new-news-modal">
					<i class="fa fa-plus"></i><span>Додати новину</span>
				</button>
				</sec:authorize>
				<div class="search">
					<input type="text" placeholder="search" /> <i class="fa fa-search"></i>
				</div>
				<ul class="news-list">

					<c:forEach items="${news}" var="n">
						<li class="clearfix">
							<a href="<c:url value='/news/remove/${n.id}' />"><button type="button" class="close" data-toggle="modal"
								 id="delbutton"
								value="${n.id}">&times;</button></a>
							<div class="category good">Новина</div>
							<div class="about">
								<div class="name">${n.title}</div>
								<div class="details"></div>
								<div id="more-news1${n.id}" class="collapse more-news">${n.body}
								</div>
							</div>
							<button class="show-more" data-toggle="collapse"
								data-target="#more-news1${n.id}">Детальніше</button>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
		<img id="back" src="<c:url value='/static/111.png'/>">
	</div>

	<div id="new-news-modal" class="modal fade" role="dialog">
		<form:form modelAttribute="addnews" method="POST"
			action="/osbb/news/newnews">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Додати новину</h4>
					</div>
					<div class="modal-body">
						<form:input path="title" type="text"
							placeholder="Заголовок новини" id="new-news-input-title" />
						<form:textarea path="body" placeholder="Текст новини"
							id="new-news-input-text"></form:textarea>
					</div>
					<div class="modal-footer">
						<div class="form-actions">
							<input type="submit" class="add-news-btn" value="Додати">
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>

	<div id="delete-modal" class="modal fade" role="dialog">

		<div class="modal-dialog">
			<form:form method="GET" id="delform" action="/osbb/news/delnews/3">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Видалити новину</h4>
					</div>
					<div class="modal-body">Ви дійсно бажаєте видалити цю новину?
					</div>
					<div class="modal-footer">

						<div class="form-actions">
							<input type="submit" class="yes-btn" 
								value="Так">
						</div>
						<button type="button" class="no-btn" data-dismiss="modal">Ні</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>


</body>
</html>