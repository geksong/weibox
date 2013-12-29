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
		var active_menu = "weibox-flowsolution";
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
				<h5>流量套餐管理---更新流量套餐</h5>
			</div>
			<div>
				<form class="form-horizontal" action="/back/flowsolution/update.do" method="post">
					<input type="hidden" id="flowsolutionid" value="${flowSolution.id}"></input>
					<div class="control-group">
						<label class="control-label">套餐价格</label>
						<div class="controls">
							<input type="text" id="solutionprice" value="${flowSolution.solutionPrice }" name="wechattypename" placeholder="套餐价格"></input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">套餐折扣</label>
						<div class="controls">
							<input type="text" id="solutiondiscount" value="${flowSolution.solutionDiscount }" placeholder="套餐折扣"></input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">文本信息条数</label>
						<div class="controls">
							<input type="text" id="textMsgNum" value="${flowSolution.textMsgNum }" placeholder="文本信息条数"></input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">图文信息条数</label>
						<div class="controls">
							<input type="text" id="imgtxtMsgNum" value="${flowSolution.imgtxtMsgNum }" placeholder="图文信息条数"></input>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">语音信息条数</label>
						<div class="controls">
							<input type="text" id="vadioMsgNum" value="${flowSolution.vadioMsgNum }" placeholder="语音信息条数"></input>
						</div>
					</div>
					<div class="control-group">
						<div class="alert alert-error hide" id="alerterror">错误</div>
					</div>
					<div class="control-group">
						<label class="controls">
							<input id="btn-sure" type="button" class="btn btn-primary" value="确定"></input>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="/back/flowsolution/list.do&page=1" class="btn">返回</a>
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
				var url = "/back/flowsolution/update.do";
				var flowsolutionid = $("#flowsolutionid").val();
				var solutionprice = $("#solutionprice").val();
				var solutiondiscount = $("#solutiondiscount").val();
				var textMsgNum = $("#textMsgNum").val();
				var imgtxtMsgNum = $("#imgtxtMsgNum").val();
				var vadioMsgNum = $("#vadioMsgNum").val();
				if(null == solutionprice || "" == solutionprice
						|| null == solutiondiscount || "" == solutiondiscount
						|| null == textMsgNum || "" == textMsgNum
						|| null == imgtxtMsgNum || "" == imgtxtMsgNum
						|| null == vadioMsgNum || "" == vadioMsgNum) {
					$("#alerterror").html("请填写完整套餐信息");
					$("#alerterror").removeClass("hide");
					return false;
				}
				
				var data = {"id":flowsolutionid,"textMsgNum":textMsgNum,"imgtxtMsgNum":imgtxtMsgNum,"vadioMsgNum":vadioMsgNum,"solutionPrice":solutionprice,"solutionDiscount":solutiondiscount};
				$.ajax({
					type:"post",
					data:data,
					url:url,
					success:function(mesg) {
						if(mesg.code) {
							location.href="/back/flowsolution/list.do?page=1";
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