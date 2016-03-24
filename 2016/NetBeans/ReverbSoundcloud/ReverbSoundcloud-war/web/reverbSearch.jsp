<%-- 
    Document   : reverbSearch
    Created on : Mar 8, 2016, 2:31:50 PM
    Author     : Castelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="topMenu.jsp"%>
    </head>
    <body>
        <h1>Search Results</h1>
        <%--<c:redirect url="https://reverb.com/?query=${queryC}&x=11&y=5"/>--%>
        <!--<p><input type="submit" value="GO"/></p>-->
        <%--<c:redirect url="https://reverb.com/api/listings/all?make=${brand}&model=${model}&year_max=${year_max}&year_min=${year_min}&page=1&per_page=50"></c:redirect>--%>

        <c:forEach items="${instList}" var="inst">
            <!--<input type="image" src="${inst.getPhoto()}" style="height: 300px; margin-bottom: -10px">-->
            <!--<p><c:out value="${inst.title}"/></p>-->
            <p><c:out value="${inst.title}"/></p>
        </c:forEach>
    </body>
</html>