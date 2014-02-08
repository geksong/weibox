<%@page import="com.walker.weibox.model.LoginUser"%>
<%@page import="com.walker.weibox.common.utils.CookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginUser loginUser = CookieUtil.instance().getFrontUser(request);
%>
    <div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="###">微盒子</a>
				<ul class="nav">
					<li><a href="###">首页</a></li>
				</ul>
				<a type="button" id="logout_btn" class="btn btn-primary pull-right">退出</a>
				<a type="button" class="btn pull-right"><%=loginUser.getUserName() %></a>				
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	$("#logout_btn").click(function() {
		location.href="/backuser/logout.do";
	});
	</script>