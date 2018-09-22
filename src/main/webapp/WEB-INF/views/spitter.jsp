<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>

<h1>Welcome to Your Spittr Account!</h1>
Your Profile <br>
<c:out value="${spitter.username}" /><br>
<c:out value="${spitter.name}" /><br>
<c:out value="${spitter.surname}" /><br>

</body>

</html>