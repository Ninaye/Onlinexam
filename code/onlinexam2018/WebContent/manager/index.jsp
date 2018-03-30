<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<!-- Standard Meta -->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
	<title></title>
	<%@ include file="../header_static.jsp"%>
	<style type="text/css">
   	body {
      	background-image:url(static/image/background.jpg);
        background-position:center;           
        background-repeat:no-repeat；
    }
    body > .grid {
      	height: 100%;
    }
    .image {
      	margin-top: -100px;
    }
    .column {
      	max-width: 450px;
    }
    .ui.secondary.pointing.menu .item {
		margin-left: 0.37em;
		margin-right: 0.37em;
	}
	.ui.secondary.pointing.menu .item:hover {
		border-bottom-color: #fff;
    	border-bottom-style: solid;
    	border-radius: 0;
    	border-bottom-width: 2px;
    }
  	</style>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<!-- <div class = "ui container">
		<h1 class="ui center aligned header" style="color: white">学生管理系统</h1>
		</br></br></br>
	</div> -->
	<div class="ui text container" style="height:400px;padding-top:60px">
		<div class="ui text container" style="color: white;height:400px;text-align: center">
			<div style = "padding-bottom:30px">
				<font size="60px">
	    			<p><b>管理员您好！</b></p>
	    		</font>
	    	</div>
	    	<div>
	    		<font size="60px">
		    		<p><b>欢迎登入学生管理系统！</b></p>
		    	</font>
	    	</div>
	  	</div>
	</div>
</body>
</html>