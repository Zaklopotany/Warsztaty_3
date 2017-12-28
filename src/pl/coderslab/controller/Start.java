package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;

@WebServlet("/")

public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Start() {

        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solNum = getServletContext().getInitParameter("number-solutions");
		int solNumInt = Integer.parseInt(solNum);
		Solution[] tempSolArr = Solution.loadAll(solNumInt);
		request.setAttribute("solArr", tempSolArr);
		getServletContext().getRequestDispatcher("/View/index.jsp").forward(request, response);		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
