<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="pagination" style="text-align: right;">
					<span>${page}/${pageList.totalPages}页</span>
					<ul>
						<li><a href="list.do?page=1">&lt;&lt;</a></li>
						<c:if test="${page > 1}">
						<li><a href="list.do?page=${page-1}">&lt;</a></li>
						</c:if>
						<c:if test="${page < pageList.totalPages}">
						<li><a href="list.do?page=${page+1}">&gt;</a></li>
						</c:if>
						<li><a href="list.do?page=${pageList.totalPages == 0 ? 1 : pageList.totalPages}">&gt;&gt;</a></li>
					</ul>
				</div>