<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/back/includ/el-incl.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>微盒子管理后台</title>
	<%@include file="/WEB-INF/back/includ/res-incl.jsp" %>
</head>
<body>
	<!-- 导航条开始 -->
	<%@include file="/WEB-INF/back/includ/nav-incl.jsp" %>
	
	<!-- 正文内容开始 -->
	<div class="container">
		<!-- 左侧导航 -->
		<%@include file="/WEB-INF/back/includ/left-incl.jsp" %>
		<div class="span8 radius-div">
			<div class="page-header">
				<h5>服务帐号类型管理</h5>
			</div>
			<div>
				<a href="###" class="btn btn-primary">添加帐号类型</a>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<tr>
						<th>名称</th>
						<th>操作</th>
					</tr>
					<tr>
						<td>IT</td>
						<td><a href="###"><i class="icon-pencil"></i></a>
							&nbsp;&nbsp;
							<a href="###"><i class="icon-remove"></i></a></td>
					</tr>
				</table>
				<!-- 分页 -->
				<%@include file="/WEB-INF/back/includ/page-incl.jsp" %>
			</div>
		</div>
	</div>
	
	<!-- 页脚开始 -->
	<%@include file="/WEB-INF/back/includ/foot-incl.jsp" %>
</body>
</html>