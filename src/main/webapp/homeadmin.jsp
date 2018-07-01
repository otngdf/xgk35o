<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Menü</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustadmin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbaradmin.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>
            <p>Üdvözöllek ${user}!</p>
            <p>${verzio}</p>
        </div>    

    </body>
</html>
