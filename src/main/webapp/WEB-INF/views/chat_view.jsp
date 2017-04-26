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

<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<script src="<c:url value='/js/jquery-3.1.1.min.js' />"
	type="text/javascript"></script>
<script src="<c:url value='/js/app.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/sockjs-0.3.4.js' />"
	type="text/javascript"></script>
<script src="<c:url value='/js/stomp.js' />" type="text/javascript"></script>
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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>
	
	<script type="text/javascript"	src="http://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.0/handlebars.min.js"></script>
        <script type="text/javascript"	src="http://cdnjs.cloudflare.com/ajax/libs/list.js/1.1.1/list.min.js"></script>
<script src="<c:url value='/static/resources/script.js' />"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="<c:url value='/static/resources/style.css' />"
	rel="stylesheet" />

<style>
@import url(https://fonts.googleapis.com/css?family=Lato:400,700);
*, *:before, *:after {
  box-sizing: border-box;
    -webkit-transition:.25s ease-in-out;
   -moz-transition:.25s ease-in-out;
     -o-transition:.25s ease-in-out;
        transition:.25s ease-in-out;
outline:none;
}

body {
  background: #C5DDEB;
  font: 14px/20px "Cuprum", Arial, sans-serif;
  padding: 40px 0;
  color: #666;
}

.container {
  margin: 0 auto;
    margin-top: 3%;
  width: 100%;
  background: #F2F5F8;
    height: 100%;
}

.people-list {
    margin-left: 10%;
  width: 100%;
  float: left;
}
.people-list .search {
  padding: 20px;
    margin-left: -5%;
}
.people-list input {
  border-radius: 35px;
  border: none;
  padding: 14px;
  color: #666;
  background: #eaeaea;
  width: 90%;
  font-size: 14px;
}

.last-messsage{
    position: absolute;
    right: 15%;
    margin-top: -42px;
}

.last-message-time{
   color:  #92959E;
}

.people-list .fa-search {
  position: relative;
  left: -25px;
}
.people-list ul, .new-dialog-list ul{
  padding: 20px;
  height: 300px;
}
.people-list ul li{
    padding-top: 20px;
    border-bottom: 2px solid white;
    list-style: none;
    margin-left: 5%;
  padding-bottom: 20px;
}
.people-list img,.new-dialog-list img {
  float: left;
}
.people-list .about, .new-dialog-list .about {
  float: left;
  margin-top: 8px;
}
.people-list .about, .new-dialog-list .about {
  padding-left: 8px;
}
.people-list .status, .new-dialog-list .status {
  color: #92959E;
}

.chat li{
    list-style: none;
}
.chat {
    margin-left: 5%;
  width: 95%;
    margin-top: 3%;
  float: left;
  background: #F2F5F8;
  color: #434651;
}
.chat .chat-header {
  padding: 20px;
  border-bottom: 2px solid white;
}
.chat .chat-header img {
  float: left;
}
.chat .chat-header .chat-about {
  float: left;
  padding-left: 10px;
  margin-top: 6px;
}
.chat .chat-header .chat-with {
  font-weight: bold;
  font-size: 16px;
}
.chat .chat-header .chat-num-messages {
  color: #92959E;
}
.chat .chat-header .fa-star {
  float: right;
  color: #D8DADF;
  font-size: 20px;
  margin-top: 12px;
}
.chat .chat-history {
  padding: 30px 30px 20px;
  border-bottom: 2px solid white;
  overflow-y: scroll;
  height: 62%;
}
.chat .chat-history .message-data {
  margin-bottom: 15px;
}
.chat .chat-history .message-data-time {
  color: #a8aab1;
  padding-left: 6px;
}
.chat .chat-history .message {
  color: white;
  padding: 18px 20px;
  line-height: 26px;
  font-size: 16px;
  border-radius: 10px;
  margin-bottom: 30px;
  width: 40%;
  position: relative;
}
.chat .chat-history .message:after {
  bottom: 100%;
  left: 7%;
  border: solid transparent;
  content: " ";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
  border-bottom-color: #86BB71;
  border-width: 10px;
  margin-left: -10px;
}
.chat .chat-history .my-message {
  background: #86BB71;
}
.chat .chat-history .other-message {
  background: #94C2ED;
}
.chat .chat-history .other-message:after {
  border-bottom-color: #94C2ED;
  left: 93%;
}
.chat .chat-message {
    height: 27%;
  padding: 30px;
}
.chat .chat-message textarea {
  width: 100%;
  border: none;
  padding: 10px 20px;
  font: 14px/22px "Cuprum", Arial, sans-serif;
  margin-bottom: 10px;
  border-radius: 5px;
  resize: none;
}
.chat .chat-message .fa-file-o, .chat .chat-message .fa-file-image-o {
  font-size: 16px;
  color: gray;
  cursor: pointer;
}
.chat .chat-message button {
  float: right;
  color: #94C2ED;
  font-size: 16px;
  text-transform: uppercase;
  border: none;
  cursor: pointer;
  font-weight: bold;
  background: #F2F5F8;
}
.chat .chat-message button:hover {
  color: #75b1e8;
}

.online, .offline, .me {
  margin-right: 3px;
  font-size: 10px;
}

.online {
  color: #86BB71;
}

.offline {
  color: #E38968;
}

.me {
  color: #94C2ED;
}

.align-left {
  text-align: left;
}

.align-right {
  text-align: right;
}

.float-right {
  float: right;
}

.clearfix:after {
  visibility: hidden;
  display: block;
  font-size: 0;
  content: " ";
  clear: both;
  height: 0;
}
#back{
    left: 0;
}
.list img{
    clip-path: circle(at center);
    width: 50px;
}

