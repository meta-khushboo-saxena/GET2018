<!DOCTYPE html>

<%@page import="java.util.List"%>
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
			<a href="Friend">Friends</a> <a href="login.html">Logout</a><a
				href="ProfileEdit?emailid=">Profile</a>
		</div>
	</div>
	<hr />
	<br />
	<div>
		<div class="col-md-6" style="text-align: -webkit-center;">
			<div class="content-wrap">
				<h1 align="center">Friends</h1>
				<br />
				<table cellpadding="5" border="1">
					<%
						List<UserDetail> userList = (List<UserDetail>) request.getAttribute("UserList");
						for (UserDetail user : userList) {
					%>
					<tr>
						<td><a class="friendlink"
							href="ProfileEdit?emailid=<%out.print(user.getEmail());%>"> <%
 	out.print(user.getFirstName());
 %>
						</a></td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
		</div>
	</div>
</body>
</html>