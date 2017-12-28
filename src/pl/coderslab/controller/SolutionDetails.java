package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;

@WebServlet("/solDetail")
public class SolutionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SolutionDetails() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int solId = Integer.parseInt(request.getParameter("id"));
    	Solution tempSol = Solution.loadById(solId);
    	request.setAttribute("solution", tempSol);
    	request.getServletContext().getRequestDispatcher("/View/solDetail.jsp").forward(request, response);
    	
	}
	
    

}
