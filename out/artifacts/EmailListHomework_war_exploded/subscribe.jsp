<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 3/30/19
  Time: 12:58 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subscribe</title>
    <link rel="stylesheet" href="prettyfly.css">
</head>
<body>
<h1>Join our email list!</h1>
<p>Please enter the following information to add yourself to our email list.</p>
<form action="subscription" method="post">
    <input type="hidden" name="action" value="add">
    <label for="emailEntry">Email:</label>
    <input type="email" name="email" id="emailEntry" required><br><br>
    <label for="firstNameEntry">First name:</label>
    <input type="text" name="firstName" id="firstNameEntry" required><br><br>
    <label for="lastNameEntry">Last name:</label>
    <input type="text" name="lastName" id="lastNameEntry" required><br><br>
    <label>&nbsp</label>
    <input type="submit" value="Subscribe" name="submit">&nbsp;
    <a href="index.jsp"><input type="button" value="Go Back"></a>
</form>
</body>
</html>
