<%@page import="com.ideas2it.model.Trainer"%>
<!DOCTYPE html>
<html>

<head>
<title>UPDATE TRAINER</title>
</head>
<h1>UPDATE TRAINER</h1>
<body style="margin-left: 38%">
    <form action="TrainerController" method="post" > 
    <input type="hidden" name="flag" value="updateTrainer"> 
    <%  
      Trainer trainer = (Trainer)request.getAttribute("trainer");
     %> 
        <lable>ID  : <%=trainer.getId()%></label><br>  
        <input type="hidden" name="id" value="<%=trainer.getId()%>">  
		<label>Enter Name :</label>
		 <input type="text" name="name" value = "<%=trainer.getName()%>"><br>
		<label>Enter Blood Group :</label>
		 <select name="bloodGroup" value = "<%=trainer.getBloodGroup()%>"
			style="width: 120px">
			<option>A+</option>
			<option>A-</option>
			<option>B+</option>
			<option>B+</option>
			<option>AB+</option>
			<option>AB-</option>
			<option>O+</option>
			<option>O</option>
		</select><br> <label for="dateOfBirth"> Date of birth :</label>
		<input type="date" id="dateOfBirth" name="dateOfBirth" value = "<%=trainer.getDateOfBirth()%>"><br>
	    <label>Enter Designation :</label> <input type="text" name="designation" value = "<%=trainer.getDesignation()%>"><br>
		<label>Select Gender :</label> <input type="radio" name="gender"
			value="MALE">MALE <input type="radio" name="gender"
			value="FEMALE">FEMALE <input type="radio" name="gender"
			value="OTHERS">OTHERS<br>
	    <label>Enter Phone number :</label> <input type="text" name="phoneNumber" value = "<%=trainer.getPhoneNumber()%>"><br>
	    <label>Enter email :</label> <input type="text" name="email" value = "<%=trainer.getEmail()%>"><br>
        <label>Enter Training Since(Year)         :</label>  
	    <input type="text" name="trainingSince" value = "<%=trainer.getTrainingSince()%>"><br>
		<button type="submit">Update Trainer</button>
		</form>
</body>

</html>