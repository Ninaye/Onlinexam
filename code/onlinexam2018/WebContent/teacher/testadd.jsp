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
  	<div class = "ui container" style = "padding-top:50px;padding-bottom:30px">
    	<h1 class="ui center aligned header" style="color: white">学生管理系统</h1>
  	</div>
  	<div class = "ui container" style = "width: 400px">
	    <div class="ui inverted segment" style = "opacity:0.7">

	      	<form class="ui large form" action="testAddServlet" method="post" >
		        <div class="two fields" style="text-align: center;padding-right: 40px;padding-top:20px" >
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>考试科目</h4>
					</div>
					<div class = "ui container" style = "height:39px">
						<select class = "ui fluid icon dropdown" name="courseid" id="courseid" style = "height:39px">
							<c:forEach var="course" items="${courseList }">
								<option value="${course.cid}">${course.cname}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>试卷名称</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="试题名称为" name="testname" id="testname" style = "height:30px"/>
					</div>
				</div>
				
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>考试截止时间</h4>
					</div>
					<div class = "ui container" style = "width:170px;height:30px">
						<input type="date" name="enddate" id="control_date"  style = "height:30px"/>
					</div>
				</div>
				
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>单项选择题总分/分</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入单选题总分" name="sinscores" id="sinscores" style = "height:30px"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>单项选择题题数</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入总题数" name="sinnum" id="sinnum" style = "height:30px"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>考试时间/分钟</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" value = "45" name="testtime" id="testtime" style = "height:30px"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>面向班级</h4>
					</div>
					
					<div class = "ui container" style = "height:30px; padding-top:5px">
						<c:forEach var="stuclass" items="${classesList}">
							<input type="checkbox" name="classCheck" value="${stuclass.scid}" checked="checked"/>${stuclass.scname}
						</c:forEach>
						<!-- <input type="text" placeholder="请输入正确答案" name="ans" id="ans" style = "height:30px"/> -->
					</div>
				</div>
		      	<div class="ui fluid" style = "padding-top:15px;padding-bottom:20px">
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