<%@page import="com.ideas2it.controller.TrainerController"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>View Trainers</title>
</head>
<body>
	<h1>View Trainers</h1>
	<input type="hidden" name="flag" value="viewTrainers">
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
			<th>Training Since</th>
			<th>Update</th>
		    <th>Delete</th>
		</tr>
		<%
		List<Trainer> trainers = (List<Trainer>) request.getAttribute("trainerList");
		for (Trainer trainer : trainers) {
		%>
		<tr>
			<td><%=trainer.getId()%></td>
			<td><%=trainer.getName()%></td>
			<td><%=trainer.getBloodGroup()%></td>
			<td><%=trainer.getDateOfBirth()%></td>
			<td><%=trainer.getDesignation()%></td>
			<td><%=trainer.getGender()%></td>
			<td><%=trainer.getPhoneNumber()%></td>
			<td><%=trainer.getEmail()%></td>
			<td><%=trainer.getTrainingSince()%></td>
			<td><a href="TrainerController?flag=getTrainerById&id=<%=trainer.getId()%>">Update</a></td>
			<td><a href="TrainerController?flag=deleteTrainer&id=<%=trainer.getId()%>">Delete</a></td>
		</tr>
		<% } %>
	</table>
	<br />
	<a href="SaveTrainer.html">Add Trainer</a>
</body>
</html>
