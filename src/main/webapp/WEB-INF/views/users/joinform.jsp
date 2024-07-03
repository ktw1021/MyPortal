<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 가입폼</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mysite.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/users.css">
    <script src="${pageContext.request.contextPath}/javascript/users.js"></script>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <h1>회원 가입</h1>
            
            <form:form id="join-form" modelAttribute="userVo" action="${pageContext.request.contextPath}/users/join" method="POST">
                <label for="name">이름</label>
                <form:input path="name" placeholder="이름을 입력하십시오"/><br>
                <form:errors path="name" cssClass="error"/>

                <br>
                <label for="password">비밀번호</label>
                <form:input path="password" placeholder="비밀번호를 입력하십시오"/><br>
                <form:errors path="password" cssClass="error"/>

                <br>
                <label for="email">이메일</label>
                <form:input path="email" placeholder="이메일을 입력하십시오"/>
                <input type="button" id="check-email" data-target="${pageContext.request.contextPath}/users/emailcheck" value="이메일 중복체크"/>
                <input type="hidden" name="emailCheck" value="n"/><br>
                <form:errors path="email" cssClass="error"/>
                
                <br>
                <label for="gender">성별</label>
                <input type="radio" name="gender" value="M" checked>남성</input>
                <input type="radio" name="gender" value="F">여성</input><br>

                <br>
                <label for="agree">약관동의</label>
                <input type="checkbox" id="agree" name="agree" value="y"/><br>
                <span>약관에 동의해야 가입할 수 있습니다.</span><br>

                <br>
                <input type="submit" value="전송"/>
            </form:form>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
