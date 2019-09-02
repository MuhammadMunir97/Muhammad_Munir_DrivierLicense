<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All People</title>
</head>
<body>

<h1>all People</h1>
<a href="/person/new"> New Person</a>
<a href="/person/license">New License</a>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${people}" var="person">
        <tr>
        	<td><a href="/person/${person.id}"><c:out value="${person.firstName}"/></a></td>
            <td><c:out value="${person.lastName}"/></td>
            <td>
            <form action="/person/${person.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>