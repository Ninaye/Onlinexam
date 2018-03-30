<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}

textarea {
	　　resize: none;
}

.text2 {
	width: 700px;
	line-height: 40px;
	font-size: 16px;
	font-family: Arial, "宋体";
	margin: 0 auto;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="text2">
		<!-- 因为是增加，所以method="post" -->
		<form action="teacherModifyServlet" method="post">
			<input type = "hidden" name = "teacherId" id = "teacherId" value = "${teacher.tid}"></input>
			<table width="1200" border="0" align="center" class="word_darkGrey">
				<tr>
					<td width="103">教师名称：</td>
					<td width="240"><input type="text" name="teachername" id="teachername" value = "${teacher.tname}"/></td>
				</tr>
				<tr>
					<td width="103">教师密码：</td>
					<td width="240"><input type="password" name="teacherpwd" id="teacherpwd"/></td>
				</tr>
				<tr>
					<td>所属方向</td>
					<td><select name="depInfo">
						<c:forEach var="dept" items="${deptList}">
							
							<c:choose>
								<c:when test="${dept.name()==teacher.deptName}">
									<option value = "${dept}" selected = "selected">${dept}</option>
								</c:when>
								
								<c:otherwise>
									<option value = "${dept}">${dept}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="修改教师"
						class="btn_grey"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html> --%>
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
	      	<form class="ui large form" action="teacherModifyServlet" method="post">
	      		<input type = "hidden" name = "teacherId" id = "teacherId" value = "${teacher.tid}"></input>
	      		<div class="two fields" style="text-align: center;padding-top: 30px;padding-right: 45px">
			    	<div class = "ui container" style="padding: 6px">
			    		<h3>教师姓名</h3>
			    	</div>
			    	<div class = "ui container">
			    		<input type="text" name="teachername" id="teachername" value = "${teacher.tname}"/>
			    	</div>
			  	</div>
			
			  	<div class="two fields" style="text-align: center;padding-top: 30px;padding-right: 45px">
			    	<div class = "ui container" style="padding: 6px">
			    		<h3>教师密码</h3>
			    	</div>
			    	<div class = "ui container">
			    		<input type="password" name="teacherpwd" id="teacherpwd"/>
			    	</div>
			  	</div>
			
			  	<div class="two fields" style="text-align: center;padding-top: 30px;padding-right: 45px">
			    	<div class = "ui container" style="padding: 6px">
			    		<h3>选择所属方向</h3>
			    	</div>
			    	<div class = "ui container">
						<select class = "ui fluid icon dropdown" name="depInfo">
							<c:forEach var="dept" items="${deptList}">
								
								<c:choose>
									<c:when test="${dept.name()==teacher.deptName}">
										<option value = "${dept}" selected = "selected">${dept}</option>
									</c:when>
									
									<c:otherwise>
										<option value = "${dept}">${dept}</option>
									</c:otherwise>
								</c:choose>
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