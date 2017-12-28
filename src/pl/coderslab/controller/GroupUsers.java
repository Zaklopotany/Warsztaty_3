package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Users;
@WebServlet("/groupDetails")
public class GroupUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GroupUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupId = Integer.parseInt(request.getParameter("id"));
		Users[] usersGroup = Users.loadAllByGroupId(groupId);
		request.setAttribute("users", usersGroup);
		request.getServletContext().getRequestDispatcher("/View/groupDetail.jsp").forward(request, response);
		
	}
	

}
