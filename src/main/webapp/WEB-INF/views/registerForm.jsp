<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <%--input field NAME must be the same as name of the field in java model--%>
        <%--<form name="registerForm" method="POST">--%>
            <%--Name<input type="text" name="name"/><br>--%>
            <%--Surame<input type="text" name="surname"/><br>--%>
            <%--Username<input type="text" name="username"/><br>--%>
            <%--Password<input type="text" name="password"/><br>--%>

            <%--<input type="submit" value="Submit Registration"/>--%>
        <%--</form>--%>

        <%-- modelAttribute is used here instead of commandName, which is invalid since Spring 5.x.x version --%>
        <%--modelAttribute is a name of a MODEL, which is provided by a conroller, which sends us to this page--%>
        <sf:form name="registerForm" method="POST" modelAttribute="spitter" >
            Name <sf:input path="name" /><br>
            Surnamame <sf:input path="surname" /><br>
            E-mail address <sf:input path="email" type="email"/><br>
            Username <sf:input path="username" /><br>
            Password <sf:password path="password" /><br>

            <input type="submit" value="Submit registration"/>
        </sf:form>

        <br>

        Spitter name: <c:out value="${spitter.name}" /><br>
        Spitter username:  <c:out value="${spitter.username}" />


    </body>

</html>