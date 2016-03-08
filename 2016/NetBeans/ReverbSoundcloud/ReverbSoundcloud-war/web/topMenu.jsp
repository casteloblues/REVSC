<%-- 
    Document   : topMenu
    Created on : Mar 7, 2016, 7:16:01 PM
    Author     : Castelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <nav class="topMenu"> 
            <ul>
                <a href="index.jsp"><li class="${menu.equals("home")?"selectedMenu":""}">Home</li></a>
                <c:choose> 
                    <c:when test="${username == null}">
                    <a href="login.jsp"><li class="${menu.equals("login")?"selectedMenu":""}">Login</li></a>
                    <a href="reverb.jsp"><li class="${menu.equals("reverb")?"selectedMenu":""}">Reverb</li></a>
                    </c:when>
                    <c:otherwise>
                    <!--<a href="pagina1.jsp"><li class="${menu.equals("pagina1")?"selectedMenu":""}">Pagina 1</li></a>-->
                    <a href="home?command=User&action=logout"><li>Logout</li></a>
                    </c:otherwise>
                </c:choose>
                 
            </ul>
        </nav>
    </body>
</html>
