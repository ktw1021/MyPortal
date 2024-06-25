<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
<link type="text/css" rel="stylesheet" href="<c:url value='/css/home.css'/>">
<meta charset="UTF-8">
<title>Guestbook List</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    h1 {
        color: #333;
    }
    .message {
        color: green;
        font-weight: bold;
        margin-bottom: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f4f4f4;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    .actions {
        display: flex;
        gap: 10px;
    }
    .actions a {
        text-decoration: none;
        color: #007BFF;
    }
    .actions a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <h1>방명록</h1>
            <c:if test="${not empty message}">
                <div class="message">${message}</div>
            </c:if>
            <form action="<c:url value='/guestbook/write'/>" method="post">
                <table>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" required /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" required /></td>
                    </tr>
                    <tr>
                        <td>Content:</td>
                        <td><textarea name="content" required></textarea></td>
                    </tr>
                    <tr>
                        <td colspan="2"><button type="submit">Submit</button></td>
                    </tr>
                </table>
            </form>
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Name</th>
                        <th>Content</th>
                        <th>Reg Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vo" items="${list}">
                        <tr>
                            <td>${vo.no}</td>
                            <td>${vo.name}</td>
                            <td>${vo.content}</td>
                            <td>${vo.reg_date}</td>
                            <td>
                                <div class="actions">
                                    <a href="<c:url value='/guestbook/edit/${vo.no}'/>">Edit</a>
                                    <a href="<c:url value='/guestbook/delete/${vo.no}'/>">Delete</a>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
