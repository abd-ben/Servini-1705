package servini.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import servini.bean.Client;
import servini.bean.Commande;
import servini.bean.Commercant;
import servini.bean.Personne;
import servini.bean.Produit;
import servini.service.ClientService;
import servini.service.CommercantService;
import servini.service.PersonneService;

public class Test {

	public static void main(String[] args) {

		/*
		 * CategorieService cs = new CategorieService(); Categorie c = new
		 * Categorie("categorie1", "description1"); cs.addCategorie(c);
		 * 
		 * CommercantService cc = new CommercantService(); Commercant cm = new
		 * Commercant("nom", "prenom", "email", "adresse", 061021, "login",
		 * "password"); cc.addObjet(cm);
		 * 
		 * ProduitService ps = new ProduitService(); Produit p = new
		 * Produit("Produit1", "marque1", 121, 131, cm, c);
		 * 
		 * Date d = new Date(); d.getTime();
		 * 
		 * Stock s = new Stock(3, d);
		 * 
		 * p.addStock(s);
		 * 
		 * ps.addProduit(p);
		 * 
		 * StockService SS = new StockService(); SS.addStock(s);
		 * 
		 * 
		 * PersonneService ps = new PersonneService(); Personne p =
		 * ps.getPersonneByLogin("a", "a");
		 * 
		 * System.out.println(p.toString());
		 
		*/
		
		CommercantService cs = new CommercantService();
		Commercant c = cs.getCommercantById(6);
		
		System.out.println(c.toString());
		
		List<Client> lci = c.getClient();
		
		for (Client client : lci) {
			System.out.println(client.toString());
		}
		
		System.out.println();
		
		ClientService cs1 = new ClientService();
		Client c1 = cs1.getClientById(15);
		
		List<Commercant> lcm = c1.getCommercant();
		
		for (Commercant commercant : lcm) {
			System.out.println(commercant.toString());
		}
		
		
	}

}
