<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CRM</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Add new customer</h2>
    </div>
    <form:form method="post" modelAttribute="newCustomer" action="saveCustomer">
        <div class="inputGroup">
            <label for="fname">First Name</label>
            <form:input id="fname" type="text"  path="firstName"/>
        </div>
        <div class="inputGroup">
            <label for="lname">Last Name</label>
            <form:input id="lname" type="text" path="lastName"/>
        </div>
        <div class="inputGroup">
            <label for="email">Email</label>
            <form:input path="email" id="email" type="email" />
        </div>
        <input type="submit" value="Submit" class="save"/>
    </form:form>
    <hr/>
    <p><a href="${pageContext.request.contextPath}/customer/list">Back to customer List</a></p>
</div>
</body>
</html>
