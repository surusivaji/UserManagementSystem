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

@WebServlet("/updateUserInformation")
public class UpdateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String userid = request.getParameter("userid");
		Integer id = Integer.parseInt(userid);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		
		IUserDao dao = new IUserDaoImpl();
		int updateUserInformation = dao.updateUserInformation(id, firstname, lastname, mobile, email, gender, address, password);
		if (updateUserInformation!=0) {
			session.setAttribute("successMsg", "user information updated successfully");
			response.sendRedirect("DisplayUsers.jsp");
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			response.sendRedirect("DisplayUsers.jsp");
		}
		
		
	}

}
