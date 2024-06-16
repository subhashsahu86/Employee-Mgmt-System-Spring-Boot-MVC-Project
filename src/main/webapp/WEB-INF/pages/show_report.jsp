<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Report</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty empsInfo }">
			<table bgcolor="cyan" border="1" align="center">

				<tr bgcolor="yellow">
					<th>EMPNO</th>
					<th>ENAME</th>
					<th>JOB</th>
					<th>SALARY</th>
					<th>Operations</th>
				</tr>
				<c:forEach var="emp" items="${empsInfo }">
					<tr>
						<td>${emp.empno }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.sal }</td>
						
						<td><a href="edit?no=${emp.empno }"><img
								src="images/edit.png" width="40" height="40"></a> <a
							href="delete?no=${emp.empno }"><img src="images/delete.png"
								width="40" height="40" onclick="return confirm('Are you sure you want to delete this record')"></a></td>
					</tr>

				</c:forEach>

			</table>

		</c:when>
		<c:otherwise>
			<h1 style="color:red; text-align:center">Records Not Found</h1>
		</c:otherwise>

	</c:choose>
    <h2 style="color:green ; text-align:center">${resultMsg}</h2>
	<h1>
		<center>
			<a href="./"><img src="images/home.png" width="50" height="50"></a>
			&nbsp;&nbsp;&nbsp; <a href="register"><img src="images/add.png"
				width="50" height="50"></a>
		</center>
	</h1>

</body>
</html>