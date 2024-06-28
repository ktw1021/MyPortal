<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Phone Book Entry</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
            <h2>Edit Phone Book Entry</h2>
            <form method="post" action="<c:url value='/phonebook/edit'/>">
                <input type="hidden" name="id" value="${phoneBook.id}" />
                <table>
                    <tr>
                        <td>ID:</td>
                        <td>${phoneBook.id}</td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="name" value="${phoneBook.name}" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type="text" name="phoneNum" value="${phoneBook.phoneNum}" /></td>
                    </tr>
                    <tr>
                        <td>Home Number:</td>
                        <td><input type="text" name="homeNum" value="${phoneBook.homeNum}" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Update" />
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
