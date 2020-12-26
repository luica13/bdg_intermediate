<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bdg.models.Schedule" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: David
  Date: 04/12/2020
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
    <tr>
        <th>Company Name</th>
        <th>Plane</th>
        <th>Town To</th>
        <th>Flight Time</th>
    </tr>
    <c:forEach items="${scheduleListFromServer}" var="schedule">
        <tr>
            <td>${schedule.companyName}</td>
            <td>${schedule.plane}</td>
            <td>${schedule.townTo}</td>
            <td>${schedule.flightTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
