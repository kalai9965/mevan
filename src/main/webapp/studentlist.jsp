<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>student data</title>
</head>
<body>
<h1>student list</h1>
<table border="1">
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>age</th>
</tr>

  <c:forEach items="${datas}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>