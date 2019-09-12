<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 3/28/19
  Time: 10:03 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unsubscribe</title>
    <link rel="stylesheet" href="prettyfly.css">
</head>
<body>
<h1>Unsubscribe</h1>
<p>Please enter your email address to remove yourself from our email list.</p>
<form action="subscription" method="post">
    <input type="hidden" name="action" value="remove">
    <label for="emailEntry">Email: </label>
    <input type="email" name="email" id="emailEntry" required><br><br>
    <label>&nbsp</label>
    <input type="submit" value="Unsubscribe" name="submit">&nbsp;
    <a href="index.jsp"><input type="button" value="Go Back"></a>
</form>
</body>
</html>
