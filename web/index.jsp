<%--
  Created by IntelliJ IDEA.
  User: gthacker
  Date: 3/28/19
  Time: 8:45 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome!</title>
    <link rel="stylesheet" href="prettyfly.css">
</head>
<body>
<h1>Mailing List Web App</h1>
<p>Please make a choice from the following selection.</p><br>
<form action="subscription" method="post">
    <input type="hidden" name="action" value="show">
    <a href="subscribe.jsp"><input type="button" value="Subscribe"></a>
    <a href="unsubscribe.jsp"><input type="button" value="Unsubscribe"></a>
    <a href="update.jsp"><input type="button" value="Update Information"></a>
    <input type="submit" value="Display List" name="submit">
</form>
</body>
</html>
