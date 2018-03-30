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
  	<div class = "ui container" style = "width: 650px">
	    <div class="ui inverted segment" style = "opacity:0.7">

	      	<form class="ui large form" action="studentAddServlet" method="post">
		        <div class="four fields" style="text-align: center;padding-right: 40px;padding-top:30px">
					<div class = "ui container" style="padding: 6px">
						<h3>所在学院</h3>
					</div>
					<div class = "ui container">
						<input type="text" placeholder="所在学院" name="school" id="school"/>
					</div>
					<div class = "ui container" style="padding: 6px">
						<h3>学生学号</h3>
					</div>
					<div class = "ui container">
						<input type="text" placeholder="学生学号" name="studentId" id="studentId"/>
					</div>
				</div>

				<div class="four fields" style="text-align: center;padding-right: 40px;padding-top:10px">
					<div class = "ui container" style="padding: 6px">
						<h3>学生姓名</h3>
					</div>
					<div class = "ui container">
						<input type="text" placeholder="学生姓名" name="studentName" id="studentName"/>
					</div>
					<div class = "ui container" style="padding: 6px">
						<h3>学生密码</h3>
					</div>
					<div class = "ui container">
						<input type="password" placeholder="学生密码" name="studentpwd" id="studentpwd"/>
					</div>
				</div>
				<div class="four fields" style="text-align: center;padding-right: 40px;padding-top:10px">
					<div class = "ui container" style="padding-top: 5px">
		            	<h3>学生性别</h3>
		            </div>
		            <div class="ui form" style = "margin:0 auto;width :100px">
					  	<div class="inline fields" style = "height: 34px"">
					    	<div class="field">
					      		<div class="ui radio checkbox">
					        		<input name="sex" tabindex="0" class="hidden" type="radio" value = "男">
					        		<label style = "color:white">男</label>
					      		</div>
					    	</div>
					    	<div class="field">
					      		<div class="ui radio checkbox">
					        		<input name="sex" tabindex="0" class="hidden" type="radio" value = "女">
					        		<label style = "color:white">女</label>
					      		</div>
					    	</div>
					  	</div>
					</div>
		            <div class = "ui container" style="padding: 6px">
		            	<h3>选择班级</h3>
		            </div>
		            <div class = "ui container">
		              	<select class = "ui fluid icon dropdown" name="stuClass">
              				<c:forEach var="stuclass" items="${stuclassList}">
               	 				<option value=${stuclass.scid}>${stuclass.scname}</option>
              				</c:forEach>
            			</select>
		            </div>	
				</div>
				<div class="ui fluid">
					<div class = "ui container">
						<div style = "width: 300px;margin:0 auto;">
							<div class="two fields" style="text-align: center;padding-top: 5px">
		            			<div class = "ui container" style="padding: 6px;width:100px">
									<h3>出生日期</h3>
								</div>
								<div class = "ui container" style = "width:175px">
									<input type="date" name="date" id="date"/>
								</div>
		         			</div>
						</div>
					</div>
				</div>
		      	<div class="ui fluid" style = "padding-top:15px;padding-bottom:30px">
		        	<div class="ui fluid large teal submit button" style = "width: 180px;margin:0 auto;"><i class="upload icon"></i>Submit</div>
		      	</div>
	      	</form>
	    </div>
  	</div>
  	<script>
		$('.ui.radio.checkbox')
	  	.checkbox()
		;
	</script>
</body>
</html>