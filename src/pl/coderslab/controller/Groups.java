package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.UserGroup;

@WebServlet("/Groups")
public class Groups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Groups() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			UserGroup[] tempUGArr = UserGroup.loadAll();
			request.setAttribute("groups", tempUGArr);
			request.getServletContext().getRequestDispatcher("/View/groups.jsp").forward(request, response);
		} else {
			int idInt = Integer.parseInt(id);
			UserGroup tempUG = null;
			if (idInt != 0) {
				tempUG = UserGroup.loadById(Integer.parseInt(id));
			} else {
				tempUG = new UserGroup();
			}
			request.setAttribute("userGroup", tempUG);				
			request.getServletContext().getRequestDispatcher("/View/groupModify.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		UserGroup modifyGroup = null;
		if (id != 0 ) {
			modifyGroup = UserGroup.loadById(id).setName(name);;			
		} else {
			modifyGroup = new UserGroup().setName(name);
		}
		modifyGroup.SaveToDB();
		response.sendRedirect(request.getContextPath() + "/Groups");		
	}

}
