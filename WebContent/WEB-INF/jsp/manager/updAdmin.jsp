<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#updAdminForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			alert("修改成功！");
			$(".baseUI li :contains('人员管理')").trigger("click");
		});	
		return false;
	});
});

</script>
<h1>管理人员修改页面</h1>
<hr>
<form action="updAdmin.action" method="post" id="updAdminForm">
	<input type="hidden" name="id" value="${admin.id }"/>
	姓名:<input type="text" name="name" value="${admin.name }"/><br/>
	密码:<input type="text" name="password" value="${admin.password }"/><br/>
	<input type="submit" value="修改"/>
</form>