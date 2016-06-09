<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#addAdminForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			form[0].reset();
			alert("添加成功！");
		});
		return false;
	});
});
</script>
<h1>信息系统管理员添加页面</h1>
<hr>
<form action="addAdmin.action" method="post" id="addAdminForm">
	姓名:<input type="text" name="name"/><br/>
	密码:<input type="text" name="password"/><br/>
	<input type="submit" value="上传"/><br/>
</form>