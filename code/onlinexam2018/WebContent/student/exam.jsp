<%-- <%@page import="com.hp.onlinexam.po.Question"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title></title>
<link href="<%=path %>/css/style.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
	document.onkeydown = function() {
		if (event.keyCode == 116) {
			event.keyCode = 0;
			event.returnValue = false;
		}
	};
	document.oncontextmenu = function() {
		event.returnValue = false;
	};
</script>
<style>
#fd {
	position: fixed;
	*position: absolute;
	width: 150px;
	height: 50px;
	top: 50%;
	left: 90%;
	margin: -50px 0 0 -50px;
}

p {
	text-indent: 10em;
}
</style>
</head>

<body onselectstart="return false">
	<script language="JavaScript">
		alert("考试期间禁止刷新页面，如若出错后果自负！");
	</script>
	<div style = "width:10px;height:80px"></div>
	<div id="main_content">
		<div>
			<form id="form1" name="form1" method="post" action="<%=path %>/studentTest?&testId=${test.id}">
				<div id="fd">
					<span style="color: #ff0000">考试剩余时间</span><br /> <input size="12"
						value="${test.testTime}" name="input1" id="input1" readonly="readonly"
						style="text-align: center;" /><br />
					<script language="javascript">
						var sec = 60;
						var min = ("${test.testTime}"-1)%60;
						var hou = "${test.testTime}"/60;
						flag = 0;
						idt = window.setTimeout("update();", 1000);
						function update() {
							if (min == 10 && sec == 0) {
								alert("还剩10分钟，请抓紧时间答卷！");
							} 
							if (min == 0 && sec == 0) {
								form1.submit();
							}
							if (sec == 0 && min > 0) {
								sec = 60;
								min -= 1;
							}
							sec--;
							document.form1.input1.value = min + "分" + sec + "秒";
							idt = window.setTimeout("update();", 1000);
						}
					</script>
				</div>
				<h1>
					<center>${test.name}</center>
				</h1>
				<div id="time"></div>
				<center>
					<p>${test.cname} &nbsp;&nbsp;&nbsp; ${test.scname}&nbsp;&nbsp;&nbsp;${user.sname }</p>
				</center>
				<p>
					<b>一、单项选择题（${test.scores}分）（每小题${scoreperques}分，错选、未选均不得分。）</b>
				</p>
				<c:forEach var="que" items="${quesList}" varStatus="status">
					<p></p>
					<p>${status.index + 1}.${que.queTitle}</p>
					<p>A.${que.choiceA }</p>
					<p>B.${que.choiceB }</p>
					<p>C.${que.choiceC }</p>
					<p>D.${que.choiceD }</p>
					<p>
						A.<input type="radio" name = "ques_${que.qid}" value = "A"/>
						B.<input type="radio" name = "ques_${que.qid}" value = "B"/>
						C.<input type="radio" name = "ques_${que.qid}" value = "C"/>
						D.<input type="radio" name = "ques_${que.qid}" value = "D"/>
					</p>
				</c:forEach>
				<p>&nbsp;</p>
				<p class="text"></p>
				<p>&nbsp;</p>
				<label>
					<center>
						<input type="submit" name="button" id="button" value="交卷"
							onclick="javascript: return confirm('确认要交卷吗？');" />
					</center>
				</label> <input type="hidden" size="8" value="0时0分0秒" name="hidden1" />
				<script>
					var sec1 = 0;
					var min1 = 0;
					var hou1 = 0;
					flag1 = 0;
					idt1 = window.setTimeout("update22();", 1000);
					function update22() {
						sec1++;
						if (sec1 == 60) {
							sec1 = 0;
							min1 += 1;
						}
						if (min1 == 60) {
							min1 = 0;
							hou1 += 1;
						}
						if ((min1 > 0) && (flag1 == 0)) {
							flag1 = 1;
						}
						document.form1.hidden1.value = min1 + "分" + sec1 + "秒";
						idt1 = window.setTimeout("update22();", 1000);
					};
				</script>
			</form>
		</div>
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
	<script language="javascript" type="text/javascript">
	document.onkeydown = function() {
		if (event.keyCode == 116) {
			event.keyCode = 0;
			event.returnValue = false;
		}
	};
	document.oncontextmenu = function() {
		event.returnValue = false;
	};
