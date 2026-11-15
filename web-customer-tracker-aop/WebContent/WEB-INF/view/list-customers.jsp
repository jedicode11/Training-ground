<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				
				<c:url var="deleteLink" value="/customer/delete" />
				<c:forEach var="tempCustomer" items="${customers}">
				
				
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>					


					
					<tr>
						<td> <c:out value="${tempCustomer.firstName}" /> </td>
						<td> <c:out value="${tempCustomer.lastName}" /> </td>
						<td> <c:out value="${tempCustomer.email}" /> </td>
						
						<td>
						
							<a href="${updateLink}">Update</a>
							|
							<form class="delete-form" method="post" action="<c:out value="${deleteLink}" />"
							      onsubmit="return confirm('Are you sure you want to delete this customer?')">
								<input type="hidden" name="customerId" value="<c:out value="${tempCustomer.id}" />" />
								<button type="submit">Delete</button>
							</form>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









