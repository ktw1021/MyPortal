<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Phone Book List</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/phonebook.css'/>">
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <h2>Phone Book List</h2>
            <table class="phonebook-table">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Phone Number</th>
                    <th>Home Number</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="phoneBook" items="${phoneBooks}">
                    <tr>
                        <td>${phoneBook.phId}</td>
                        <td>${phoneBook.phName}</td>
                        <td>${phoneBook.phNum}</td>
                        <td>${phoneBook.hmNum}</td>
                        <td>
                            <a href="<c:url value='/phonebook/delete/${phoneBook.phId}'/>">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a class="add-link" href="<c:url value='/phonebook/add'/>">Add New Phone Book</a>
        </div>
        <br>
        
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
