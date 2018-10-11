<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>

    <style>
        div.error {
            color:red;
            border-style : solid;
        }

        label.error {
            text-decoration : underline;
            color: cadetblue;
        }
    </style>
    <body>
        <%-- modelAttribute is used here instead of commandName, which is invalid since Spring 5.x.x version --%>
        <%--modelAttribute is a name of a MODEL, which is provided by a conroller, which sends us to this page--%>
        <sf:form name="registerForm" method="POST" modelAttribute="spitter" >
            <sf:label path="name" cssErrorClass="error">Name</sf:label> <sf:input path="name" />  <br>
            <sf:label path="surname" cssErrorClass="error">Surnamame</sf:label> <sf:input path="surname" /> <br>
            <sf:label path="email" cssErrorClass="error">E-mail address</sf:label> <sf:input path="email" type="email"/><br>
            <sf:label path="username" cssErrorClass="error">Username </sf:label><sf:input path="username" /><br>
            <sf:label path="password" cssErrorClass="error">Password</sf:label> <sf:password path="password" /><br>

            <input type="submit" value="Submit registration"/>

            <%--Error messages are set by constraint annotation on the model Spitter--%>
            <sf:errors path="*" element="div" cssClass="error"/>
        </sf:form>

        <br>

    </body>

</html>