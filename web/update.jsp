<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 3/29/19
  Time: 11:47 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Information</title>
    <link rel="stylesheet" href="prettyfly.css">
</head>
<body>
<h1>Update Your Information</h1>
<p>Please enter your email address and corrected user information.</p>
<form action="subscription" method="post">
    <input type="hidden" name="action" value="update">
    <label for="emailEntry">Email: </label>
    <input type="email" name="email" id="emailEntry" required><br><br>
    <label for="firstNameEntry">First name: </label>
    <input type="text" name="firstName" id="firstNameEntry" required><br><br>
    <label for="lastNameEntry">Last name: </label>
    <input type="text" name="lastName" id="lastNameEntry" required><br><br>
    <label>&nbsp</label>
    <input type="submit" value="Update Information" name="submit">&nbsp;
    <a href="index.jsp"><input type="button" value="Go Back"></a>
</form>
</body>
</html>
