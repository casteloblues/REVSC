<%-- 
    Document   : Reverb
    Created on : Mar 7, 2016, 9:30:13 PM
    Author     : Castelo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <c:set scope="session" var="menu" value="login"></c:set>
        <%@include file="topMenu.jsp"%>
<!--
Example: search all listings
        
            <form action="https://reverb.com">
            <input type="hidden" name="_aid" value="[your affiliate id]">
            <input name="query" style="font-size: 1.10em; border: 1px solid #d2d2d2; background-color: #f2f2f0; padding: 0.42857rem 0.85714rem; -webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px; width: 400px;" placeholder="Find Gear on Reverb">
            <input type="image" alt="Submit Search" src="http://i.imgur.com/Xqd1zPL.png?1" style="height: 32px; margin-bottom: -10px">
        </form>-->

        <!-- 
        Example: search for a particular model
        -->
        <form action="home"> <!--https://reverb.com-->
            <input type="hidden" name="_aid" value="[your affiliate id]">
            <input type="hidden" name="model" value="les paul">
            <input name="query" style="font-size: 1.10em; border: 1px solid #d2d2d2; background-color: #f2f2f0; padding: 0.42857rem 0.85714rem; -webkit-border-radius:4px;-moz-border-radius:4px;border-radius:4px; width: 400px;" placeholder="Find Gear on Reverb">
            <input type="image" alt="Submit Search" src="http://i.imgur.com/Xqd1zPL.png?1" style="height: 32px; margin-bottom: -10px">
            <input type="hidden" name="command" value="User"/>
            <input type="hidden" name="action" value="reverbSearch"/>
        </form>
        
        <form method="POST" action="home">
            <p>Brand<input text="text" name="brand"/></p>
            <p>Model<input text="text" name="model"/></p>
            <p>Minimum Year<input text="text" name="year_min"/></p>
            <p>Maximum Year<input text="text" name="year_max"/></p>
            <p><input type="submit" value="search"/></p>
            <input type="hidden" name="command" value="User"/>
            <input type="hidden" name="action" value="reverbSearchDetail"/>
        </form>
    </body>
</html>