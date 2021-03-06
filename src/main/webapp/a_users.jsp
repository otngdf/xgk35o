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

        <%@ include file="/WEB-INF/jspf/a_navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>

            <br>
            <input class="form-control" id="myInput" type="text" placeholder="Keresés...">
            <br>

            <table class="table">
                <caption>Munkatársak 
                    <font color="red">
                    <c:out value="${sessionScope.modositva}" />
                    </font>
                    <c:remove var="modositva" scope="session" />
                </caption>
                <thead>
                <th>ID</th>
                <th>Felhasználónév</th>
                <th>Jogosultság</th>
                <th>Teljes Név</th>
                <th>Státusz</th>
                <th>Státusz módosítás</th>
                </thead>
                <tbody id="myTable">
                    <c:forEach items="${listUsers}" var="users">
                        <tr>
                            <td>${users.userID}</td>
                            <td>${users.userName}</td>
                            <td>${users.userRole}</td>
                            <td>${users.fullName}</td>
                            <td>${users.active}</td>
                            <td><a class="btn btn-danger" href="UsersActivateInactivateController.do?mid=${users.userID}&mactive=${users.active}">Módosítás</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> 



        </div>

        <div class="container">

            <form action="UsersCreateController.do" method="post" >
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

        <br/>

        <div class="container">

            <form action="UsersNewPasswordController.do" method="post" >
                <h4>Felhasználó jelszó módosítás:</h4>
                <br/>

                <select id="selectedUser" name="selectedUser">
                    <c:forEach var="users" items="${listUsers}">
                        <option value="${users.userName}">${users.userName}@${users.fullName}</option>
                    </c:forEach>
                </select>
                <br/>

                <br/>
                <input type="password" class="form-control" maxlength="12" placeholder="Új jelszó" name="newpass" required >
                <br/>

                <input type="submit" class="btn" value="Módosít" />

            </form>

        </div>

        <script>
            <%@ include file="/WEB-INF/js/tablesearch.js" %>
        </script>

    </body>
</html>