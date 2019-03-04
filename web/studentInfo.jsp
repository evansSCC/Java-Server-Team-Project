<%-- 
    Document   : studentInfo
    Created on : Mar 4, 2019, 10:39:21 AM
    Author     : es555691
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="default.css" type="text/css">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Controller" method="POST">
            <input type="hidden" name="action" value="initialize_user">
            <div class="fieldEntry"><label for="first_name">First Name: </label><input type="text" name="first_name" id="first_name"></div><label class="errorLabel">${errors["first_name"]}</label>
            <div class="fieldEntry"><label for="last_name">Last Name: </label><input type="text" name="last_name" id="last_name"></div><label class="errorLabel">${errors["last_name"]}</label>
            <div class="fieldEntry"><label for="student_id">Student ID: </label><input type="text" name="student_id" id="student_id"></div><label class="errorLabel">${errors["student_id"]}</label>
            <h3>Focus</h3>
            <label for="pcWeb">PC Web</label><input type="radio" name="focus" value="pcWeb" id="pcWeb"><br>
            <label for="integrated">Integrated</label><input type="radio" name="focus" value="integrated" id="integrated" id="integrated"><br>
            <label class="errorLabel">${errors["focus"]}</label>
            <br><br><input type="submit" value="Submit">
        </form>
    </body>
</html>
