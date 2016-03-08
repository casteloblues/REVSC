<%-- 
    Document   : index
    Created on : Mar 7, 2016, 6:50:15 PM
    Author     : Castelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set scope="session" var="menu" value="home"></c:set>
        <%@include file="topMenu.jsp"%>
        <c:choose>
            <c:when test="${username == null}">
                <h1>Hello</h1>
            </c:when>
            <c:otherwise>
                <h1>Hello ${username}</h1>
            </c:otherwise>
        </c:choose>  
    </body>
</html>
