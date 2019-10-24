<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CRM</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - List of customers</h2>
    </div>

    <div id="container">
        <button onclick="window.location.href='showFormForAdd'; return false;" class="add-button">Add Customer</button>
        <table id="content">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${customers}" var="customer">

            <c:url var="updateLink" value="/customer/showFormForUpdate">
                <c:param name="customerId" value="${customer.id}" />
            </c:url>
            <c:url var="deleteLink" value="/customer/deleteCustomer">
                <c:param name="customerId" value="${customer.id}" />
            </c:url>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure ?'))) return false;">Delete</a></td>.
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>