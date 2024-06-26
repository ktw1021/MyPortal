<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My Homepage</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link href="<c:url value='/css/board.css' />" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value='/javascript/board.js'/>"></script>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>

    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <table border="1" width="580">
                <tr>
                    <td colspan="2"><h3>게시판</h3></td>
                </tr>
                <tr>
                    <th colspan="2">글보기</th>
                </tr>
                <tr>
                    <td>제목</td>
                    <td>${board.title}</td>
                </tr>
                <tr>
                    <td>작성일</td>
                    <td><fmt:formatDate value="${board.createdDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                </tr>
                <tr>
                    <td>조회수</td>
                    <td>${board.viewCount}</td>
                </tr>
                <tr>
                    <td>내용</td>
                    <td>
                        <div>
                            <c:out value="${board.content}" escapeXml="false"/>
                        </div>
                    </td>
                </tr>
            </table>
            <div class="button-container">
                <a href="<c:url value='/board/list'/>" class="btn">글목록</a>
                <c:if test="${board.name == authUser.name}">
                    <a href="<c:url value='/board/edit/${board.no}'/>" class="btn">글수정</a>
                    <a href="javascript:void(0);" onclick="confirmDelete(${board.no});" class="btn">글삭제</a>
                </c:if>
            </div>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
