<%@ page contentType="text/html;" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <body onload="val()">
    <style>
        table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-collapse: collapse;
        text-align: center;
    }
    th, td:first-child {
        background: #AFCDE7;
        color: white;
        padding: 10px 20px;
    }
    th, td {
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: white;
    }
    td {
        background: #D8E6F3;
    }
    </style>

    <div style="display: flex; justify-content: center;">
    <div>
        <table>
            <caption><h2>List of patients</h2></caption>
            <tr>
                <th>id</th>
                <th>Surname</th>
                <th>Name</th>
                <th>Patronymic</th>
                <th>Phone number</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${patients}" var="Patient">
              <tr>
                  <td><c:out value="${Patient.id_patient}"/></td>
                  <td><c:out value="${Patient.surname}"/></td>
                  <td><c:out value="${Patient.name}"/></td>
                  <td><c:out value="${Patient.patronymic}"/></td>
                  <td><c:out value="${Patient.phone_number}"/></td>
                  <td><a href="./up/${Patient.id_patient}">Update data</a></td>
              </tr>
            </c:forEach>
        </table>
        <p style="font-size: larger; color: red">${text}</p>
    </div>

    <script>
        function val() {
            var tmp = "${history.size()}";
            if (tmp < 1) {
                document.getElementById("historyTableDiv").style.display = "none";
            }
        }
    </script>

    <div  id="historyTableDiv">
        <table>
            <caption><h2>History</h2></caption>
            <tr>
                <th>id</th>
                <th>Surname</th>
                <th>Name</th>
                <th>Patronymic</th>
                <th>Phone number</th>
            </tr>
            <c:forEach items="${history}" var="patient">
                <tr>
                    <td><c:out value="${patient.id_patient}"/></td>
                    <td><c:out value="${patient.surname}"/></td>
                    <td><c:out value="${patient.name}"/></td>
                    <td><c:out value="${patient.patronymic}"/></td>
                    <td><c:out value="${patient.phone_number}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
    <a href="${pageContext.request.contextPath}/add">Add new patient</a>
    <p>Singleton message: ${message}</p>
    </body>
</html>
