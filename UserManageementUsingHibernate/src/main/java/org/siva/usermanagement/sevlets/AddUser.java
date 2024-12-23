package org.siva.usermanagement.sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.siva.usermanagement.dao.IUserDao;
import org.siva.usermanagement.dao.IUserDaoImpl;
import org.siva.usermanagement.model.User;

@WebServlet("/saveUserInformation")
public class AddUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setFirst_Name(firstname);
		user.setLast_Name(lastname);
		user.setEmail_Id(email);
		user.setMobile_Number(mobile);
		user.setAddress(address);
		user.setGender(gender);
		user.setPassword(password);
		
		IUserDao dao = new IUserDaoImpl();
		boolean isSave = dao.insertUser(user);
		if (isSave) {
			session.setAttribute("successMsg", "user added successfully");
			response.sendRedirect("DisplayUsers.jsp");
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			response.sendRedirect("DisplayUsers.jsp");
		}
	}

}
