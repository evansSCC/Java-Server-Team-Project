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
        <form action="Controller">
            <table>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Credit Hours</th>
                    <th>pcWeb</th>
                    <th>Integrated</th>
                    <th>Type</th>
                    <th>Completed</th>
                </tr>
                <!-- This will output the classes with a foreach loop -->
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td>${course.courseID}</td>
                        <td>${course.courseName}</td>
                        <td>${course.creditHours}</td>
                        <td>${course.pcWeb}</td>
                        <td>${course.integrated}</td>
                        <td>${course.type}</td>
                        <td><input type="checkbox" name="completed" value="${course.courseID}"></td>
                    </tr>
                </c:forEach>
            </table>
            <h2></h2>
            <input type="hidden" name="action" value="process_worksheet">
            <input type="submit" value="Submit">
        </form>
        <div class="fieldEntry"><label for="studentName">Name: </label><label>${name}</label></div>
        <div class="fieldEntry"><label for="studentID">Student ID: </label><label>${studentID}</label></div>
    </body>
</html>
