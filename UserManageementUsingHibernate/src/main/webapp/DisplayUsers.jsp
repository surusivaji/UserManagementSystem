<!doctype html>
<%@page import="org.siva.usermanagement.model.User"%>
<%@page import="java.util.List"%>
<%@page import="org.siva.usermanagement.dao.IUserDaoImpl"%>
<%@page import="org.siva.usermanagement.dao.IUserDao"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<style type="text/css">
	#heading {
		text-shadow: 2px 1px #000;
		color: #FF0032 !important;
		font-weight: 700 !important;
		word-spacing: 5px;
	}
	#edit {
		background-color: #4F1787 !important;
		border: 1px solid #4F1787 !important;
	}
	#remove {
		background-color: #FF0032 !important;
		border: 1px solid #FF0032 !important;
	}
</style>
</head>
<body class="bg-dark">
	<div class="container">
		<div class="row d-flex justify-content-center">
			<div class="col-md-12">
				<div class="card mt-3">
					<div class="card-head">
						<h1 class="text-center f-2 fw-bold text-danger" id="heading">USER MANAGEMENT SYSTEM</h1>
						<%
							String successMsg = (String) session.getAttribute("successMsg");
							if (successMsg!=null) 
							{%>
								<p class="text-center f-5 text-success"><%=successMsg %>...!!!</p>	
							<% session.removeAttribute("successMsg");
							}
							String failMsg = (String) session.getAttribute("failMsg");
							if (failMsg!=null) 
							{%>
								<p class="text-center f-5 text-danger"><%=failMsg %>...!!!</p>
							<% session.removeAttribute("failMsg");
							}	
						%>
						<a class="btn-primary btn m-1" href="AddUser.jsp">create user</a>
					</div>
					<div class="card-body">
						<table class="table table-stripped table-hover table-responsive">
							<tr class="table-success">
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email ID</th>
								<th>Mobile Number</th>
								<th>Gender</th>
								<th>Password</th>
								<th>Address</th>
								<th>Action</th>
							</tr>
							<%
							IUserDao dao = new IUserDaoImpl();
							List<User> users = dao.displayAllUsers();
							for (User user : users) {
							%>
							<tr>
								<td><%=user.getUser_Id()%></td>
								<td><%=user.getFirst_Name()%></td>
								<td><%=user.getLast_Name()%></td>
								<td><%=user.getEmail_Id()%></td>
								<td><%=user.getMobile_Number()%></td>
								<td><%=user.getGender()%></td>
								<td><%=user.getPassword()%></td>
								<td><%=user.getAddress()%></td>
								<td><a href="EditUser.jsp?userid=<%=user.getUser_Id() %>" class="btn btn-success btn-sm" id="edit">Edit</a> 
								<a href="removeUser?userid=<%=user.getUser_Id() %>" class="btn btn-danger btn-sm" id="remove">Remove</a></td>
							</tr>
							<%
							}
							%>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>