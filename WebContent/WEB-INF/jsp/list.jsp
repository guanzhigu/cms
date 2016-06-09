<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订阅的栏目</title>
<link rel="stylesheet" type="text/css" href="theme/1/css/common.css">
<link rel="stylesheet" type="text/css" href="theme/1/css/front/style.css">
</head>

<body>
<div id="main">
   <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
    	<div class="congw">
           <div class="conlist">
                <div class="search_result">
				      <c:forEach items="${articleList }" var="a">              	
                        <div class="art_box">
                        	<div class="art_img">
                        	<a href="toContent.action?id=${a.id }"><img src="theme/1/images/front/doc.png"></a></div>
                            <div class="art_txt">
                            	<div class="title">${a.title }<span class="icon_pen"></span></div>
                                <div class="tag_txt">
                                	<span>撰稿人：${a.author }</span>
                                	<span class="pl30">上传时间：${a.publisurDate }</span>
                                	
                                </div>
                            </div>
                        </div>
                      </c:forEach>
                        
                        <div class="page">分页>></div>
                    </div>
                    
           </div>
            <div class="link">
            	<div class="linelink">
            		<span>网内链接：</span><a href="javascript:void(0)">易网新闻数码网</a><a href="javascript:void(0)">易网新闻娱乐网</a><a href="javascript:void(0)">易网新闻论坛</a><a href="javascript:void(0)">易网新闻网</a><a href="javascript:void(0)">易网新闻数码网</a><a href="javascript:void(0)">易网新闻网</a>
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
