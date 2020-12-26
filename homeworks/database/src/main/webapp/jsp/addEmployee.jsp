<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 04/12/2020
  Time: 01:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Register!
    </div>
    <form method="post" action="/addEmployee">
        <label for="first-name">First Name
            <input class="input-field" type="text" id="first-name" name="first-name">
        </label>
        <label for="last-name">Last Name
            <input class="input-field" type="text" id="last-name" name="last-name">
        </label>
        <label for="birthDate">Birth Date
            <input class="input-field" type="date" id="birthDate" name="birthDate">
        </label>
        <label for="town-from">Town From
            <input class="input-field" type="text" id="town-from" name="town-from">
        </label>
        <input type="submit" value="Add employee">
    </form>
</div>
</body>
</html>
