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
				<h5>服务帐号类型管理</h5>
			</div>
			<div>
				<a href="/back/wechattype/toadd.do" class="btn btn-primary">添加帐号类型</a>
			</div>
			<div>
				<table class="table table-bordered table-hover">
					<tr>
						<th>名称</th>
						<th>操作</th>
					</tr>
					<c:forEach var="li" items="${pageList.content}">
					<tr>
						<td>${li.wechatTypeName}</td>
						<td><a href="/back/wechattype/toupdate.do?id=${li.id}"><i class="icon-pencil"></i></a>
							&nbsp;&nbsp;
							<a href="javascript:void(0);" data="${li.id}" class="remove-btn"><i class="icon-remove"></i></a></td>
					</tr>
					</c:forEach>
				</table>
				<!-- 分页 -->
				<%@include file="/WEB-INF/back/includ/page-incl.jsp" %>
			</div>
		</div>
	</div>
	
	<!-- 页脚开始 -->
	<%@include file="/WEB-INF/back/includ/foot-incl.jsp" %>
	
	<!-- Modal -->
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="myModalLabel">删除服务帐号类型</h3>
	</div>
	<div class="modal-body">
	<p>确定删除此服务帐号类型~?</p>
	<input type="hidden" id="delid"></input>
	</div>
	<div class="modal-footer">
	<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	<button class="btn btn-primary" id="remove-model-sure">确定</button>
	</div>
	</div>
	<script type="text/javascript">
			$(".remove-btn").click(function() {
				$("#delid").val($(this).attr("data"));
				$("#myModal").modal('show');
			});
			$("#remove-model-sure").click(function() {
				var url = "/back/wechattype/del.do";
				var data = {"id":$("#delid").val()};
				$.ajax({
					type:"post",
					url:url,
					data:data,
					success:function(mesg) {
						if(mesg.code) {
							location.href = "/back/wechattype/list.do?page=${page}";
						}
					}
				});
			});
	</script>
</body>
</html>