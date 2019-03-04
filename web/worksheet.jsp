<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Courses Worksheet</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="default.css" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1 class="title">Courses Worksheet</h1>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Credit Hours</th>
                <th>Focus</th>
                <th>Type</th>
                <th>Completed</th>
            </tr>
            <!-- This will output the classes with a foreach loop -->
            <tr>
                <td>INFO-2514</td>
                <td>Java Server Programming</td>
                <td>4.5</td>
                <td>PC Web - Required</td>
                <td>Quarter</td>
                <td><input type="checkbox" name="completed" value="INFO-2514"></td>
            </tr>
        </table>
        <div>
            <h2></h2>
            <form action="business/Controller.java">
                <input type="hidden" name="action" value="process_worksheet">
                <div class="fieldEntry"><label for="studentName">Name: </label><input type="text" id="studentName" name="studentName"></div>
                <div class="fieldEntry"><label for="studentID">Student ID: </label><input type="text" id="studentID" name="studentID"></div>
                <input class="submitButton" type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
