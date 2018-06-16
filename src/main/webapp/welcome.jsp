<%@page import="org.zgdf.ea.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <%
            response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
            
            if (session.getAttribute("user") == null) {
                response.sendRedirect("index.jsp");
            }
            //Users u = (Users) session.getAttribute("user");
            //out.print(u.getUserName());    
        %>

        Üdvözöllek ${user}

        <form action="LogoutController" >
            
            <input type="submit" value="Kilépés">

        </form>


    </body>
</html>
