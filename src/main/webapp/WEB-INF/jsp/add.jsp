<%--
  Created by IntelliJ IDEA.
  User: dns
  Date: 27.12.2018
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>New patient</title>
    <h2>New patient</h2>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Go back</a>
<form method="post">
<label>id
    <br>
    <input type="text" name="id_patient"></br>
</label>
<label>Surname
    <br>
    <input type="text" name="surname"></br>
</label>
<label>Name
    <br>
    <input type="text" name="name"></br>
</label>
<label>Patronymic
    <br>
    <input type="text" name="patronymic"></br>
</label>
<label>Phone number
    <br>
    <input type="text" name="phone_number"></br>
</label>
<label>
    <br>
    <button type="submit"> Add </button>
</label>
</form>
</body>
</html>
