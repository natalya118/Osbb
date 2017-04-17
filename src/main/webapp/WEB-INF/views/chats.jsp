<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

<script type="text/javascript">
function getUsers(){
	var sList = [];
	$('input[type=checkbox]').each(
			function() {
				if(this.checked)
				sList.push($(this).val());
			});
	$('#chatusers').val(sList.toString());
	
}
	function doAjax() {
		var csrfParameter = '${_csrf.parameterName}';
		var csrfToken = '${_csrf.token}';
		//var inputText = $("#input_str").val();
		var sList = "";
		$('input[type=checkbox]').each(
				function() {
					sList += "(" + $(this).val() + "-"
							+ (this.checked ? "checked" : "not checked") + ")";
				});
		console.log(sList);

		var topic = $('#new-dialog-input').val();
		console.log('topic ' + topic);
		var csrfParameter = '${_csrf.parameterName}';
		var csrfToken = '${_csrf.token}';
		$.ajax({
			url : '/chats/newchat',
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json',
			mimeType : 'application/json',
			data : ({
				chatId : 1,
				users : sList,
				csrfParameter : csrfToken
			}),
			success : function(data) {

				console.log("efefefefwfw");
			}
		});
	}
</script>
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
						<li class="clearfix">
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
		<form:form modelAttribute="chat_users" method="POST" 
			action="/osbb/chats/newchat">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Новий діалог</h4>
					</div>
					<div class="modal-body">
						<form:input path="newChatTopic" type="text" placeholder="Назва бесіди"
							id="new-dialog-input" />
						<div class="new-dialog-list">
							<ul class="list">

								<c:forEach items="${allusers}" var="u">
									<li class="clearfix">
										<div class="about">
											<div class="name">${u.ssoId}</div>
											<div class="status">
												<i class="fa fa-circle online"></i> в мережі
											</div>
											<div class="toggles">
												<input type="checkbox" name="checkbox${u.ssoId}" id="checkbox${u.ssoId}"
													value="${u.ssoId}" class="ios-toggle" /> <label
													for="checkbox${u.ssoId}" class="checkbox-label"
													data-off="Додати до бесіди" data-on="Видалити з бесіди"></label>
											</div>
										</div>
									</li>
								</c:forEach>

							</ul>
							<form:input path ="ustr" name="ustr" type="hidden" id="chatusers"
					/>
						</div>
					</div>
					<div class="modal-footer">
						<div class="form-actions">
							<input onClick="getUsers()" type="submit" value="Додати" class="add-dialog-btn">
						</div>
					</div>
				</div>
				
			</div>
		</form:form>

	</div>
</body>
</html>