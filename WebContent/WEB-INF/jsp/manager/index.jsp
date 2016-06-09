<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易网新闻信息管理系统-后台</title>
<link rel="stylesheet" type="text/css" href="../theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/style.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/table.css">
<link rel="stylesheet" type="text/css" href="../theme/1/css/icon.css">
<link rel="stylesheet" type="text/css"
	href="../theme/1/jquery-easyui-themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../theme/1/css/easyui-tabs.css">
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../theme/1/js/base.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$(".baseUI li").on("click",function(){
		var url = $(this).attr("url");
		$(".right").load(url);		
	});
	$(".baseUI li").filter(":first").trigger("click");
	
});
</script>
<body>
	<div class="main">
		<div id="top">
			<div class="top">
				<div class="t_logo"></div>
				<div class="t_sign">
					<span>你好，<font color="red">易网管理员</font></span><a href="../index.jsp" class="t_exit">退出</a>
				</div>
				<div style="position: absolute;top:10px;right: 20px">
					<a href="../toIndex.action" target="_blank"><font color="gold">跳转到易网前台首页</font></a>
				</div>
			</div>
		</div>
		<div id="cont">
			<div class="centent">
				<div class="left">
					<ul class="baseUI">
					<!-- 左侧导航栏 -->
						<li url="toAddCategory.action">
							<a href="#"><em class="base_basicset"></em><span>添加新闻栏目</span></a>
						</li>
						<li url="toCategoryManager.action">
							<a href="#"><em class="base_userset"></em><span>新闻栏目管理</span></a>
						</li>
						<li url="toAddArticle.action">
							<a href="#"><em class="base_roll"></em><span>新闻发布</span></a>
						</li>
						<li url="toArticleManager.action">
							<a href="#"><em class="base_sys"></em><span>新闻文章管理</span></a>
						</li>
						<li url="toAddAdmin.action">
							<a href="#"><em class="base_userset"></em><span>系统管理员添加</span></a>
						</li>
						<li url="toAdminManager.action">
							<a href="#"><em class="base_userset"></em><span>系统管理员管理</span></a>
						</li>
	               </ul>
				</div>
				<!-- 内容页面 -->
				<div class="right"  style="bgcolor:lavender padding:30px">
						
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div id="foot">
			<a href="#">易网新闻有限公司</a>
		</div>
	</div>
</body>
</html>
