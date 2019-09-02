<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
<form:form action="/person/license" method="POST" modelAttribute="license">
	<form:select path="person">
		<c:forEach items="${people}" var="onePerson">
			 <form:option value="${onePerson}">
			 	${onePerson.firstName} ${onePerson.lastName} 
			 </form:option>
	    </c:forEach>
	</form:select>
	<p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" path="expirationDate"/>
    </p> 
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>