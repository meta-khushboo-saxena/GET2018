<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add employee</title>
</head>
<body>
<form>
<table>
<tr>
<td>First Name:</td>
<td><input type="text" id="firstName" name="firstName" /></td>
</tr>
<tr>
<td>Middle Name:</td>
<td><input type="text" id="middleName" name="middleName" /></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" id="lastName" name="lastName" /></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" id="email" name="email" /></td>
</tr>
<tr>
<td>Date Of Birth:</td>
<td><input type="Date" id="dateOfBirth" name="dateOfBirth" /></td>
</tr>
<tr>
<td>Gender:</td>
<td><input type="radio" id="gender" name="gender" value="male" />Male</td>
<td><input type="radio" id="gender" name="gender" value="female" />Female</td>
</tr>
<tr>
<td>Date Of Joining:</td>
<td><input type="Date" id="dateOfJoining" name="dateOfJoining" /></td>
</tr>
<tr>
<td>Reporting Manager:</td>
<td><input type="text" id="reportingManager" name="reportingManager" /></td>
</tr>
<tr>
<td>Team Lead:</td>
<td><input type="text" id="teamLead" name="teamLead" /></td>
</tr>
<tr>
<td>Project Id:</td>
<td><input type="text" id="projectId" name="projectId" /></td>
</tr>
<tr>
<td><input type="submit" value="submit" /></td>
</tr>
</table>
</form>
</body>
</html>