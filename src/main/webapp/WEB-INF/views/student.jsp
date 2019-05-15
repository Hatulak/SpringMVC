<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${student == null}">
    There is no student with this index
</c:if>
<c:if test="${student != null}">
    <p>Index: ${student.index}</p>
    <p>Name: ${student.name}</p>
    <p>Surname: ${student.surname}</p>
    <p>Age: ${student.age}</p>
</c:if>
</body>
</html>
