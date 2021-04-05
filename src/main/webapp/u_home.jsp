<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Menü</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustlogin.jspf" %>

        <%@ include file="/WEB-INF/jspf/u_navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>
            <p>Üdvözöllek ${user}!</p>
            <p>Adatbázis verzió: ${verzio}</p>
        </div>

        <div class="container">

            <form action="ModifyMyPasswordController.do" method="post" >
                <h4>Jelszó módosítás</h4>
                <br/>
                <input type="password" class="form-control" maxlength="12" placeholder="Új jelszó" name="newpass" required >
                <br/>
                <input type="submit" class="btn" value="Módosít" />
            </form>

            <br/>
            <font color="red">
            <c:out value="${sessionScope.modositva}" />
            </font>
            <c:remove var="modositva" scope="session" />
        </div>

    </body>
</html>
