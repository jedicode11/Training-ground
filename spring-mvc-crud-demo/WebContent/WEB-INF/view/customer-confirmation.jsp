<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Customer Confirmation</title>
</head>

<body>

The customer is confirmed: <c:out value="${customer.firstName}" /> <c:out value="${customer.lastName}" />

<br><br>

Free passes: <c:out value="${customer.freePasses}" />

<br><br>

Postal Code: <c:out value="${customer.postalCode}" />

<br><br>

Course Code: <c:out value="${customer.courseCode}" />

</body>

</html>










