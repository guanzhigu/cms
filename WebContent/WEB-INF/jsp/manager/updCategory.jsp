<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#updCategoryForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			alert("修改成功！");
			//模拟点击栏目管理
			$(".baseUI li :contains('新闻栏目管理')").trigger("click");
		});	
		return false;
	});
});

</script>
<h1>修改新闻栏目页面</h1>
<hr>
<form action="updCategory.action" method="post" id="updCategoryForm">
	<input type="hidden" name="id" value="${category.id }"/>
	新闻栏目名称:<input type="text" name="name" value="${category.name }"/><br/>
	新闻栏目编号:<input type="text" name="code" value="${category.code }"/><br/>
	<input type="submit" value="修改"/><br/>
</form>