<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Homepage</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">

</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            
	<form method="post"
		action="<c:url value = "/guestbook/delete"/>">
		<input type='hidden' name="no" value="${no }"> 
		<label
			for="password">비밀번호</label>
		<input type="password" name="password">
		<input type="submit" value="확인"><br> 
		<a href="<c:url value = "/guestbook"/>">목록
			보기</a>
	</form>
	
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>