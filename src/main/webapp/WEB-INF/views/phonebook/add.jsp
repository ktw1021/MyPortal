<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Phone Book</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/mysite.css'/>">
</head>
<body>
<div id="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/includes/navigation.jsp" %>
        <div id="content">
  
    <h2>Add Phone Book</h2>
    <form action="<c:url value='/phonebook/add'/>" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="phName" required /></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><input type="text" name="phNum" required /></td>
            </tr>
            <tr>
                <td>Home Number:</td>
                <td><input type="text" name="hmNum" required /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add" />
                </td>
            </tr>
        </table>
    </form>
    <br>
    <a href="<c:url value='/phonebook/list'/>">Back to List</a>
            </div>
        <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
    </div>
</div>
</body>
</html>
