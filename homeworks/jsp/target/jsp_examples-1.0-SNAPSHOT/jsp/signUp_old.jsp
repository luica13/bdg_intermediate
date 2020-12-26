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
<html>
<head>
    <title>Sign Up!</title>
</head>
<body>
<%
    ArrayList<User> users = (ArrayList<User>) request.getAttribute("usersFromServer");
%>
<table>
    <tr>
        <th>User Name</th>
        <th>Birth date</th>
    </tr>

    <%
        for (User user : users) {
    %>
    <tr>
        <td><%=user.getName()%></td>
        <td><%=user.getBirthDate()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
