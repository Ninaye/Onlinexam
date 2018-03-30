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
  	<script>
	$(document)
		.ready(function() {
			$('.ui.form')
				.form({
				})
			;
		})
	;
	</script>
</head>
<body>
	<%@ include file="./menu.jsp"%>
  	<div class = "ui container">
    	<h1 class="ui center aligned header" style="color: white">学生管理系统</h1>
    	</br></br></br>
  	</div>
  	<div class = "ui container" style = "width: 500px">
	    <div class="ui inverted segment" style = "opacity:0.7">

	      	<form class="ui large form" action="scheduleAddServlet" method="post">

		        <div class="two fields" style="text-align: center;padding-right:45px;padding-top:30px">
		            <div class = "ui container" style="padding: 6px">
		            	<h3>选择课程</h3>
		            </div>
		            <div class = "ui container">
		            	<select class = "ui fluid icon dropdown" name="course">
              				<c:forEach var="c" items="${course}">
                				<option value=${c.cid}>${c.cname}</option>
              				</c:forEach>
            			</select>
		            </div>
		        </div>

		        <div class="two fields" style="text-align: center;padding-right:45px;padding-top:10px">
		            <div class = "ui container" style="padding: 6px">
		            	<h3>选择教师</h3>
		            </div>
		            <div class = "ui container">
		            	<select class = "ui fluid icon dropdown" name="teacher">
              				<c:forEach var="t" items="${teacher}">
                				<option value=${t.tid}>${t.tname}</option>
              				</c:forEach>
            			</select>
		            </div>
		        </div>

		        <div class="two fields" style="text-align: center;padding-right:45px;padding-top:10px">
		            <div class = "ui container" style="padding: 6px">
		            	<h3>选择班级</h3>
		            </div>
		            <div class = "ui container">
		              	<select class = "ui fluid icon dropdown" name="stuClass">
              				<c:forEach var="sc" items="${stuclass}">
                				<option value=${sc.scid}>${sc.scname}</option>
              				</c:forEach>
            			</select>
		            </div>
		         </div>
		      	</br>
		      	<div class="ui fluid" style = "padding-bottom: 20px">
		        	<div class="ui fluid large teal submit button" style = "width: 180px;margin:0 auto;"><i class="upload icon"></i>Submit</div>
		      	</div>

	      	</form>
	    </div>
  	</div>
</body>
</html>