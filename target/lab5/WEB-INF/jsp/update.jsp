<%--
  Created by IntelliJ IDEA.
  User: dns
  Date: 19.03.2019
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">Go back</a>
<div align="center">
    <form method="post">
        <label>id
            <br>
            <input type="text" name="id_patient" value="0"></br>
        </label>
        <label>Surname
            <br>
            <input type="text" name="surname" value="${patient.surname}"></br>
        </label>
        <label>Name
            <br>
            <input type="text" name="name" value="${patient.name}"></br>
        </label>
        <label>Patronymic
            <br>
            <input type="text" name="patronymic" value="${patient.patronymic}"></br>
        </label>
        <label>Phone number
            <br>
            <input type="text" name="phone_number" value="${patient.phone_number}"></br>
            <br>
        </label>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
