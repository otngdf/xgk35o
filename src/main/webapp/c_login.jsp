<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Belépés</title>
    </head>
    <body>

        <br/>

        <div class="container">
            <form action="LoginCustomersController.do" method="post">
                <h3>Munkaidő nyilvántartó rendszer - Ügyfélportál</h3>
                <br/>
                <input type="text" class="form-control" maxlength="12" placeholder="Felhasználónév" name="uname" required autofocus >
                <br/>
                <input type="password" class="form-control" maxlength="12" placeholder="Jelszó" name="pwd" required >
                <br/>

                <input type="submit" class="btn" value="Belépés" />

            </form>

            <br/>
            <font color="red"> ${hibasuser} </font>

        </div>

        <%
            session.removeAttribute("hibasuser");
        %>

        <%@ include file="/WEB-INF/jspf/footer.jspf" %>

    </body>
</html>
