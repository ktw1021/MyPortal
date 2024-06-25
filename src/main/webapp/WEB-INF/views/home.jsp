<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="<c:url value = "/css/mysite.css"/>">
<link type="text/css" rel="stylesheet" href="<c:url value = "/css/home.css"/>">

<title>비행기</title>
</head>
<body>
 <div id="container">
 
 <%@ include file="/WEB-INF/views/includes/header.jsp" %>
 
  <div id="wrpapper">
 	
    <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
	<h1>세상에서 가장 강한 비둘기</h1>
	<!-- 
	<p>이름: ${name }</p>
	<p>신장: ${height }</p>
	<p>몸무게: ${weight }</p>
	<p>능력: ${ability}</p>
	 -->
	 <div id="content">
	 </div>
	 
	 <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
	 </div>
</div>	 
</body>
</html>