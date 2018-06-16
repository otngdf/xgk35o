<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
        <script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="webjars/popper/js/1.14.1/popper.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">-->
        <link rel="stylesheet" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Stop</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustlogin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

        <div class="container">
            <h3>Hello World!</h3>
            <p>Üdvözöllek ${user}! Most már fejezd be...</p>
        </div>    

    </body>
</html>
