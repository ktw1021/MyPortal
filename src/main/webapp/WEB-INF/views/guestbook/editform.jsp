<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Guestbook Entry</title>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h1 {
        color: #333;
    }
    form {
        margin-top: 20px;
    }
    label {
        display: block;
        margin: 10px 0 5px;
    }
    input[type="text"], input[type="password"], textarea {
        width: 100%;
        padding: 10px;
        margin: 5px 0 10px;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #007BFF;
        color: white;
        border: none;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
            
<div id="container">

    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
        
    <h1>Edit Guestbook Entry</h1>
    <form action="<c:url value='/guestbook/edit'/>" method="post">
        <input type="hidden" name="no" value="${guestbookVo.no}" />
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${guestbookVo.name}" required />

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />

        <label for="content">Content:</label>
        <textarea id="content" name="content" required>${guestbookVo.content}</textarea>

        <input type="submit" value="Update" />
    </form>
    
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
