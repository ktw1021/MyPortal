<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 여기서 선언 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 성공</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
<link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/css/users.css"/>
</head>
<body>
<div id="container">
    <%@ include file="../includes/header.jsp" %> <!-- header.jsp에서는 중복 선언하지 않도록 수정 -->
    <div id="wrapper">
        <%@ include file="../includes/navigation.jsp" %> <!-- navigation.jsp에서도 중복 선언하지 않도록 수정 -->
        <div id="content">
            
	<h1>회원 가입 성공</h1>
	<p class="jr-success">
		회원가입을 축하합니다.
	</p>
	<p>
		<a href="<%= request.getContextPath() %>/users/login">로그인하기</a>
	</p>
	        </div>
        <%@ include file="../includes/footer.jsp" %> <!-- footer.jsp에서도 중복 선언하지 않도록 수정 -->
    </div>
</div>
</body>
</html>
