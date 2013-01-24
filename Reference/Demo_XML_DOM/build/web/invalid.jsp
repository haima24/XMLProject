<%-- 
    Document   : invalid
    Created on : Jan 17, 2013, 11:50:17 AM
    Author     : Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><font color="red">Invalid username or password</font></h1>
        <c:url var="linkRegister" value="ControllerServlet">
            <c:param name="btnAction" value="RegisterLink"/>
        </c:url>
        <h3>Click <a href="">here</a> to Register</h3>
    </body>
</html>
