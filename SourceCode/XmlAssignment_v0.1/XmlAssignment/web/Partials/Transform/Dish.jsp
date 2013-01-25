<%-- 
    Document   : Dish
    Created on : Jan 25, 2013, 10:10:02 AM
    Author     : Sean
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
        <h1>Hello World!</h1>
         <c:import url="/XmlDoc/Dishes.xml" var="xmlDoc" charEncoding="UTF-8"/>
        <c:import url="/XslDoc/Dishes.xsl" var="xslDoc" charEncoding="UTF-8"/>
        <x:transform xml="${xmlDoc}" xslt="${xslDoc}">
            <x:param name="resid" value="${param.resid}"/>
        </x:transform>
    </body>
</html>
