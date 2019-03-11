<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
 	<c:import url="/WEB-INF/template/link.jsp"></c:import>
    <link rel="stylesheet" href="/css/detail.css">
</head>
<body>
<c:import url="/WEB-INF/template/header.jsp"></c:import>
    <div id="contentWrap">
    	<div id="numBox">
    		<span>${article.getNo() }</span>
    	</div><!--//numBoxe end  -->
        <div id="titleBox">
            <span>${article.getTitle() }</span>
            <span>${article.getRegdate() }</span>
        </div><!--//titleBox end  -->
        <div class="wrap_btn">
            <form action="/delete/${article.getNo() }" method="POST">
                <input type="hidden" name="_method" value="DELETE"/>
                <button>삭제</button>
            </form>
            <a href="/update/${article.getNo() }"><button>수정하기</button></a>
        </div><!--// wrap_btn end  -->
        <div id="txtBox">
            ${article.getText() }
        </div><!--// txtBox end  -->

        <div class="wrap_btn">
            <a href="/"><button id="backBtn" type="button">홈으로</button></a>
        </div><!--//wrap_btn end  -->

    </div><!--//contentWrap end-->
<c:import url="/WEB-INF/template/footer.jsp"></c:import>
</body>
</html>