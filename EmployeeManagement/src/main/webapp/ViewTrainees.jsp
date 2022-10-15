<%@page import="com.ideas2it.controller.TraineeController"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skill"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<title>View Trainees</title>
</head>
<body>
	<h1>View Trainees</h1>
	<input type="hidden" name="flag" value="viewTrainees">
	<table border="1" width="90%">
		<tr>
			<th>id</th>
			<th>Name</th>
			<th>bloodGroup</th>
			<th>dateOfBirth</th>
			<th>designation</th>
			<th>gender</th>
			<th>Phone Number</th>
			<th>email</th>
			<th>Date Of Joining</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		List<Trainee> trainees = (List<Trainee>) request.getAttribute("traineeList");
		for (Trainee trainee : trainees) {
		%>
		<tr>
			<td><%=trainee.getId()%></td>
			<td><%=trainee.getName()%></td>
			<td><%=trainee.getBloodGroup()%></td>
			<td><%=trainee.getDateOfBirth()%></td>
			<td><%=trainee.getDesignation()%></td>
			<td><%=trainee.getGender()%></td>
			<td><%=trainee.getPhoneNumber()%></td>
			<td><%=trainee.getEmail()%></td>
			<td><%=trainee.getDateOfJoining()%></td>
			<td><a href="SaveTrainee?flag=getTraineeById&id=<%=trainee.getId()%>">Update</a></td>
			<td><a href="SaveTrainee?flag=deleteTrainee&id=<%=trainee.getId()%>">Delete</a></td>
		</tr>
		<% } %>
	</table>
	<br />
	<a href="SaveTrainee.html">Add Trainee</a>
</body>
</html>
