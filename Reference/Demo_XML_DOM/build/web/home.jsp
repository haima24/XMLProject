<%-- 
    Document   : home
    Created on : Jan 17, 2013, 11:49:03 AM
    Author     : Tu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <font color="red">Welcome,${sessionScope.FULLNAME}</font>
        <h1>Welcome to XML DOM</h1>
        <form action="ControllerServlet" method="POST">
            Name <input type="text" value="" name="txtName" /><br/>
            <input type="submit" value="Search" name="btnAction" />
        </form>
        <c:set var="info" value="${requestScope.INFO}"/>
        <c:if test="${not empty info}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Full Name</th>
                        <th>Status</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="studentDTO" items="${info}" varStatus="counter">
                    <form action="ControllerServlet">
                        <tr>
                            <td>${counter.count}</td>
                            <td>
                                ${studentDTO.studentID}
                                <input type="hidden" name="txtUsername" value="${studentDTO.studentID}" />
                            </td>
                            <td>${studentDTO.fullName}</td>
                            <td>
                                <input type="text" name="txtStatus" value="${studentDTO.status}" />
                            </td>
                            <c:url var="delete" value="ControllerServlet">
                                <c:param name="btnAction" value="delete"/>
                                <c:param name="id" value="${studentDTO.studentID}"/>
                                <c:param name="searchValue" value="${param.txtName}"/>
                            </c:url>
                            <td><a href="${delete}">Delete</a></td>
                            <td>
                                <input type="hidden" name="searchValue" value="${param.txtName}" />
                                <input type="submit" value="Update" name="btnAction" />
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
</body>
</html>
