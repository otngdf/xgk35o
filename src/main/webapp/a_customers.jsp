<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Ügyfelek</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustadmin.jspf" %>

        <%@ include file="/WEB-INF/jspf/a_navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>

            <font color="red"> ${vanmunka} </font>

            <br>
            <input class="form-control" id="myInput" type="text" placeholder="Keresés...">
            <br>

            <table class="table">
                <caption>Ügyfelek
                    <font color="red">
                    <c:out value="${sessionScope.modositva}" />
                    </font>
                    <c:remove var="modositva" scope="session" />
                </caption>
                <thead>
                <th>ID</th>
                <th>Ügyfélnév</th>
                <th>Felhasznnálónév</th>
                <th>Irsz</th>
                <th>Város</th>
                <th>Cím</th>
                <th>Művelet</th>
                </thead>
                <tbody id="myTable">
                    <c:forEach items="${listCustomers}" var="customers">
                        <tr>
                            <td>${customers.customerID}</td>
                            <td>${customers.cName}</td>
                            <td>${customers.cUser}</td>
                            <td>${customers.cZip}</td>
                            <td>${customers.cCity}</td>
                            <td>${customers.cAddress}</td>
                            <td><a class="btn btn-danger" href="CustomersDeleteController.do?id=${customers.customerID}">Törlés</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>

        <div class="container">

            <form action="CustomersCreateController.do" method="post" >
                <h4>Új ügyfél rögzítése:</h4>
                <br/>
                <input type="text" class="form-control" maxlength="24" placeholder="Ügyfélnév" name="cname" required >
                <br/>
                <input type="text" class="form-control" maxlength="12" placeholder="Felhasználónév" name="cuser" required >
                <br/>
                <input type="password" class="form-control" maxlength="12" placeholder="Jelszó" name="cpass" required >
                <br/>
                <input type="text" class="form-control" maxlength="6" placeholder="Irsz" name="czip" required >
                <br/>
                <input type="text" class="form-control" maxlength="24" placeholder="Város" name="ccity" required >
                <br/>
                <input type="text" class="form-control" maxlength="24" placeholder="Cím" name="caddress" required >
                <br/>

                <input type="submit" class="btn" value="Rögzít" />


            </form>

        </div>

        <br/>

        <div class="container">

            <form action="CustomersNewPasswordController.do" method="post" >
                <h4>Ügyfél jelszó módosítás:</h4>
                <br/>

                <select id="selectedUser" name="selectedUser">
                    <c:forEach var="customers" items="${listCustomers}">
                        <option value="${customers.cUser}">${customers.cUser}@${customers.cName}</option>
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
