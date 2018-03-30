<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui inverted segment">
	<div class="ui inverted secondary pointing menu active">
		<a class="item active">
			<i class="world icon"></i>学生在线考试系统
		</a>
		<%-- <a class="item" href="<%=request.getContextPath()%>/manager/index.jsp">
			<i class="bookmark icon"></i>欢迎页面
		</a> --%>
		<a class="item" href="<%=request.getContextPath()%>/stuClassQueryServlet">
			<i class="users icon"></i>班级管理
		</a>
		<a class="item" href="<%=request.getContextPath()%>/teacherQueryServlet">
			<i class="male icon"></i>教师管理
		</a>
		<a class="item" href="<%=request.getContextPath()%>/courseQueryServlet">
			<i class="book icon"></i>课程管理
		</a>
		<a class="item" href="<%=request.getContextPath()%>/scheduleQueryServlet">
			<i class="list layout icon"></i>班级排课管理
		</a>
		<a class="item" href="<%=request.getContextPath()%>/studentQueryServlet">
			<i class="student icon"></i>学生管理
		</a>
		<div class = "right menu">
			<div class="ui right animated button black">
			  	<div class="visible content">
			  		<i class="icon user"></i>Log out
			  	</div>
			  	<div class="hidden content">
			  		<a style = "color:white" href="<%=request.getContextPath()%>/logoutServlet">
			  			<i class="sign out icon"></i>
			  		</a>
			  	</div>
			</div>
		</div>
	</div>
</div></br></br></br>