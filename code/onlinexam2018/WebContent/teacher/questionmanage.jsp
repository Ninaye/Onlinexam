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
	    <h1 class="ui center aligned header" style="color: white;padding-bottom:10px">学生管理系统</h1>
	    <form id="form1" method="get" action="<%=path%>/questionQueryServlet" style = "padding-bottom:10px">
			<h3 class="subTitle">
				<div class="search">
					<select name="selectk" id="selectk" style = "height: 34px">
						<option selected="selected" value="cname">课程科目</option>
						<option value="queTitle">试题题目</option>
					</select> 
					<input type="text" name="searchName" id="searchName" value='' style = "height: 34px"/>
					<input type="submit" name="Submit" class="btn_grey" value="搜索" style = "height: 34px"/>
					<button class="ui orange right floated button" style="width: 150px">
			        	<a style="color: white"  href="<%=path%>/questionAddServlet"><i class="add user icon"></i>新加试题信息</a>
			      	</button>
				</div>
			</h3>
		</form>
	    <table class="ui inverted center aligned table">
	      <thead>
	        <tr>
	          <th style="width:60px">题号</th>
	          <th style="width:100px">考试科目</th>
	          <th style="width:100px">题型</th>
	          <th style="width:140px">题干</th>
	          <th style="width:140px">选项</th>
	          <th style="width:60px">答案</th>
	          <th style="width:110px">修改操作</th>
          	  <th style="width:110px">删除操作</th>
	        </tr>
	      </thead>
	      <tbody>
	        <c:forEach var="que" items="${queList}">
		        <tr>
		         	<td style = "color: red "><h3>${que.qid}</h3></td>
					<td>${que.cname}</td>
					<td>单选题</td>
					<td>${que.queTitle}</td>
					<td>
						<p>A. ${que.choiceA}&nbsp;&nbsp;&nbsp;&nbsp;B.${que.choiceB}</p>
						<p>C. ${que.choiceC}&nbsp;&nbsp;&nbsp;&nbsp;D.${que.choiceD}</p>
					</td>
					<td align="center" style = "color : green"><h3>${que.ans}</h3></td>
					<td>
		            	<button class="ui green button" style="width:110px">
		              		<a style="color: white" href = "questionModifyServlet?id=${que.qid}">
		              			<i class="edit icon"></i>修改
		              		</a>
		            	</button>
		          	</td>
		          	<td>
		            	<button class="ui red button" style="width:110px">
		              		<a style="color: white" href = "questionDeleteServlet?id=${que.qid}">
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