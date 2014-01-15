<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>微盒子管理后台</title>
	<link rel="stylesheet" type="text/css" href="/common/css/bootstrap.min.css"></link>
	<link rel="stylesheet" type="text/css" href="/common/css/bootstrap-responsive.min.css"></link>
	<link rel="stylesheet" type="text/css" href="/back/default.css"></link>
	<script type="text/javascript" src="/common/js/jquery-1.9.1.js"></script>
</head>
<body>
	<div class="container">
		<form class="form form-horizontal">
			<div class="control-group">
				<label class="control-label">用户名</label>
				<div class="controls">
					<input type="text" id="username" placeholder="请输入你的用户名"></input>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">密码</label>
				<div class="controls">
					<input type="password" id="password" placeholder="请输入你的密码"></input>
				</div>
			</div>
			<div class="control-group">
				<div class="alert-error hide" id="json-error"></div>
			</div>
			<input type="hidden" name="jumpUrl" value="/back/flowsolution/list.do"></input>
			<div class="control-group">
			<div class="controls">
				<input type="button" value="登录" id="login-btn" class="btn btn-primary"></input>
			</div>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		$("#login-btn").click(function(){
			var loginurl = "/backuser/login.do";
			var username = $("#username").val();
			var password = $("#password").val();
			var jumpurl = $("#jumpUrl").val();
			var $jsonerror = $("#json-error");
			$jsonerror.addClass("hide");
			if(null == username || "" == username) {
				$jsonerror.html("用户名为空");
				$jsonerror.removeClass("hide");
				return false;
			}
			if(null == password || "" == password) {
				$jsonerror.html("密码为空");
				$jsonerror.removeClass("hide");
				return false;
			}
			$.ajax({
				type:"post",
				url:loginurl,
				data:{"userName":username,"password":password,"jumpUrl":jumpurl},
				success:function(mesg) {
					if(mesg.code) {
						location.href = mesg.jumpUrl;
					}else {
						$jsonerror.html(mesg.msg);
						$jsonerror.removeClass("hide");
					}
				}
			});
		});
	</script>
</body>
</html>