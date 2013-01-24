<%-- 
    Document   : index
    Created on : Jan 17, 2013, 10:58:01 AM
    Author     : Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="ControllerServlet" method="POST">
            Username <input type="text" name="txtUsername" value="${param.txtID}"/><br/>
            Password <input type="password" name="txtPassword" value=""/>
            <input type="submit" name="btnAction" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
