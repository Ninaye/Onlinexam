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
	    <h2 class="ui center aligned header" style="color: white;height:10px">试卷名称：${test.name}</h2>
	    <h4 class="ui center aligned header" style="color: white;height:10px">考试科目：${test.cname}&nbsp&nbsp&nbsp&nbsp&nbsp考试班级：${classNames}</h4>
	    <h4 class="ui center aligned header" style="color: white;height:10px">考试截止时间：${test.endDate}</h4>
	    <h4 class="ui center aligned header" style="color: white;height:10px">考试时长：${test.testTime}min</h4>
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
			<form method="post" action="<%=path%>/testDetailInfoServlet">
				<div class = "ui fluid">
					<div style = "width:150px;margin:0 auto">
						<button class="ui inverted teal button" style = "width:120px;margin-right:25px">返回</button>
					</div>
				</div>
		   	</form>
	    </div>
  	</div>
</body>
</html>