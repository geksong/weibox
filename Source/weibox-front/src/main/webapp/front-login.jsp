<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>微盒子</title>
<link rel="stylesheet" type="text/css"
	href="/common/css/bootstrap.min.css"></link>
<link rel="stylesheet" type="text/css"
	href="/common/css/bootstrap-responsive.min.css"></link>
<link rel="stylesheet" type="text/css" href="/front/default.css"></link>
<script type="text/javascript" src="/common/js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="/common/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
		<div class="navbar-inner">
			<div class="container">
				<a class="brand" href="###">微盒子</a>
				<ul class="nav">
					<li><a href="###">首页</a></li>
					<li><a href="###">经典案例</a></li>
					<li><a href="###">合作业务</a></li>
					<li><a href="###">成长历程</a></li>
					<li><a href="###">关于我们</a></li>
				</ul>				
			</div>
		</div>
	</div>
	<div class="container" style="width: 600px;">
		<div class="tabbable">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#login-tab" data-toggle="tab">登
						录</a></li>
				<li><a href="#reg-tab" data-toggle="tab">注 册</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="login-tab">
					<form class="form form-horizontal">
						<div class="control-group">
							<label class="control-label">用户名</label>
							<div class="controls">
								<input type="text" id="username" placeholder="用户名"></input>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">密码</label>
							<div class="controls">
								<input type="password" id="password" placeholder="密码"></input>
							</div>
						</div>
						<div class="control-group">
							<div class="alert-error hide" id="json-error"></div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="button" class="btn btn-primary btn-large" value="登 录"></input>
							</div>
						</div>
					</form>
				</div>
				<div class="tab-pane" id="reg-tab">
					<form class="form form-horizontal">
						<div class="control-group">
							<label class="control-label">用户名</label>
							<div class="controls">
								<input type="text" id="reg-username" placeholder="用户名"/>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">密码</label>
							<div class="controls">
								<input type="password" id="reg-password" placeholder="登录密码"></input>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">确认密码</label>
							<div class="controls">
								<input type="password" id="reg-cfmpassword" placeholder="确认登录密码"></input>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<input type="button" class="btn btn-primary btn-large" value="注  册"></input>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/foot-incl.jsp" %>
</body>
</html>