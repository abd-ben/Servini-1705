package servini.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import servini.bean.Client;
import servini.bean.Commercant;
import servini.bean.Personne;
import servini.service.ClientService;
import servini.service.CommercantService;
import servini.service.PersonneService;

/**
 * Servlet implementation class CountryInformation
 */
@WebServlet("/CountryInformation")
public class CountryInformation extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CountryInformation() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int countryCode = Integer.parseInt(request.getParameter("countryCode"));

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		Gson gson = new Gson();
		JsonObject myObj = new JsonObject();

		PersonneService ps = new PersonneService();
		Personne pinfo = ps.getPersonneById(countryCode);
		JsonElement pObj = gson.toJsonTree(pinfo);
		if (pinfo.getNom().equals(null)) {
			myObj.addProperty("success", false);
		} else {
			if(pinfo.getTypePersonne().equals("Commercant")) {
				CommercantService cs = new CommercantService();
				Commercant c = cs.getCommercantById(pinfo.getIdPersonne());
				pinfo = c;
			}else if (pinfo.getTypePersonne().equals("Client")) {
				ClientService cs = new ClientService();
				Client c = cs.getClientById(pinfo.getIdPersonne());
				pinfo = c;
			}
			myObj.addProperty("success", true);
		}
		myObj.add("pinfo", pObj);
		out.println(myObj.toString());

		out.close();

	}

}