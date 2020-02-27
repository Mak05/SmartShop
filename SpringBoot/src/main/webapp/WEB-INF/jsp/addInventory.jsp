<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
.error {
	color: red;
	font-style: italic;
}
</style>
<form:form method="post" action="product" modelAttribute="inventory">
	<h2 class="jumbotron" height=100 align="center">Add Product</h2>
	<div align="center">
		<table>
			<tr>
				<form:hidden path="id"></form:hidden>
				<td>Product Name * :</td>
				<td><form:input path="name" id="name" size="35" maxlength="30" />
					<form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Product Description :</td>
				<td><form:input path="description" id="description" size="35"
						maxlength="30" /> <form:errors path="description"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Quantity *:</td>
				<td><form:input path="quantity" id="quantity" size="6"
						maxlength="5" /> <form:errors path="quantity" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td>Price *:</td>
				<td><form:input path="price" id="price" size="8" maxlength="6" />
					<form:errors path="price" cssClass="error" /></td>
			</tr>

			<tr>
				<td><br /></td>
				<td><input type="submit" class="btn btn-success"
					value="Save Product" /></td>
			</tr>
		</table>
		<c:choose>
			<c:when test="${fn:length(productList) > 0}">

				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
						
						<td><a href="" >Edit</a></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">No Products Found</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</div>
</form:form>
<center>
	<a href="/logout">logout</a>
</center>
<p align="center">${message}</p>