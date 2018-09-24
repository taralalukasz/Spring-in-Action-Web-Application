<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <%--input field NAME must be the same as name of the field in java model--%>
        <form name="registerForm" method="POST">
            Name<input type="text" name="name"/><br>
            Surame<input type="text" name="surname"/><br>
            Username<input type="text" name="username"/><br>
            Password<input type="text" name="password"/><br>

            <input type="submit" value="Submit Registration"/>
        </form>
    </body>

</html>