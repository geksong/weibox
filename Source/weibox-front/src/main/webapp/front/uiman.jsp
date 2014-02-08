<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/el-incl.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>微盒子</title>
	<%@ include file="/res-incl.jsp" %>
</head>
<body>
	<%@ include file="/nav-incl.jsp" %>
	<div class="container">
		<%@ include file="/left-incl.jsp" %>
		<div class="span8 radius-div">
			<div class="page-header">
				<h5>请如实填写你的个人信息</h5>
			</div>
			<div>
				<form class="form form-horizontal">
					<div class="control-group">
						<label class="control-label">手机号</label>
						<div class="controls">
							<input type="text" id="userPhone" value="${user.userPhone}"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">qq</label>
						<div class="controls">
							<input type="text" id="userqq" value="${user.userQQ}"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">常用邮箱</label>
						<div class="controls">
							<input type="text" id="userEmail" value="${user.userEmail}"/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/foot-incl.jsp" %>
</body>
</html>