<%-- 
    Document   : index
    Created on : Feb 18, 2016, 3:07:07 PM
    Author     : Castelo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <title>Notas das Escolas de Samba</title>
    </head>
    <body>
        <form method="POST" action="home">
            <p>Número de escolas de samba: <input type="number" name="numEscolas" placeholder="Numero de escolas" autofocus="numEscolas"/></p>
            <p>Número de jurados: <input type="number" name="numJurados" placeholder="Numero de jurados"/></p>
            <p><input type="submit" value="ENVIAR"/></p>
            <input type="hidden" name="command" value="Command"/>
            <input type="hidden" name="action" value="submit"/>
        </form>
    </body>
</html>
