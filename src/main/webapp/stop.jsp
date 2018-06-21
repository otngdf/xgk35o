<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Stop</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustlogin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>

            <table class="table">
                <caption>Megkezdett munka</caption>
                <thead>

                <th>Ügyfélnév</th>
                <th>Start</th>
                <th>Megjegyzés</th>
                </thead>
                <tbody>
                    <c:forEach items="${listActivities}" var="activities">
                        <tr>
                            <td>${activities.cName}</td>
                            <td>${activities.start}</td>
                            <td>${activities.comment}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>    

        <div class="container">

            Állítsd be, mikor végeztél:
            <br/><br/>

            <form action="ActivitiesUserDoStopController" >


                <input type="datetime-local" class="form-control" name="date" required >
                <br/>

                
                <button type="submit" class="btn">Lezár</button>


            </form>

        </div>

    </body>
</html>
