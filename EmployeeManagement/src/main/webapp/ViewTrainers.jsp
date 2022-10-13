<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
</head>  
<body>  
  
<%@page import="com.ideas2it.controller.TrainerController"%>
<%@page import="com.ideas2it.model.Trainer"%>  
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<h1>View Trainers</h1>  
  
<%  
request.getAttribute("trainers"); 
%>  
  
<table border="1" width="90%">  
<tr><th>id</th>
<th>Name</th>
<th>bloodGroup</th>
<th>dateOfBirth</th>  
<th>designation</th>
<th>gender</th>
<th>Phone Number</th>
<th>email</th>
<th>Training Since</th>
<th>Edit</th>
<th>Delete</th></tr>
  
<c:forEach items="${trainers}" var="trainer">  
<tr><td>${trainer.getId()}</td>
<td>${trainer.getName()}</td>
<td>${trainer.getBloodGroup()}</td> 
<td>${trainer.getDateOfBirth()}</td>
<td>${trainer.getGender()}</td>
<td>${trainer.getGender}</td>
<td>${trainer.getPhoneNumber}</td>
<td>${trainer.getEmail}</td>
<td>${trainer.getTrainingSince}</td>
<td><a href="UpdateTrainer.jsp?id=${trainer.getId()}">Edit</a></td>  
<td><a href="DeleteTrainer.jsp?id=${trainer.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="SaveTrainer.html">Add Trainer</a>  
  
</body>  
</html> 