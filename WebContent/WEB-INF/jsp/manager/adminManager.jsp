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
<h1>信息系统管理员管理</h1>
<hr>
<table  border="1" style="width: 100%;border-collapse: collapse;margin-top: 10px" >
	<tr>
		<th>编号</th>
		<th>姓名</th>
		<th>密码</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${adminList }" var="ad">
	<tr>
		<td><input type="checkbox" value="${ad.id }"/></td>
		<td>${ad.name }</td>
		<td>${ad.password }</td>
		<td>
			<a href="javascript:void(0);" val="${ad.id }" class="del">删除</a>
		    <a href="javascript:void(0);" val="${ad.id }" class="upd">修改</a>
		</td>
	</tr>
	</c:forEach>
</table>
<script>
$(function(){
	$(".upd").off();
	$(".upd").on("click",function(){
		var id = $(this).attr("val");
		$(".right").load("toUpdAdmin.action",{id:id});
	});
	
	$(".del").off();
	$(".del").on("click",function(){
		var flag = confirm("确定删除吗？");
		if(flag){
			var id = $(this).attr("val");
			$.post("delAdmin.action",{id:id},function(){
				$(".baseUI li :contains('管理人员')").trigger("click");
			});
		}
	});	
});	
</script>
