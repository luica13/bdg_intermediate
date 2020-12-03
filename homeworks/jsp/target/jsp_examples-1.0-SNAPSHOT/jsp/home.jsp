<%--
  Created by IntelliJ IDEA.
  User: David
  Date: 04/12/2020
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<span style="color: ${cookie.color.value}">Hello</span>

<div>
    <form method="post" action="/home">
        <label class="textarea-field" for="color">Color
            <select class="select-field" name="color" id="color">
                <option value="red">red</option>
                <option value="green">green</option>
                <option value="black">black</option>
                <option value="blue">blue</option>
            </select>
        </label>
        <input type="submit" name="Color send">
    </form>
</div>

</body>
</html>
