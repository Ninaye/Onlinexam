<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.hp.onlinexam.po.Question"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
<style>
p {
	text-indent: 2em;
}
</style>
</head>

<body>
	<div id="main_content">
		<form id="form1" name="form1" method="post"
			action="<%=path%>/testCreateServlet" style = "padding-top:50px">
			<h1>
				<center>
					试卷名称：${test.name}<br />
				</center>
			</h1>
			<h3>
				<center>
					考试科目：${c.cname}
					考试班级：${classNames}<br /> 
					考试截止时间：${test.endDate}<br />
					考试时长：${test.testTime}min<br />
					考试分值：${test.scores}分
				</center>
			</h3>
			<p>
				<b>单项选择题</b>
			</p>
			<c:forEach var="que" items="${quesList}" varStatus="status">

				<p></p>
				<p class="text">${status.index + 1} .${que.queTitle}</p>
				<p></p>

				<p>A.${que.choiceA }</p>
				<p>B.${que.choiceB }</p>
				<p>C.${que.choiceC }</p>
				<p>D.${que.choiceD }</p>
				<p>
					<font color="blue"> 正确答案：${que.ans }</font>
				</p>
			</c:forEach>
			<p class="text"></p>
			<p>&nbsp;</p>
			<label>
				<center>
					<input type="submit" name="button" id="button" class="btn_grey"
						value="发布试卷" />
				</center>
			</label>
		</form>
	</div>
</body>${hint }
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
	<div class = "ui main text container" style = "padding-top: 20px">
		<form id="form1" name="form1" method="post" action="<%=path%>/testCreateServlet">
		    <h2 class="ui center aligned header" style="color: white;height:10px">试卷名称：${test.name}</h2>
		    <h4 class="ui center aligned header" style="color: white;height:10px">考试科目：${c.cname}&nbsp&nbsp&nbsp&nbsp&nbsp考试班级：${classNames}</h4>
		    <h4 class="ui center aligned header" style="color: white;height:10px">考试截止时间：${test.endDate}</h4>
		    <h4 class="ui center aligned header" style="color: white;height:10px">考试时长：${test.testTime}min</h4>
		    <h4 class="ui center aligned header" style="color: white;height:10px">考试分值：${test.scores}分</h4>
		    <div style = "width :700px;height :500px">
		    	<table class="ui unstackable table" style = "width :650px;margin-right:25px;margin-left:25px;margin-top:5px">
					<thead>
						<tr><th>单选题</th></tr>
					 </thead>
					 <tbody>
					 	<c:forEach var="que" items="${quesList}" varStatus="status">
					    <tr>
					      	<td>
								<p></p>
								<p class="text">
									<font color="teal "><b>${status.index + 1} .${que.queTitle}</b></font>
								</p>
								<p></p>
								<p>
									<font color="olive">
										<b>
											A&nbsp.&nbsp${que.choiceA }&nbsp&nbsp&nbsp&nbsp&nbsp&nbspB&nbsp.&nbsp${que.choiceB }&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
											C&nbsp.&nbsp${que.choiceC }&nbsp&nbsp&nbsp&nbsp&nbsp&nbspD&nbsp.&nbsp${que.choiceD }
										</b>
									</font>
								</p>
								<p><font color="green"><b>正确答案：${que.ans }</b></font></p>
							</td>
					 	</tr>
					 	</c:forEach>
					 </tbody>
				</table>
				<div class = "ui fluid">
					<div style = "width:150px;margin:0 auto">
						<button class="ui inverted teal button" style = "width:120px;margin-right:25px">发布试卷</button>
					</div>
				</div>
		   	</form>
	    </div>
  	</div>
</body>
</html>