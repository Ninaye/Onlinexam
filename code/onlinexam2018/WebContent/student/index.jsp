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
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<div class = "ui container" style = "padding-top: 50px">
	    <h1 class="ui center aligned header" style="color: white;padding-bottom:5px">学生管理系统</h1>
	    <h3 class="ui center aligned header" style="color: white;padding-bottom:20px">近期考试</h3>
	    <table class="ui inverted center aligned table">
	      <thead>
	        <tr>
	          <th style="width:140px">考试科目</th>
	          <th style="width:140px">考试名称</th>
	          <th style="width:160px">考试截止时间</th>
	          <th style="width:110px">进入考试</th>
	        </tr>
	      </thead>
	      <tbody>
	        <c:forEach var="test" items="${testsList}">
		        <tr>
		         	<td style = "color: teal"><i class="book icon"></i><b>${test.cname }</b></td>
					<td style = "color: pink"><i class="file icon"></i><b>${test.name}</b></td>
					<td style = "color: red; width : 160px"><i class="warning sign icon"></i><b>${test.endDate }</b></td>
					<td style = "color: red"><a href = "studentTest?testId=${test.id}" style = "color: red"><i class="edit icon"></i><b>开始考试</b></a></td>
		        </tr>
	        </c:forEach>
	      </tbody>
	    </table>
  	</div>
</body>
</html>