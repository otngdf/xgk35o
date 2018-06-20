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
                        <th>Aktív</th>
                        <th>Művelet</th>
		</thead>
		<tbody>
			<c:forEach items="${listUsers}" var="users">
				<tr>
					<td>${users.userID}</td>
					<td>${users.userName}</td>
                                        <td>${users.userRole}</td>
                                        <td>${users.fullName}</td>
                                        <td>${users.active}</td>
                                        <td><a class="btn" href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
