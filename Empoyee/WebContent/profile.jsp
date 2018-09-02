<!DOCTYPE html>

<%@page import="com.model.UserDetail"%>

<html>
<head>
<link rel="shortcut icon" type="image/png" href="images/img2.PNG" />
<link rel="stylesheet" href="css/headstyle.css" />
<link rel="stylesheet" href="css/profile.css" />
<script src="javascript/functions.js" type="text/javascript"></script>
<title>Profile</title>
</head>
<body>

	<div class="col-md-12">
		<div class="col-md-6">
			<img id="logo" src="images/img2.PNG" alt="Logo">
		</div>
		<div class="col-md-6" style="margin-top: 50px; text-align: center;">
			<a href="Friend">Friends</a> <a href="Logout">Logout</a><a
				href="ProfileEdit?emailid=">Profile</a>
		</div>
	</div>
	<hr />
	<br />
	<div>
		<div class="col-md-6" style="text-align: -webkit-center;">
			<div class="content-wrap">

				<%
					UserDetail userDetail = (UserDetail) request.getAttribute("UserDetail");
				%>
				<form action="ProfileUpdate" id="register_form" method="get">
					<h1 align="center">Profile</h1>
					<br />
					<table cellpadding="5">
						<tr>
							<th>First Name :</th>
							<td><input type="text" id="first_name" name="first_name"
								value="<%out.print(userDetail.getFirstName());%>" readonly /></td>
						</tr>

						<tr>
							<th>Last Name :</th>
							<td><input type="text" id="last_name" name="last_name"
								value="<%out.print(userDetail.getLastName());%>" readonly /></td>
						</tr>

						<tr>
							<th>Age :</th>
							<td><input type="number" id="age" name="age"
								value="<%out.print(userDetail.getAge());%>" readonly /></td>
						</tr>

						<tr>
							<th>Date of Birth :</th>
							<td><input type="date" id="dob" name="dob"
								value="<%out.print(userDetail.getDateOfBirth());%>" readonly /></td>
						</tr>

						<tr>
							<th>Email :</th>
							<td><input type="email" id="email" name="email"
								value="<%out.print(userDetail.getEmail());%>" readonly /></td>
						</tr>

						<tr>
							<th>Contact No. :</th>
							<td><input type="text" id="contact" name="contact"
								value="<%out.print(userDetail.getContact());%>" readonly /></td>
						</tr>

						<tr>
							<th>Company/Organisation :</th>
							<td><input type="text" id="organisation" name="organisation"
								value="<%out.print(userDetail.getOrganization());%>" readonly /></td>
						</tr>
						<%
							if (request.getParameter("emailid") == "") {
						%>
						<tr>
							<td><input type="button" value="Edit" onclick="editable()"></td>
							<td><input type='submit' id="submitbutton" value='update'
								name="update"></td>
						</tr>
						<%
							}
						%>
					</table>
				</form>
			</div>
		</div>


		<div class="col-md-6" style="text-align: -webkit-center;">
			<div class="content-wrap">
				<form action="ProfileImage" method="post"
					enctype="multipart/form-data">
					<h1 align="center">!! WELCOME !!</h1>
					<%
						if (userDetail.getImage() == null) {
					%>
					<br /> <img id="profileimg" src="images/profile.png"><br />
					<%
						}else{
					%>
					<br /> <img id="profileimg" src="images/<%out.print(userDetail.getImage());%>"><br />
					<%
						}
					%>
					<input type="file" name="image" /> <input type="submit"
						name="imageupload" />

					<h2 id="username">
						<%
							out.print(userDetail.getFirstName());
						%>
					</h2>
				</form>
			</div>
		</div>
	</div>
</body>
</html>