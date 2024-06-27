<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>게시물 수정</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
    <link href="<c:url value='/css/board.css' />" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value='/javascript/board.js'/>"></script>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>

    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <form name="editForm" method="post" action="<c:url value='/board/edit'/>" onsubmit="return validateForm('editForm')">
                <input type="hidden" name="no" value="${board.no}">
                <table border="1" width="580">
                    <tr>
                        <td colspan="2"><h3>게시물 수정</h3></td>
                    </tr>
                    <tr>
                        <th colspan="2">수정하기</th>
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title" value="${board.title}"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td>
                            <textarea id="content" name="content">${board.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>조회수</td>
                        <td>${board.viewCount}</td>
                    </tr>
                    <tr>
                        <td>작성일</td>
                        <td>
                            <fmt:formatDate value="${board.createdDate}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="<c:url value='/board/list'/>">취소</a>
                            <input type="submit" value="수정">
                        </td>    
                    </tr>
                </table>
            </form>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>   
</body>
</html>
