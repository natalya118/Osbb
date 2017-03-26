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
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<script src="<c:url value='/js/jquery-3.1.1.min.js' />"
	type="text/javascript"></script>
<script src="<c:url value='/js/app.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/sockjs-0.3.4.js' />"
	type="text/javascript"></script>
<script src="<c:url value='/js/stomp.js' />" type="text/javascript"></script>
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
<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/resources/chat.css' />"
	rel="stylesheet" />
</head>

<body>

<%@include file="left_menu.jsp"%>
	    <div class="chat">
      <div class="chat-header clearfix">
        
        <div class="chat-about">
          <div class="chat-with">${chat.topic}</div>
        </div>
        <i class="fa fa-star"></i>
      </div>
      
      <div class="chat-history">
        <ul>
        <c:forEach items="${messages}" var="message">
          <li class="clearfix">
            <div class="message-data align-right">
              <span class="message-data-time" >10:10, Сьогодні</span> &nbsp; &nbsp;
              <span class="message-data-name" >${message.authorId}</span> <i class="fa fa-circle me"></i>
              
            </div>
            <div class="message other-message float-right">
              ${message.messageText}
            </div>
          </li>
          </c:forEach>
          
          
        </ul>
        
      </div>
      <form>
      <div class="chat-message clearfix">
        <textarea name="message-to-send" id="newmess" placeholder ="Повідомлення" rows="3"></textarea>
                
        
        <button id="send"  type="submit">ВІДПРАВИТИ</button>

      </div>
      </form>
      
    </div>

	<script type="text/javascript">
	var sendToLoc = "/app/chat/"+ "${chat.id}";
	
	var stompClient = null;

	function setConnected(connected) {
	    $("#connect").prop("disabled", connected);
	    $("#disconnect").prop("disabled", !connected);
	    if (connected) {
	        $("#conversation").show();
	    }
	    else {
	        $("#conversation").hide();
	    }
	    $("#messages").html("");
	}


	function connect() {
		console.log("before");
		console.log('/osbb/chats/'+ "${chat.id}");
	    var socket = new SockJS('/osbb/chat/');
	    console.log("before2");
	    stompClient = Stomp.over(socket);
	   
	    stompClient.connect({}, function (frame) {
	        setConnected(true);
	        console.log('Connected: ' + frame);
	        stompClient.subscribe('/topic/messages/' +"${chat.id}", function () {
	        	//v if()
	        	location.reload();
	            
	        });
	    });
	}

	function disconnect() {
	    if (stompClient != null) {
	        stompClient.disconnect();
	    }
	    setConnected(false);
	    console.log("Disconnected");
	}
	document.addEventListener('DOMContentLoaded', function() {
		
		   connect();
		}, false);
	function sendName() {
	    stompClient.send(sendToLoc, {}, JSON.stringify({'messageText': $("#newmess").val(), 'author': 1, 'chatId' : 2}));
	    
	}

	function showGreeting(message) {
	    $("#greetings").append("<tr><td>" + message + "</td></tr>");
	}

	$(function () {
	    $("form").on('submit', function (e) {
	        e.preventDefault();
	    });
	    $( "#connect" ).click(function() { connect(); });
	    $( "#disconnect" ).click(function() { disconnect(); });
	    $( "#send" ).click(function() { sendName(); });
	});


	</script>

</body>
</html>