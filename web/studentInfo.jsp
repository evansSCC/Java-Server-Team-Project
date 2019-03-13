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
        <h1>Enter your information below</h1>
        <form action="Controller" method="POST">
            <input type="hidden" name="action" value="initialize_user">
            <div class="fieldEntry"><label class="fieldLabel" for="first_name">First Name: </label><input type="text" name="first_name" id="first_name"><label class="errorLabel">${errors["first_name"]}</label></div>
            <div class="fieldEntry"><label class="fieldLabel" for="last_name">Last Name: </label><input type="text" name="last_name" id="last_name"><label class="errorLabel">${errors["last_name"]}</label></div>
            <div class="fieldEntry"><label class="fieldLabel" for="student_id">Student ID: </label><input type="text" name="student_id" id="student_id"><label class="errorLabel">${errors["student_id"]}</label></div>
            <h3>Focus</h3>
            <label for="pcWeb">PC Web</label><input type="radio" name="focus" value="pcWeb" id="pcWeb"><br>
            <label for="integrated">Integrated</label><input type="radio" name="focus" value="integrated" id="integrated" id="integrated"><br>
            <label class="errorLabel">${errors["focus"]}</label>
            <br><br><input type="submit" value="Submit"><br><br>
            
            <a href="admin.jsp">Admin Login</a>
        </form>
    </body>
</html>
