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

	      	<form id="form1" name="form1" class="ui large form" action="questionModifyServlet" method="post" >
	      		<input type="hidden" name = "id" value = "${que.qid}"/>
		        <div class="two fields" style="text-align: center;padding-right: 40px;padding-top:20px" >
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>试题科目</h4>
					</div>
					<div class = "ui container" style = "height:39px">
						<select class = "ui fluid icon dropdown" name="courseId" id="courseId" style = "height:39px">
							<c:forEach var="course" items="${courseList}">
								<c:choose>
									<c:when test="${course.cid == que.courseId}">
										<option value=${course.cid } selected="selected">${course.cname}</option>
									</c:when>
									<c:otherwise>
										<option value=${course.cid }>${course.cname}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>试题题目</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="试题题目" name="queTitle" id="queTitle"  style = "height:30px" value = "${que.queTitle}"/>
					</div>
				</div>
				
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>选项 A</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入A选项内容" name="choiceA" id="choiceA"  style = "height:30px" value="${que.choiceA}"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>选项 B</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入B选项内容" name="choiceB" id="choiceB" style = "height:30px" value="${que.choiceB}"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>选项 C</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入C选项内容" name="choiceC" id="choiceC" style = "height:30px" value="${que.choiceC}"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>选项 D</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="输入D选项内容" name="choiceD" id="choiceD" style = "height:30px" value="${que.choiceD}"/>
					</div>
				</div>
				<div class="two fields" style="text-align: center;padding-right: 40px;padding-top:5px">
					<div class = "ui container" style="padding: 6px;height:30px">
						<h4>正确答案</h4>
					</div>
					<div class = "ui container" style = "height:30px">
						<input type="text" placeholder="请输入正确答案" name="ans" id="ans" style = "height:30px" value="${que.ans}"/>
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