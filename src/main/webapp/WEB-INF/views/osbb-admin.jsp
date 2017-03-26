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
<%@include file="left_menu.jsp"%>
	<div class="container">
            <h2>Настройки ОСББ</h2>
            <div id="left-block"><img id="upl-img" src="<c:url value='/static/photo.png' />"></div>
            
            <div id="right-block"><h2>${osbb.name}</h2>
            <h3>${osbb.city}</h3>
            </div>
            <br><button type="button" class="add-btn" data-toggle="popover" data-placement="top" data-html="true" title="Додати будинок" data-content="<form><input class='popover-inp' type='text' placeholder='Вулиця' id='street'/><input class='popover-inp' type='text' placeholder='Номер' id='number'/><input class='popover-inp' type='text' placeholder='Номера квартир' id='people'/><button class='popover-btn btn-add'>Додати</button><button class='popover-btn btn-cancel'>Отменить</button></form>">Додати будинок</button>
            <c:forEach items="${houses}" var="house">
            <h3>${house.street}, ${house.number}</h3> <button type="button" class="btn btn-success">PDF</button>
            <table>
					<thead>
						<tr>
							<th>Номер квартири</th>
                            <th>Ім'я власника</th>
                            <th></th>
						</tr>
					</thead>
					<tbody>
						<tr><td class="house-name">12</td><td>Еліот Алдерсон</td><td><button type="button" class="btn">Скинути</button><button type="button" class="btn btn-danger">Видалити</button><button type="button" class="btn btn-success">PDF</button></td></tr>
						<tr><td class="house-name">13</td><td>---</td><td><button type="button" class="btn">Скинути</button><button type="button" class="btn btn-danger">Видалити</button><button type="button" class="btn btn-success">PDF</button></td></tr>
                        <tr><td class="house-name">15</td><td>Дарлін Алдерсон</td><td><button type="button" class="btn">Скинути</button><button type="button" class="btn btn-danger">Видалити</button><button type="button" class="btn btn-success">PDF</button></td></tr>
                        </tbody>
				</table>
				</c:forEach>
                </div>
        </div>
    <img id="back" src="<c:url value='/static/111.png' />">
</body>
</html>