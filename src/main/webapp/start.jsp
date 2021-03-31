<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Start</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustlogin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>

            <form action="ActivitiesController.do" >

                <b>Helyszín</b>
                <br/>
                <select class="form-control" name="customer" >
                    <c:forEach items="${listCustomers}" var="customers">
                        <option value="${customers.customerID}">${customers.cName}</option>
                    </c:forEach>
                </select>
                <br/>

                <b>Dátum</b>
                <br/>
                <input type="datetime-local" class="form-control" name="date" required >
                <br/>

                <b>Tevékenység</b>
                <br/>

                <textarea name="activity" class="form-control" placeholder="Megjegyzés" rows="4" ></textarea>

                <br/>
                <button type="submit" class="btn">Küld</button>

                <br/><br/>
                <font color="red"> ${vanbefejezetlen} </font>


            </form>

        </div>

    </body>
</html>
