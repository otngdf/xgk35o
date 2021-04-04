<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html">
    <head>
        <title>IT Support</title>
        <%@ include file="/WEB-INF/jspf/head.jspf" %>
    </head>
    <body>

        <div class="jumbotron text-center">
            <h1>IT Support</h1>
            <p>Karbantartás, vírusírtás, tanácsadás, folyamatos felügyelet, és egyedi megrendelések.</p>
            <p>Kapcsolat: info@manit.hu</p>
        </div>

        <div class="container">
            <div class="row text-center">
                <div class="col-sm-4 mx-auto">
                    <h3><a class="btn btn-secondary" href="login.jsp">Munkatársak</a></h3>
                    <p>Tevékenység rögzítéséhez jelentkezz be.</p>

                </div>
                <div class="col-sm-4 mx-auto">
                    <h3><a class="btn btn-secondary" href="c_login.jsp">Ügyfelek</a></h3>
                    <p>A munkák megtekintéséhez jelentkezzen be.</p>

                </div>

            </div>
        </div>

    </body>
</html>
