<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="ui inverted segment">
	<div class="ui inverted secondary pointing menu active">
		<a class="item active">
			<i class="icon user"></i>
			学生在线考试系统
		</a>
		<a class="item" href="<%=request.getContextPath()%>/recentTestServlet">近期考试</a>
		<a class="item" href="<%=request.getContextPath()%>/pastTestServlet">以往考试</a>
		<div class = "right menu">
			<div class="ui right animated button black">
			  	<div class="visible content">
			  		<i class="icon user"></i>
					Log out
			  	</div>
			  	<div class="hidden content">
			  		<a style = "color:white" href="<%=request.getContextPath()%>/logoutServlet"><i class="right arrow icon"></i></a>
			  	</div>
			</div>
		</div>
	</div>
</div>