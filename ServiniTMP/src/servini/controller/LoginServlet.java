package servini.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servini.bean.Client;
import servini.bean.Commercant;
import servini.bean.Personne;
import servini.service.CommercantService;
import servini.service.PersonneService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();

		PersonneService ps = new PersonneService();
		Personne p = ps.getPersonneByLogin(username, password);

		if (p != null) {
			request.getSession().setAttribute("curent", p);
			if (p.getTypePersonne().equals("Commercant")) {
				CommercantService cs = new CommercantService();
				
				Commercant c = cs.getCommercantById(p.getIdPersonne());
				request.getSession().setAttribute("Commercant", c);
				
				response.sendRedirect("admin/client.jsp?usr=Commercant");
			}
		} else {
			response.sendRedirect("admin/login.jsp?msg=erreur");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
