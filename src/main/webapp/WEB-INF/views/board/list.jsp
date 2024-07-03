<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>My Homepage</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/board.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script type="text/javascript" src="<c:url value='/javascript/board.js'/>"></script>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
    <div id="wrapper">
        <div id="content">
            <table class="tbl-ex">
                <tr>
                    <td colspan="7"><h3>게시판</h3></td>
                </tr>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>조회수</th>
                    <th>작성일</th>
                    <th>파일</th>
                    <th>수정 / 삭제</th>
                </tr>
                <c:forEach var="board" items="${boards}">
                    <tr>
                        <td>${board.no}</td>
                        <td><a href="<c:url value='/board/view/${board.no}'/>">${board.title}</a></td>
                        <td>${board.name}</td>
                        <td>${board.viewCount}</td>
                        <td><fmt:formatDate value="${board.createdDate}" pattern="yyyy-MM-dd HH:mm"/></td>
                        <td>
                            <c:if test="${board.filePath != null}">
                                <img src="${pageContext.request.contextPath}/upload-images/${board.fileName}" alt="Image" class="thumbnail-preview"/>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${board.name == authUser.name}">
                                <a href="<c:url value='/board/edit/${board.no}'/>" class="btn">수정</a>
                                <a href="javascript:void(0);" onclick="confirmDelete(${board.no});" class="btn">삭제</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="7"><a href="<c:url value='/board/write'/>" class="btn">글쓰기</a></td>
                </tr>
            </table>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
