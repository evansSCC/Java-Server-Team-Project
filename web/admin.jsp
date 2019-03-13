<%-- 
    Document   : admin
    Created on : Mar 13, 2019, 10:01:29 AM
    Author     : es555691
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="default.css" type="text/css">
        <title>Administrator Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="controller" method="POST">
            <label>Username </label><input type="text" name="username" value=""><br>
            <label>Password </label><input type="text" name="password" value=""><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="action" value="admin_login">
        </form>
    </body>
</html>
