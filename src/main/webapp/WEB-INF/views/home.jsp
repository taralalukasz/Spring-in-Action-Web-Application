<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Spittr</title>
</head>
    <body>
        <h1>Welcome in service Spittr</h1>
        <a href="<c:url value="/spittles" />">Link to all spittles</a>

        <h1>You can see first spittle here by using resource-based path variable</h1>
        <a href="<c:url value="/spittles/show/1" />">Link to 1st spittle</a>
    </body>
</html>