<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- jquery  jquery.form 异步提交 -->
<script>
$(function(){
	var form = $("#updArticleForm");
	form.off();
	form.on("submit",function(){
		form.ajaxSubmit(function(){
			alert("修改成功！");
			//模拟点击栏目管理
			$(".baseUI li :contains('新闻管理')").trigger("click");
		});	
		return false;
	});
});

</script>
<h1>新闻修改页面</h1>
<hr>
<form action="updArticle.action" method="post" id="updArticleForm">
	<input type="hidden" name="id" value="${article.id }"/>
	新闻标题:<input type="text" name="title" value="${article.title }"/><br/>
	新闻撰稿人:<input type="text" name="author" value="${article.author }"/><br/>
	所属栏目:	<select name="c_id">
				<option value="">-----请选择-----</option>
				<c:forEach items="${categoryList }" var="c">
					<option value="${c.id }">${c.name }</option>
				</c:forEach>
			</select><br/>
	新闻内容:
		<textarea name="content" rows="10" cols="30" >${article.content}</textarea>
		<br/>
	<input type="submit" value="上传"/>
</form>