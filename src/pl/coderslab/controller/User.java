package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Users;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public User() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			Users[] tempUsersArr = Users.loadAll();
			request.setAttribute("users", tempUsersArr);			
			request.getServletContext().getRequestDispatcher("/View/users.jsp").forward(request, response);
		} else {
			
			Users tempUser = null;
			if (!id.equals("0")) {
				tempUser = Users.loadById(id);
			} else {
				tempUser  = new Users();
			}
			request.setAttribute("user", tempUser);
			request.getServletContext().getRequestDispatcher("/View/usersModify.jsp").forward(request, response);			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String group = request.getParameter("group");
		Users tempUser = null;
		if (!id.equals("0")) {
			tempUser = Users.loadById(id).setEmail(email)
					.setPersonGroupId(Integer.parseInt(group))
					.setUserName(name);		
			if (password.length() > 1) {
				tempUser.setPassword(password);
			}
		} else {
			tempUser.setEmail(email)
			.setPassword(password)
			.setPersonGroupId(Integer.parseInt(group))
			.setUserName(name);
		}
		
		tempUser.SaveToDB();
		response.sendRedirect(request.getContextPath() + "/User");		

		
	}


}
