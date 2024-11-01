package vn.edu.eiu.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.eiu.database.JdbcDbConnector;



/**
 * Servlet implementation class DatabaseController
 */
@WebServlet("/connecting")
public class DatabaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/index.jsp";
		JdbcDbConnector jdc = new JdbcDbConnector();
		Connection c = jdc.getConnection();
		String urlDatabase = c.toString();
		request.setAttribute("urlDatabase",urlDatabase);
		RequestDispatcher rD = request.getServletContext().getRequestDispatcher(url);
		rD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
