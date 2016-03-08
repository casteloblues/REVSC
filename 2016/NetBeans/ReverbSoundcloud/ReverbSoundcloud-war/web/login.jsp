<%-- 
    Document   : login
    Created on : Mar 7, 2016, 6:53:54 PM
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
        <c:set scope="session" var="menu" value="login"></c:set>
        <%@include file="topMenu.jsp"%>
        <h1>LOGIN</h1>
        <c:if test="${errormsg != null && !''.equals(errormsg)}">
            <p class="msg">${errormsg}</p>
        </c:if>
        <c:set scope="session" var="errormsg" value=""></c:set>
        <form method="POST" action="home">
            <p><input text="text" name="username" placeholder="usuário"/></p>
            <p><input type="password" name="password" placeholder="senha"/></p>
            <p><input type="submit" value="Login"/></p>
            <input type="hidden" name="command" value="user"/>
            <input type="hidden" name="action" value="login"/>
        </form>
    </body>
</html>
