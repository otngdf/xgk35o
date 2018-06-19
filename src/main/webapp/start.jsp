<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <style>
            .customWidth {
                width: 200px;
            }
        </style>

        <title>Start</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustlogin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>
            <p>Kezdheted a munkát...</p>

            <form action="ActivitiesController" >

                <b>Helyszín</b>
                <br/>
                <select class="form-control" name="customer" class="customWidth">
                    <c:forEach items="${listCustomers}" var="customers">
                        <option value="${customers.customerID}">${customers.cName}</option>
                    </c:forEach>
                </select>
                <br/>

                <b>Dátum</b>
                <br/>
                <input type="datetime-local" class="form-control" name="date" required class="customWidth">
                <br/>

                <b>Tevékenység</b>
                <br/>

                <textarea name="activity" class="form-control" placeholder="Megjegyzés" rows="4" class="customWidth"></textarea>

                <br/>
                <button type="submit" class="btn">Submit</button>
        </div>

    </form>



</body>
</html>
