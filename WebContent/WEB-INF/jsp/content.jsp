<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻文章内容</title>
<link rel="stylesheet" type="text/css" href="theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="theme/1/css/front/style.css">
</head>

<body>
<div id="main">
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
    	<div class="congw">
           <div class="conarticle">
                    <div class="position">
                    	<span class="poshome">您现在的位置：</span>
                        <a href="#">首页</a> >> <a href="#">最新新闻公告栏</a>
                    </div>
                    <div class="title">${article.title }</div>
                    <div class="abstract">
                    	<span>更新时间：${article.publisurDate }</span>
                        <span>撰稿人：${article.author }</span>
                    </div>
                    <div class="details">
                    	<p>${article.content }</p>
                    </div>
           </div>
            <div class="link">
            	<div class="linelink">
            		<span>网内链接：</span><a href="javascript:void(0)">易网新闻技术网</a><a href="javascript:void(0)">易网新闻教育网</a><a href="javascript:void(0)">易网新闻论坛</a><a href="javascript:void(0)">易网新闻数码</a><a href="javascript:void(0)">易网新闻财经</a><a href="javascript:void(0)">易网新闻生活</a>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
    	<div class="foot">
        	<p>易网新闻发布系统 技术支持：<a href="javascript:void(0)">易网新闻有限公司</a>      电话：0451-xxxxxxx</p>
        </div>
    </div>
</div>
</body>
</html>
