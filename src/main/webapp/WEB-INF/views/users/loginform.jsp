<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value="/css/users.css" />"/>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
        
            <h2>로그인</h2>
            <c:if test="${not empty loginAlert}">
                <p style="color: red;">${loginAlert}</p>
            </c:if>
            <c:if test="${not empty error}">
                <p style="color: red;">${error}</p>
            </c:if>
    
            <form id="login-form" name="loginform" method="POST" action="<c:url value="/users/login" />">
                <label class="block-label" for="email">이메일</label> 
                <input id="email" name="email" type="text" value=""> 
                <label class="block-label" for="password">패스워드</label> 
                <input id="password" name="password" type="password" value="">
                <input type="submit" value="로그인">
            </form>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
