<%-- 
    Document   : Restaurant
    Created on : Jan 22, 2013, 12:50:01 AM
    Author     : Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:import url="/WEB-INF/XmlDoc/Restaurants.xml" var="xmlDoc" charEncoding="UTF-8"/>
        <c:import url="/WEB-INF/XslDoc/Restaurants.xsl" var="xslDoc" charEncoding="UTF-8"/>
        <x:transform xml="${xmlDoc}" xslt="${xslDoc}"/>
    </body>
</html>
