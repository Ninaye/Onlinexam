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
    <div style="text-align:right">
      <button class="ui orange right button" style="width: 150px">
        <a style="color: white"  href="<%=path%>/studentAddServlet"><i class="add user icon"></i>添加学生信息</a>
      </button>
    </div>
    <table class="ui inverted center aligned table">
      <thead>
        <tr>
          <th style="width:140px">学号</th>
          <th style="width:140px">姓名</th>
          <th style="width:140px">学院</th>
          <th style="width:140px">班级</th>
          <th style="width:140px">所属方向</th>
          <th style="width:140px">登录密码</th>
          <th style="width:140px">学生性别</th>
          <th style="width:140px">出生日期</th>
          <th style="width:110px">修改操作</th>
          <th style="width:110px">删除操作</th>

        </tr>
      </thead>
      <tbody>
        <c:forEach var="student" items="${studentList}">
        <tr>
         	<td style = "color: red "><b>${student.sid}</b></td>
	        <td style = "color: orange"><i class="user icon"></i><b>${student.sname}</b></td>
	        <td style = "color: pink"><i class="book icon"></i><b>${student.school}</b></td>
	        <td style = "color: Olive"><i class="users icon"></i><b>${student.scname}</b></td>
	        <td style = "color: teal "><i class="student icon"></i><b>${student.deptName}</b></td>
	        <td style = "color: grey"><b>${student.spwd}</b></td>
	        <td style = "color: orange"><b>${student.sex}</b></td>
	        <td style = "color: pink"><b>${student.born}</b></td>
          	<td>
            	<button class="ui green button" style="width:110px">
              		<a style="color: white" href = "studentModifyServlet?id=${student.sid}">
              			<i class="edit icon"></i>修改
              		</a>
            	</button>
          	</td>
          	<td>
            	<button class="ui red button" style="width:110px">
              		<a style="color: white" href = "studentDeleteServlet?id=${student.sid}">
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