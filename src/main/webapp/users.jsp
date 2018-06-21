<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Munkatársak</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustadmin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbaradmin.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>

            <table class="table">
                <caption>Munkatársak</caption>
                <thead>
                <th>ID</th>
                <th>Felhasználónév</th>
                <th>Jogosultság</th>
                <th>Teljes Név</th>
                <th>Státusz</th>
                <th>Státusz módosítás</th>
                </thead>
                <tbody>
                    <c:forEach items="${listUsers}" var="users">
                        <tr>
                            <td>${users.userID}</td>
                            <td>${users.userName}</td>
                            <td>${users.userRole}</td>
                            <td>${users.fullName}</td>
                            <td>${users.active}</td>
                            <td><a class="btn" href="UsersActivateInactivateController?mid=${users.userID}&mactive=${users.active}">Módosítás</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> 

        </div>

        <div class="container">

            <form action="UsersCreateController" >
                <h4>Új felhasználó rögzítése:</h4>
                <br/>
                <input type="text" class="form-control" maxlength="12" placeholder="Felhasználónév" name="uname" required >
                <br/>
                <input type="text" class="form-control" maxlength="24" placeholder="Teljes név" name="ufullname" required >
                <br/>
                <select class="form-control" name="urole">
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
                </select>
                <br/>
                <input type="password" class="form-control" maxlength="12" placeholder="Jelszó" name="upass" required >
                <br/>

                <input type="submit" class="btn" value="Rögzít" />

            </form>

        </div>

    </body>
</html>
