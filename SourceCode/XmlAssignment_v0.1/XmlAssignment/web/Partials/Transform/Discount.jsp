<%-- 
    Document   : Discount
    Created on : Jan 25, 2013, 1:45:21 AM
    Author     : TuanDTA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="/XmlDoc/Discounts.xml" var="xmlDoc" charEncoding="UTF-8"/>
        <c:import url="/XslDoc/Discounts.xsl" var="xslDoc" charEncoding="UTF-8"/>
        <x:transform xml="${xmlDoc}" xslt="${xslDoc}"/>
    </body>
</html>
