<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>

        <%@ include file="/WEB-INF/jspf/head.jspf" %>

        <title>Munkák</title>

    </head>

    <body>

        <%@ include file="/WEB-INF/jspf/mustadmin.jspf" %>

        <%@ include file="/WEB-INF/jspf/navbaradmin.jspf" %>

        <div class="container">
            <br/>
            <h3>${fullname}</h3>
        
            <table class="table">
		<caption>Munkák</caption>
		<thead>
			<th>ID</th>
			<th>Munkatárs</th>
                        <th>Ügyfélnév</th>
                        <th>Start</th>
                        <th>Stop</th>
			<th>Megjegyzés</th>
		</thead>
		<tbody>
			<c:forEach items="${listActivities}" var="activities">
				<tr>
					<td>${activities.activityID}</td>
					<td>${activities.uName}</td>
                                        <td>${activities.cName}</td>
					<td>${activities.start}</td>
                                        <td>${activities.stop}</td>
					<td>${activities.comment}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
