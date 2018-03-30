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
      <form class="ui large form" action="stuClassAddServlet" method="post">
        	<div class="two fields" style="text-align: center;padding-top: 30px;padding-right: 45px">
            	<div class = "ui container" style="padding: 6px"><h3>输入班级名称</h3></div>
            	<div class = "ui container"><input type="text" placeholder="班级名称" name="stuname" id="stuname"></div>
          	</div>
          	<div class="two fields" style="text-align: center;padding-top: 30px;padding-right: 45px">
            	<div class = "ui container" style="padding: 6px"><h3>选择所属方向</h3></div>
            	<div class = "ui container">
             		<select class = "ui fluid icon dropdown" name="depInfo">
                		<c:forEach var="dept" items="${deptList}">
                  			<option value=${dept}>${dept}</option>
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