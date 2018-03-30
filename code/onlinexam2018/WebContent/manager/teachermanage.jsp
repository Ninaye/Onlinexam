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
  <div class = "ui container">
    <h1 class="ui center aligned header" style="color: white">学生管理系统</h1>
    <div style = "float:right; padding-bottom:30px;padding-top : 30px">
    	<div style="text-align:right;float:right">
	      <button class="ui orange right button" style="width: 120px">
	        <a style="color: white"  href="<%=path%>/teacherAddServlet"><i class="add user icon"></i>增加教师</a>
	      </button>
	    </div>
    	<div class="search" style = "float:right;padding-right:30px">
			<form id="form1" method="get" action="teacherQueryServlet">
				<input type = "text" name = "teaname" id = "teaname" style = "height: 38px">
				<input type = "submit" name = "submit" class = "btn_grey" value = "搜索" style = "height: 38px">
			</form>
		</div>
    </div>
    <table class="ui inverted center aligned table">
	  <thead>
	    <tr>
	      <th style="width:140px">教师姓名</th>
	      <th style="width:140px">所教方向</th>
	      <th style="width:110px">修改操作</th>
	      <th style="width:110px">删除操作</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="teacher" items="${teacherList}">
	    <tr>
	      	<td style = "color:orange "><i class="user icon"></i><b>${teacher.tname}</b></td>
			<td style = "color: teal"><i class="student icon"></i><b>${teacher.deptName}</b></td>
	      <td>
	        <button class="ui green button" style="width:110px">
	          <a style="color: white" href = "teacherModifyServlet?id=${teacher.tid}">
	          	<i class="edit icon"></i>修改
	          </a>
	        </button>
	      </td>
	      <td>
	        <button class="ui red button" style="width:110px">
	          <a style="color: white" href = "teacherDeleteServlet?id=${teacher.tid}">
	          	<i class="remove circle icon"></i>删除
	          </a>
	        </button>
	      </td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
  </div>
</body>
</html>