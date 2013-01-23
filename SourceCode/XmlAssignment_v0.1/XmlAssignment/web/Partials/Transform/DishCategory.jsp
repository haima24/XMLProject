<%-- 
    Document   : DishCategory
    Created on : Jan 22, 2013, 7:40:50 PM
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
        <c:import url="/XmlDoc/DishCategory.xml" var="xmlDoc" charEncoding="UTF-8"/>
        <c:import url="/XslDoc/DishCategory.xsl" var="xslDoc" charEncoding="UTF-8"/>
        <x:transform xml="${xmlDoc}" xslt="${xslDoc}">
            <x:param name="resid" value="${param.resid}"/>
        </x:transform>
    </body>
</html>
