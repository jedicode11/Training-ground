<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

The student is confirmed: <c:out value="${student.firstName}" /> <c:out value="${student.lastName}" />

<br><br>

Country: <c:out value="${student.country}" />

<br><br>

Favorite Language: <c:out value="${student.favoriteLanguage}" />

<br><br>

Operating Systems:

<ul>
	<c:forEach var="temp" items="${student.operatingSystems}">

		<li> <c:out value="${temp}" /> </li>

	</c:forEach>
</ul>

</body>

</html>







