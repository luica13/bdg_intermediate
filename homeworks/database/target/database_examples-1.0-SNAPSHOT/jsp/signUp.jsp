<%@ page import="java.util.List" %>
<%@ page import="com.bdg.models.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: David
  Date: 03/12/2020
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign Up!</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="/signUp">
        <label for="name">User Name
            <input class="input-field" type="text" id="name" name="name">
        </label>
        <label for="birthDate">Birth Date
            <input class="input-field" type="text" id="birthDate" name="birthDate">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign Up">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">
        Already Registered
    </div>
    <table>
        <tr>
            <th>User Name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
