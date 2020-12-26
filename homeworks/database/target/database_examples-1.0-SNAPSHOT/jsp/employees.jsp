<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 04/12/2020
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registered Employees</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Already registered!
    </div>
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Birth Date</th>
        </tr>
        <c:forEach items="${employeesFromServer}" var="employee">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
