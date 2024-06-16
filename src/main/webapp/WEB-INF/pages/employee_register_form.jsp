<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
   <h1 style="color:blue;text-align:center">Employee Registration Form</h1>
   <frm:form modelAttribute="emp">
   <table bordar="0" align="center" bgcolor="cyan" >
     <tr>
       <td>Employee Name : </td>
       <td><frm:input path="ename"/></td>
     </tr>
      <tr>
       <td>Employee Job : </td>
       <td><frm:input path="job"/></td>
     </tr>
      <tr>
       <td>Employee Salary : </td>
       <td><frm:input path="sal"/></td>
     </tr>
     <tr>
     <td><input type="submit" value="register">
   
   </table> 
   
   </frm:form>
   
</body>
</html>