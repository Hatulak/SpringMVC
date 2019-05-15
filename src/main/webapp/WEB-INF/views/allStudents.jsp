<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Students</title>
</head>
<body>
<table>
    <c:if test="${students != null}">
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.index}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.age}</td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${students == null}">
        There are no students in database
    </c:if>
</table>
</body>
</html>
