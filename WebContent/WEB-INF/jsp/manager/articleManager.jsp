<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
	th{
		background: lavender;
		font-family: 微软雅黑;
		font-size: 14px;
	}
	td{
		text-align: center;
		font-family: 微软雅黑;
		font-size: 14px;
	}
</style>
<h1>新闻文章管理</h1>
<hr>
<table  border="1" style="width: 100%;border-collapse: collapse;margin-top: 10px" >
	<tr>
		<th>编号</th>
		<th>文章标题</th>
		<th>所属栏目</th>
		<th>作者</th>
		<th>发布时间</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${articleList }" var="a">
	<tr>
		<td><input type="checkbox" value="${a.id }"/></td>
		<td>${a.title }</td>
		<td>${a.c_id }</td>
		<td>${a.author }</td>
		<td>${a.publisurDate }</td>
		<td>
			<a href="javascript:void(0);" val="${a.id }" class="del">删除</a>
		    <a href="javascript:void(0);" val="${a.id }" class="upd">修改</a>
		</td>
	</tr>
	</c:forEach>
</table>
<script>
$(function(){
	$(".upd").off();
	$(".upd").on("click",function(){
		var id = $(this).attr("val");
		$(".right").load("toUpdArticle.action",{id:id});
	});
	
	$(".del").off();
	$(".del").on("click",function(){
		var flag = confirm("确定删除吗？");
		if(flag){
			var id = $(this).attr("val");
			$.post("delArticle.action",{id:id},function(){
				$(".baseUI li :contains('新闻栏目管理')").trigger("click");
			});
		}
	});	
});	
</script>
