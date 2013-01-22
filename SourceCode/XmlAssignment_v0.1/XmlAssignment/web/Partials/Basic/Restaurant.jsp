<%-- 
    Document   : Restaurant
    Created on : Jan 16, 2013, 11:16:05 PM
    Author     : Tu
--%>

<%@page import="xml.bar.resource.BarContants"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List restaurant</title>
    </head>

    <body>
        <h1>Hello</h1>
        <c:set var="reslist" value="${requestScope['RESTAURANT_LIST']}"/>
        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="res" items="${reslist}">
                    <tr>
                        <td>${res.name}</td>
                        <td>${res.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
