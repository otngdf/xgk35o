<%@page import="org.zgdf.ea.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        welcome
        
        <%
            Users u = (Users)request.getAttribute("user");
            
               out.print(u);

            %>
        
    </body>
</html>
