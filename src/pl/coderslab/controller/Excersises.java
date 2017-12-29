package pl.coderslab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Excersise;
@WebServlet("/Excersises")
public class Excersises extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Excersise[] tempExceArr = Excersise.loadAll();
		request.setAttribute("excersise", tempExceArr);
		request.getServletContext().getRequestDispatcher("/View/excersises.jsp").forward(request, response);
		
	}

}
