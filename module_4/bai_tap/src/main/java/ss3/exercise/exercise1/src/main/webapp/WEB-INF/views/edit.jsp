<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vinho
  Date: 11/22/2022
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="" method="post" modelAttribute="language" >
    <center>
    <form:hidden path="id"/>
   <p><form:select path="language" items="${stringLanguage}"></form:select></p>
    <p><form:select path="pageSize" items="${pageSize}"></form:select></p>
        <p><form:checkbox path="spamFilter"/>

    <p><form:textarea path="signature"/></p>
    <p><input type="submit" value="Save"></p>
    </center>
</form:form>
</body>
</html>
