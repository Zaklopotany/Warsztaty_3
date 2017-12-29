package pl.coderslab.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Excersise;
import pl.coderslab.model.Solution;

@WebServlet("/ExcersiseDetail")
public class ExcersiseDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Solution[] tempSolArr = Solution.loadAllByExcersiseId(id);
		Excersise tempExce = Excersise.loadById(id);
		
		request.setAttribute("solution", tempSolArr);
		request.setAttribute("excersise", tempExce);
		request.getServletContext().getRequestDispatcher("/View/excersiseDetail.jsp").forward(request, response);
	}
}
