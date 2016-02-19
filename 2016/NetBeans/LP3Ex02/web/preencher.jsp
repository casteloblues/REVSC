<%-- 
    Document   : preencher
    Created on : Feb 18, 2016, 4:23:05 PM
    Author     : Castelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Insira as notas</h1>
        <c:forEach begin="1" end="${numEsc}">
            <form method="POST" action="home">
                <c:forEach begin="1" end="${numJ}">
                    <input type="text" name="nota" placeholder="nota/>
                </c:forEach>
                <br>
            </c:forEach>
            <p><input type="submit" value="ENVIAR"/></p>
            <input type="hidden" name="command" value="Command"/>
            <input type="hidden" name="action" value="preenchido"/>
        </form>
    </body>
</html>
