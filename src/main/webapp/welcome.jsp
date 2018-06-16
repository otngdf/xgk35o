<%@page import="org.zgdf.ea.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webjars/bootstrap/4.1.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Welcome Page</title>
    </head>
    <body>


        <%
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            }
            //Users u = (Users) session.getAttribute("user");
            //out.print(u.getUserName());    
        %>
    <center>
        <br/>
        <h1>Hello World!</h1>
        Üdvözöllek ${user}

        <form action="LogoutController" >

            <input type="submit" value="Kilépés">
            </center>
        </form>


    </body>
</html>
