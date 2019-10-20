<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring Demo</title>
</head>
<body>
<ul>
    <c:forEach items="${customers}" var="customer">
        <li>${customer.firstName} ${customer.lastName} ${customer.email}</li>
    </c:forEach>
</ul>
</body>
</html>