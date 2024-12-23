<!doctype html>
<%@page import="org.siva.usermanagement.model.User"%>
<%@page import="org.siva.usermanagement.dao.IUserDao"%>
<%@page import="org.siva.usermanagement.dao.IUserDaoImpl"%>
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
</head>
<body class="bg-dark">
	<%
		String tempId = request.getParameter("userid");
		int userid = Integer.parseInt(tempId);
		IUserDao dao = new IUserDaoImpl();
		User user = dao.getUserById(userid);
	%>
	<div class="container">
		<div class="row d-flex justify-content-center mt-5">
			<div class="col-md-8">
				<div class="card">
					<div class="card-head bg-success text-light">
						<h1 class="fw-bold text-center p-2">EDIT USER</h1>
					</div>
					<div class="card-body">
						<form action="updateUserInformation" method="post">
							<div class="row">
								<div class="col-md-6">
									<input type="text" class="form-control" id="userid" name="userid" value="<%=user.getUser_Id() %>" autocomplete="off" required="required" hidden="true">
									<div class="form-group mt-2">
										<label for="firstName">First Name</label>
										<input type="text" class="form-control" id="firstName" name="firstname" value="<%=user.getFirst_Name() %>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<label for="lastName">Last Name</label>
										<input type="text" class="form-control" id="lastName" name="lastname" value="<%=user.getLast_Name() %>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<label for="email">Email ID</label>
										<input type="text" class="form-control" id="email" name="email" value="<%=user.getEmail_Id() %>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<label for="mobile">Mobile Number</label>
										<input type="text" class="form-control" id="mobile" name="mobile" value="<%= user.getMobile_Number() %>" autocomplete="off" required="required">
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group mt-2">
										<label for="emailid">Address</label>
										<input type="text" class="form-control" id="address" name="address" value="<%= user.getAddress() %>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<label for="gender">Gender</label>
										<input type="text" class="form-control" id="gender" name="gender" value="<%= user.getGender()%>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<label for="emailid">Password</label>
										<input type="text" class="form-control" id="password" name="password" value="<%= user.getPassword() %>" autocomplete="off" required="required">
									</div>
									<div class="form-group mt-2">
										<br>
										<input type="submit" value="UPDATE" class="btn btn-primary fw-bolder form-control" id="submit-btn">
									</div>
								</div>
							</div>
						</form>    
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