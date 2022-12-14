<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add-Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"
								value="${customer.firstName }" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName" value="${customer.lastName }" /></td>

					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" value="${customer.email }" /></td>
					</tr>
					<tr>
						<td><input class="save" type="submit" value="Save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style=""></div>
		<a href="${pageContext.request.contextPath}/customer/list">Back to customers' list</a>
	</div>
</body>
</html>