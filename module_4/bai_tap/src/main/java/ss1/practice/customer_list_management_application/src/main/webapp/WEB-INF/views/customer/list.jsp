
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
</tr>

        <c:forEach var="data" items="${customerList}">
    <tr>
            <td>${data.id}</td>
            <td>${data.name}</td>
            <td>${data.email}</td>
            <td>${data.address}</td>
    </tr>
        </c:forEach>
</table>
</body>
</html>
