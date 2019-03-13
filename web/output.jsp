<%-- 
    Document   : output
    Created on : Mar 11, 2019, 10:31:08 AM
    Author     : es555691
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <td>${courseCompleted.value.courseID}</td>
                    <td>${courseCompleted.value.courseName}</td>
                    <td>${courseCompleted.value.creditHours}</td>
                    <td>${courseCompleted.value.pcWeb}</td>
                    <td>${courseCompleted.value.integrated}</td>
                    <td>${courseCompleted.value.type}</td>
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
                    <td>${courseQuarter.value.courseID}</td>
                    <td>${courseQuarter.value.courseName}</td>
                    <td>${courseQuarter.value.creditHours}</td>
                    <td>${courseQuarter.value.pcWeb}</td>
                    <td>${courseQuarter.value.integrated}</td>
                    <td>${courseQuarter.value.type}</td>
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
                    <td>${courseSemester.value.courseID}</td>
                    <td>${courseSemester.value.courseName}</td>
                    <td>${courseSemester.value.creditHours}</td>
                    <td>${courseSemester.value.pcWeb}</td>
                    <td>${courseSemester.value.integrated}</td>
                    <td>${courseSemester.value.type}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
