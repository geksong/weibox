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
	<script type="text/javascript">
		var active_menu = "weibox-wechattype";
	</script>
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
				<h5>服务帐号类型管理---添加服务帐号类型</h5>
			</div>
			<div>
				<form class="form-horizontal" action="/back/wechattype/add.do" method="post">
					<div class="control-group">
						<label class="control-label">服务帐号类型名称</label>
						<div class="controls">
							<input type="text" id="wechattypename" name="wechattypename" placeholder="服务帐号类型名称"></input>
						</div>
					</div>
					<div class="control-group">
						<div class="alert alert-error hide" id="alerterror">错误</div>
					</div>
					<div class="control-group">
						<label class="controls">
							<input id="btn-sure" type="button" class="btn btn-primary" value="确定"></input>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/back/wechattype/list.do&page=1" class="btn">返回</a>
						</label>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- 页脚开始 -->
	<%@include file="/WEB-INF/back/includ/foot-incl.jsp" %>
	
	<script type="text/javascript">
		$(function() {
			$("#btn-sure").click(function() {
				var url = "/back/wechattype/add.do";
				var wechattypename = $("#wechattypename").val();
				if(null == wechattypename || "" == wechattypename) {
					$("#alerterror").html("请输入服务帐号类型名称");
					$("#alerterror").removeClass("hide");
					return false;
				}
				var data = {"wechatTypeName":wechattypename};
				$.ajax({
					type:"post",
					data:data,
					url:url,
					success:function(mesg) {
						if(mesg.code) {
							location.href="/back/wechattype/list.do?page=1";
						}else {
							$("#alerterror").html(mesg.msg);
							$("#alerterror").removeClass("hide");
						}
					}
				});
			});
		});
	</script>
</body>
</html>