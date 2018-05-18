package servini.service;

import java.util.List;

import servini.bean.Client;
import servini.bean.Commande;
import servini.dao.Service;

public class ClientService extends Service<Client> {
	
	public void addClient(Client o) {
		super.addObjet(o);
	}

	public List<Client> getAllClient() {
		return super.getAllObjets("Client");
	}

	public Client getClientById(int id) {
		return super.getById(Client.class, id);
	}

	public void deleteClient(Client o) {
		super.deleteObjet(Client.class, o.getIdPersonne());
	}

	public void updateClient(Client obj) {
		super.updateObjet(obj);
	}
	
	public List<Client> getAllClientByCommercant() {
		return super.getAllObjets("Client");
	}
}
