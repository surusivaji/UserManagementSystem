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

@WebServlet("/removeUser")
public class DeleteUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String tempId = request.getParameter("userid");
		int userid = Integer.parseInt(tempId);
		
		IUserDao dao = new IUserDaoImpl();
		int isDelete = dao.deleteUserById(userid);
		
		if (isDelete!=0) {
			session.setAttribute("successMsg", "user removed successfully");
			response.sendRedirect("DisplayUsers.jsp");
		}
		else {
			session.setAttribute("failMsg", "something went wrong on the server");
			response.sendRedirect("DisplayUsers.jsp");
		}
		
	}

}
