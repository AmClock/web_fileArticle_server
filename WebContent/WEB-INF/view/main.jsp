<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
	<c:import url="/WEB-INF/template/link.jsp"></c:import>
    <link rel="stylesheet" href="/css/main.css">
</head>
<body>
<c:import url="/WEB-INF/template/header.jsp"></c:import>
     <div id="contentWrap">
     		<div id="mainTitle">
     			<h2>Imoxion Board</h2>
     		</div><!--//mainTitle end  -->
     		<c:choose>
     		<c:when test="${list.size() !=0 }">
     		   <c:forEach items="${list }" var="article">
                <a href="/detail/${article.getNo() }">
                    <div class="box_card">
                        <div class="txt_num">${article.getNo() }</div>
                        <div class="box_title">${article.getTitle() }</div>
                        <div class="box_regdate">${article.mainDate() }</div>
                    </div><!--//div end-->
                </a><!--// card end  -->
              </c:forEach>
     		</c:when>
     		<c:otherwise>
     		<div id="notArticle">
     		<p>
     			게시글이 없습니다.
     		</p>
     		</div><!--//notArticle end  -->
     		</c:otherwise>
     		</c:choose>
    </div><!--//contentWrap end-->
    <c:if test="${list.size() > 24}">
    <div id="moreBtnWrap">
            <a href="#moreBtnWrap">
            	<button>
            		<i class="fas fa-angle-down"></i>
            	</button>
            </a>
    </div><!--//moreBtnWrap end-->
    </c:if>
<c:import url="/WEB-INF/template/footer.jsp"></c:import>
<script src="/js/main.js"></script>
</body>
</html>