.new-dialog{
    color: white;
    background-color: #86BB71;
    border:none;
    border-radius: 35px;
    padding: 10px 30px;
    margin-top: 20px;
    margin-left: -3%;
}

.new-dialog span{
    margin-left: 25px;
    display: block;
    margin-top: -20px;
}

.fa-plus{
    font-size: 20px;
    margin-left: -80px;
}

.add-dialog-btn{
    position: relative;
    vertical-align: top;
    width: 100%;
    height: 50px;
    padding: 0;
    font-size: 18px;
    color: white;
    text-align: center;
    text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
    background: #f0776c;
    border: 0;
    border-bottom: 2px solid #d76b60;
    border-radius: 35px;
    cursor: pointer;
    -webkit-box-shadow: inset 0 -2px #d76b60;
    box-shadow: inset 0 -2px #d76b60;
}

.modal-header{
    border-top-left-radius: 35px;
    border-top-right-radius: 35px;
    text-align: center;
    background-color: #eaeaea;
}

.modal-content{
    border-radius: 35px;
    margin-top: 50px;
}

body.modal-open .supreme-container{
    -webkit-filter: blur(6px);
    -moz-filter: blur(6px);
    -o-filter: blur(6px);
    -ms-filter: blur(6px);
    filter: blur(6px);
}

.close{
    font-size: 35px;
    color: #E38968;
    opacity: 1;
    margin-right: 10px
}

.new-dialog-list ul li{
    border-bottom: 1px solid #ddd;
    padding-top: 10px;
    list-style: none;
}

.new-dialog-list{
    height: 300px;
    overflow-y:auto;
}

input {
  font-family: inherit;
  color: inherit;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

#new-dialog-input {
  font: 13px/20px 'Helvetica', sans-serif;
  width: 100%;
  height: 50px;
  margin-bottom: 25px;
  padding: 0 20px 2px;
  font-size: 16px;
  background: white;
  border: 2px solid #ebebeb;
  border-radius: 35px;
  -webkit-box-shadow: inset 0 -2px #ebebeb;
  box-shadow: inset 0 -2px #ebebeb;
}
#new-dialog-input:focus {
  border-color: #62c2e4;
  outline: none;
  -webkit-box-shadow: inset 0 -2px #62c2e4;
  box-shadow: inset 0 -2px #62c2e4;
}

.toggles{
    margin-top: -40px;
    margin-left: 220px;
}
.ios-toggle,.ios-toggle:active{
position:absolute;
top:-5000px;
height:0;
width:0;
opacity:0;
border:none;
outline:none;
}
.checkbox-label{
display:block;
position:relative;
padding:10px;
margin-bottom:20px;
font-size:14px;
margin-left: 45px;
line-height:16px;
width:100%;
height:36px;
/*border-radius*/
-webkit-border-radius:18px;
   -moz-border-radius:18px;
        border-radius:18px;
background:#f8f8f8;
font-weight: lighter;
cursor:pointer;
}
.checkbox-label:before{
font-weight: lighter;
content:'';
display:block;
position:absolute;
z-index:1;
line-height:34px;
text-indent:40px;
height:36px;
width:36px;
/*border-radius*/
-webkit-border-radius:100%;
   -moz-border-radius:100%;
        border-radius:100%;
top:0px;
left:0px;
right:auto;
background:white;
/*box-shadow*/
-webkit-box-shadow:0 3px 3px rgba(0,0,0,.2),0 0 0 2px #dddddd;
   -moz-box-shadow:0 3px 3px rgba(0,0,0,.2),0 0 0 2px #dddddd;
        box-shadow:0 3px 3px rgba(0,0,0,.2),0 0 0 2px #dddddd;
}
.checkbox-label:after{
content:attr(data-off);
display:block;
position:absolute;
z-index:0;
top:0;
left:-300px;
padding:10px;
height:100%;
width:300px;
text-align:right;
color:#bfbfbf;
white-space:nowrap;
}
.ios-toggle:checked + .checkbox-label{
/*box-shadow*/
-webkit-box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
   -moz-box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
        box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
}
.ios-toggle:checked + .checkbox-label:before{
left:calc(100% - 36px);
/*box-shadow*/
-webkit-box-shadow:0 0 0 2px transparent,0 3px 3px rgba(0,0,0,.3);
   -moz-box-shadow:0 0 0 2px transparent,0 3px 3px rgba(0,0,0,.3);
        box-shadow:0 0 0 2px transparent,0 3px 3px rgba(0,0,0,.3);
}
.ios-toggle:checked + .checkbox-label:after{
content:attr(data-on);
left:60px;
width:25px;
}

.ios-toggle + .checkbox-label{
/*box-shadow*/
-webkit-box-shadow:inset 0 0 0 0px #96CA2D,0 0 0 2px #dddddd;
   -moz-box-shadow:inset 0 0 0 0px #96CA2D,0 0 0 2px #dddddd;
        box-shadow:inset 0 0 0 0px #96CA2D,0 0 0 2px #dddddd;
}
.ios-toggle:checked + .checkbox-label{
/*box-shadow*/
-webkit-box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
   -moz-box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
        box-shadow:inset 0 0 0 20px #96CA2D,0 0 0 2px #96CA2D;
}
.ios-toggle:checked + .checkbox-label:after{
    color:#96CA2D;
    font-weight: lighter;
}
</style>
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
              <span class="message-data-time" >${message.dateAdded}</span> &nbsp; &nbsp;
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