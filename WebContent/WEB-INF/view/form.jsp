<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>
	 <c:choose>
	 	<c:when test="${article!=null }">
	 글 수정
	 	</c:when>
	 	<c:otherwise>
	  글 작성
	 	</c:otherwise>
	 </c:choose>
    </title>
    	<c:import url="/WEB-INF/template/link.jsp"></c:import>
    <link rel="stylesheet" href="/css/form.css">
</head>
<body>
<c:import url="/WEB-INF/template/header.jsp"></c:import>
    <div id="contentWrap">
        <form action="/write" method="POST">
        <c:if test="${article!=null }">
        <input type="hidden" name="_method" value="PUT" />
        <input type="hidden" name="referer" value="${referer}" />
        <input type="hidden" name="no" value="${article.getNo() }" />
        </c:if>
            <div id="titleWrap">
                <div id="inputBox">
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title"
                    <c:if test="${article!=null }">
                    value="${article.getTitle() }"
                    </c:if>
                    />
                </div><!--//inputBox end-->
            </div> <!--//titleWrap end-->

            <div id="contentBox">
                <div id="textareaBox">
                    <label for="txt">내용</label>
                    <textarea id="txt" name="text"><c:if test="${article!=null }">${article.getText() }</c:if></textarea>
                </div><!--//textareaBox end-->
            </div><!--//contentBox end-->
            <div id="btnWrap">
                <a href="/"><button type="button">취소</button></a>
                <button type="submit">
        <c:choose>
	 	<c:when test="${article!=null }">
		수정
	 	</c:when>
	 	<c:otherwise>
	 	 등록
	 	</c:otherwise>
	 	</c:choose>
                </button>
            </div><!-- //btnWrap end  -->
        </form>
    </div><!--//contentWrap end-->
<c:import url="/WEB-INF/template/footer.jsp"></c:import>
<script src="/js/form.js"></script>
</body>
</html>