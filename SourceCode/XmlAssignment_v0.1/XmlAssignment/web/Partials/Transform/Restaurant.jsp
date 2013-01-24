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
        <script language="JavaScript" src="${pageContext.request.contextPath}/Scripts/UtilsScript.js"></script>
        <script>var contextPath="${pageContext.request.contextPath}"</script>
        <script language="JavaScript" src="${pageContext.request.contextPath}/Scripts/RestaurantScript.js"></script>
        <div id="RestaurantContainer">
        <c:import url="/XmlDoc/Restaurants.xml" var="xmlDoc" charEncoding="UTF-8"/>
        <c:import url="/XslDoc/Restaurants.xsl" var="xslDoc" charEncoding="UTF-8"/>
        <x:transform xml="${xmlDoc}" xslt="${xslDoc}"/>
        </div>
        <br/>
        <div>
            <input type="text" id="txtName" value="" />
            <input type="text" id="txtLatitute" value="" />
            <input type="text" id="txtLongtitute" value="" />
            <input type="text" id="txtAddress" value="" />
            <input type="text" id="txtDescription" value="" />
            <input type="text" id="txtPhoneNum" value="" />
            <a href="#" onclick="saveNewRestaurant();">Save</a>
        </div>
    </body>
</html>
