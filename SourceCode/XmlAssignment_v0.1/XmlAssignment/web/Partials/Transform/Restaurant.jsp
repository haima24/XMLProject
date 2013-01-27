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
        <c:catch var="ex">
            <c:import url="/XmlDoc/Restaurants.xml" var="xmlDoc" charEncoding="UTF-8"/>
        </c:catch>
        <c:choose>
            <c:when test="${not empty ex}">
                <jsp:forward page="/XmlController">
                    <jsp:param name="action" value="MARSHAL_RESTAURANTS"/>
                </jsp:forward>
            </c:when>
            <c:otherwise>
                <c:import url="/XslDoc/Restaurants.xsl" var="xslDoc" charEncoding="UTF-8"/>
                <div id="ErrorContainer"></div>
                <script language="JavaScript" src="${pageContext.request.contextPath}/Scripts/UtilsScript.js"></script>
                <script>var contextPath="${pageContext.request.contextPath}"</script>
                <script language="JavaScript" src="${pageContext.request.contextPath}/Scripts/RestaurantScript.js"></script>
                <div id="RestaurantContainer">
                    <x:transform xml="${xmlDoc}" xslt="${xslDoc}"/>
                </div>
                <br/>
                <div>
                    Name: <input type="text" id="txtName" value="" />
                    <br/>
                    Latitute: <input type="text" id="txtLatitute" value="" />
                    <br/>
                    Longtitute: <input type="text" id="txtLongtitute" value="" />
                    <br/>
                    Address: <input type="text" id="txtAddress" value="" />
                    <br/>
                    Description: <input type="text" id="txtDescription" value="" />
                    <br/>
                    PhoneNum: <input type="text" id="txtPhoneNum" value="" />
                    <br/>
                    <a href="#" onclick="saveNewRestaurant();">Save</a>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
