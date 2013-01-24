<%-- 
    Document   : register
    Created on : Jan 21, 2013, 11:04:36 AM
    Author     : Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register Page</h1>
        <form action="ControllerServlet" method="post">
            Id <input type="text" name="txtID" value="" /><br/>
            Lastname <input type="text" name="txtLastname" value="" /><br/>
            Firstname <input type="text" name="txtFirstName" value="" /><br/>
            Password <input type="password" name="txtPassword" value="" /><br/>
            <input type="submit" value="Register" name="btnAction" />
            <input type="reset" value="Reset" />
        </form>
    </body>
</html>