</script>
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
	<script language="JavaScript">
		alert("考试期间禁止刷新页面，如若出错后果自负！");
	</script>
	<div class = "ui main text container" style = "padding-top: 20px">
		<form id="form1" name="form1" method="post" action="<%=path %>/studentTest?&testId=${test.id}">
		    <h2 class="ui center aligned header" style="color: white;height:10px">试卷名称：${test.name}</h2>
		    <div id="time"></div>
		    <h4 class="ui center aligned header" style="color: white;height:10px;padding-top:10px">${test.cname} &nbsp;&nbsp;&nbsp; ${test.scname}&nbsp;&nbsp;&nbsp;${user.sname }</h4>
		    <div style = "width:150px;height:50px;padding-top:10px">
		    	<div id="fd" style = "margin-left:25px">
					<span style="color: red"><b>考试剩余时间</b></span>
					<input size="12"value="${test.testTime}" name="input1" id="input1" readonly="readonly"style="text-align: center;" />
					<script language="javascript">
						var sec = 60;
						var min = ("${test.testTime}"-1)%60;
						var hou = "${test.testTime}"/60;
						flag = 0;
						idt = window.setTimeout("update();", 1000);
						function update() {
							if (min == 10 && sec == 0) {
								alert("还剩10分钟，请抓紧时间答卷！");
							} 
							if (min == 0 && sec == 0) {
								form1.submit();
							}
							if (sec == 0 && min > 0) {
								sec = 60;
								min -= 1;
							}
							sec--;
							document.form1.input1.value = min + "分" + sec + "秒";
							idt = window.setTimeout("update();", 1000);
						}
					</script>
				</div>
		    </div>
		    <div style = "width :700px;height :500px;padding-top:20px">
		    	<table class="ui unstackable table" style = "width :650px;margin-right:25px;margin-left:25px;margin-top:5px">
					<thead>
						<tr><th>单项选择题（${test.scores}分）（每小题${scoreperques}分，错选、未选均不得分。）</th></tr>
					 </thead>
					 <tbody>
					 	<c:forEach var="que" items="${quesList}" varStatus="status">
					    <tr>
					      	<td>
								<p class="text">
									<font color="teal "><b>${status.index + 1} .${que.queTitle}</b></font>
								</p>
								<p>
									<font color="olive">
										<b>
											<p>A&nbsp.&nbsp<input type="radio" name = "ques_${que.qid}" value = "A"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${que.choiceA} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp B&nbsp.&nbsp<input type="radio" name = "ques_${que.qid}" value = "B"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${que.choiceB}</p>
											<p>C&nbsp.&nbsp<input type="radio" name = "ques_${que.qid}" value = "C"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${que.choiceC} &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp D&nbsp.&nbsp<input type="radio" name = "ques_${que.qid}" value = "D"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${que.choiceD}</p>
										</b>
									</font>
								</p>
							</td>
					 	</tr>
					 	</c:forEach>
					 </tbody>
				</table>
				<p class="text"></p>
				<div class = "ui fluid">
					<div style = "width:150px;margin:0 auto">
						<button class="ui inverted teal button" style = "width:120px;margin-right:25px" onclick="javascript: return confirm('确认要交卷吗？');">提交试卷</button>
					</div>
				</div>
				<input type="hidden" size="8" value="0时0分0秒" name="hidden1"/>
				<script>
					var sec1 = 0;
					var min1 = 0;
					var hou1 = 0;
					flag1 = 0;
					idt1 = window.setTimeout("update22();", 1000);
					function update22() {
						sec1++;
						if (sec1 == 60) {
							sec1 = 0;
							min1 += 1;
						}
						if (min1 == 60) {
							min1 = 0;
							hou1 += 1;
						}
						if ((min1 > 0) && (flag1 == 0)) {
							flag1 = 1;
						}
						document.form1.hidden1.value = min1 + "分" + sec1 + "秒";
						idt1 = window.setTimeout("update22();", 1000);
					};
				</script>
		   	</form>
	    </div>
  	</div>
</body>
</html>