<%-- 
    Document   : output
    Created on : Mar 11, 2019, 10:31:08 AM
    Author     : es555691
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="default.css" type="text/css">
        <title>Student Plan</title>
    </head>
    <body>
        <h1>Courses you have completed</h1>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Credit Hours</th>
                <th>PC and Web</th>
                <th>Integrated</th>
                <th>Type</th>
            </tr>
            <c:forEach var="course" items="${coursesCompleted}">
                <tr>
                    <td>${course.value.courseID}</td>
                    <td>${course.value.courseName}</td>
                    <td>${course.value.creditHours}</td>
                    <td>${course.value.pcWeb}</td>
                    <td>${course.value.integrated}</td>
                    <td>${course.value.type}</td>
                </tr>
            </c:forEach>
        </table>
        <h1>Courses to take (Quarter System)</h1>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Credit Hours</th>
                <th>PC and Web</th>
                <th>Integrated</th>
                <th>Type</th>
            </tr>
            <c:forEach var="course" items="${coursesQuarter}">
                <tr>
                    <td>${course.value.courseID}</td>
                    <td>${course.value.courseName}</td>
                    <td>${course.value.creditHours}</td>
                    <td>${course.value.pcWeb}</td>
                    <td>${course.value.integrated}</td>
                    <td>${course.value.type}</td>
                </tr>
            </c:forEach>
        </table>
        <h1>Courses to take (Semester System)</h1>
        <table>
            <tr>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Credit Hours</th>
                <th>PC and Web</th>
                <th>Integrated</th>
                <th>Type</th>
            </tr>
            <c:forEach var="course" items="${coursesSemester}">
                <tr>
                    <td>${course.value.courseID}</td>
                    <td>${course.value.courseName}</td>
                    <td>${course.value.creditHours}</td>
                    <td>${course.value.pcWeb}</td>
                    <td>${course.value.integrated}</td>
                    <td>${course.value.type}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
