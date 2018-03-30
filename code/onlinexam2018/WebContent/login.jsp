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
	<title>Wecome Login File</title>
	<%@ include file="header_static.jsp"%>
	<style type="text/css">
    body {
      	background-image:url(static/image/login.jpg);
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
  	</style>
  	<script>
  	$(document)
    	.ready(function() {
     	$('.ui.form')
        	.form({
	          	fields: {
	            	username: {
		              	identifier  : 'username',
		              	rules: [
		                	{
			                  	type   : 'empty',
			                  	prompt : 'Please enter your username'
		                	}
		              	]
		            },
		            password: {
		              	identifier  : 'password',
		              	rules: [
		                	{
		                  		type   : 'empty',
		                  		prompt : 'Please enter your password'
		                	},
		                	{
		                  		type   : 'length[6]',
		                  		prompt : 'Your password must be at least 6 characters'
		                	}
		              	]	
		            }
	          	}
        	});
    	});
  	</script>
</head>
<body>
	<div class="ui middle aligned center aligned grid" style = "opacity:0.5">
		<div class="column">
			<h2 class="ui teal image header">
				<div class="content">
					<h1>学生在线考试系统</h1>
				</div>
			</h2> 
			</br>
			<form class="ui large form" action="<%=path%>/loginServlet" method="post">
				<div class="ui stacked segment">
					<div class="field">
						<div class="ui left icon input">
							<i class="user icon"></i>
							<input type="text" name="username" placeholder="Username">
						</div>
					</div>
					<div class="field">
						<div class="ui left icon input">
							<i class="lock icon"></i>
							<input type="password" name="password" placeholder="Password">
						</div>
					</div>
					<div class="field">
						<select class="ui fluid icon dropdown" name = "role" id = "role">
							<option value="admin">Admin</option>
						  	<option value="teacher" selected = "selected">Teacher</option>
						  	<option value="student">Student</option>
						</select>
					</div>
					<div class="ui fluid large teal submit button">Login</div>
				</div>
				<div class="ui error message"></div>
			</form>
			<div class="ui message">
				<b>Welcome here</b>
			</div>
		</div>
	</div>
</body>
</html>