<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/bird.css'/>">

    <title>비행기</title>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>

    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
        <h1>세상에서 가장 강한 비둘기</h1>
        <img src="<c:url value='/img/kingdulgi.jpg'/>" alt="King Dulgi">
        <!-- 
        <p>이름: ${name }</p>
        <p>신장: ${height }</p>
        <p>몸무게: ${weight }</p>
        <p>능력: ${ability}</p>
        -->
        <p>"오만한 인간에게 벌을"</p>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>     
</body>
</html>
