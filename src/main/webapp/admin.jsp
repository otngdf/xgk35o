<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Admin</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustadmin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbar.jspf" %>

        <div class="container">
            <h3>${fullname}</h3>
            <p>Kezdheted a munkát...</p>

        
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
