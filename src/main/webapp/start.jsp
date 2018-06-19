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
            <h3>${fullname}</h3>
            <p>Kezdheted a munkát...</p>

            <form action="ActivitiesController" >

                <b>Helyszín</b>
                <br/>
                <select name="customer" class="customWidth">
                    <c:forEach items="${listCustomers}" var="customers">
                        <option value="${customers.customerID}">${customers.cName}</option>
                    </c:forEach>
                </select>
                <br/>
                
                <b>Dátum</b>
                <br/>
                <input type="datetime-local" name="date" required class="customWidth">
                <br/>
                
                <b>Tevékenység</b>
                <br/>

                <textarea name="activity" placeholder="Megjegyzés" rows="4" class="customWidth"></textarea>

                <br/>
                <button type="submit" class="btn">Submit</button>
        </div>

    </form>
            
            <table class="table">
		<caption>Ügyfelek</caption>
		<thead>
			<th>iD</th>
			<th>Ügyfélnév</th>
                        <th>Irsz</th>
                        <th>Város</th>
                        <th>Cím</th>
			<th>Művelet</th>
		</thead>
		<tbody>
			<c:forEach items="${listCustomers}" var="customers">
				<tr>
					<td>${customers.customerID}</td>
					<td>${customers.cName}</td>
                                        <td>${customers.cZip}</td>
					<td>${customers.cCity}</td>
                                        <td>${customers.cAddress}</td>
					<td><a class="btn" href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
