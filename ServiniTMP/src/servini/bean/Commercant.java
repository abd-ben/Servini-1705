package servini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@DiscriminatorValue("Commercant")
public class Commercant extends Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "idCommercant")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Commande> commande = new ArrayList<>();

	@Transient
	private Produit[] produit;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "client_commercant", joinColumns = {
			@JoinColumn(name = "idCommercant", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idClient", nullable = false, updatable = false) })
	private List<Client> client = new ArrayList<>();

	@ElementCollection
	@JoinTable(name = "Carnet", joinColumns = @JoinColumn(name = "idCommercant"))
	private List<Carnet> carnets;

	public Commercant() {

	}

	public Commercant(String nom, String prenom, String email, String adresse, int tel, String login, String password) {
		super(nom, prenom, email, adresse, tel, login, password);
		// TODO Auto-generated constructor stub
	}

	public List<Commande> getCommande() {
		if (commande == null)
			commande = new java.util.ArrayList<Commande>();
		return commande;
	}

	public java.util.Iterator getIteratorCommande() {
		if (commande == null)
			commande = new java.util.ArrayList<Commande>();
		return commande.iterator();
	}

	public void setCommande(java.util.List<Commande> newCommande) {
		removeAllCommande();
		for (java.util.Iterator iter = newCommande.iterator(); iter.hasNext();)
			addCommande((Commande) iter.next());
	}

	public void addCommande(Commande newCommande) {
		if (newCommande == null)
			return;
		if (this.commande == null)
			this.commande = new java.util.ArrayList<Commande>();
		if (!this.commande.contains(newCommande)) {
			this.commande.add(newCommande);
			newCommande.setCommercant(this);
		}
	}

	public void removeCommande(Commande oldCommande) {
		if (oldCommande == null)
			return;
		if (this.commande != null)
			if (this.commande.contains(oldCommande)) {
				this.commande.remove(oldCommande);
				oldCommande.setCommercant((Commercant) null);
			}
	}

	public void removeAllCommande() {
		if (commande != null) {
			Commande oldCommande;
			for (java.util.Iterator iter = getIteratorCommande(); iter.hasNext();) {
				oldCommande = (Commande) iter.next();
				iter.remove();
				oldCommande.setCommercant((Commercant) null);
			}
		}
	}

	public List<Client> getClient() {
		if (client == null)
			client = new ArrayList<Client>();
		return client;
	}

	public java.util.Iterator getIteratorClient() {
		if (client == null)
			client = new java.util.ArrayList<Client>();
		return client.iterator();
	}

	public void setClient(java.util.List<Client> newClient) {
		removeAllClient();
		for (java.util.Iterator iter = newClient.iterator(); iter.hasNext();)
			addClient((Client) iter.next());
	}

	public void addClient(Client newClient) {
		if (newClient == null)
			return;
		if (this.client == null)
			this.client = new java.util.ArrayList<Client>();
		if (!this.client.contains(newClient)) {
			this.client.add(newClient);
			newClient.addCommercant(this);
		}
	}

	public void removeClient(Client oldClient) {
		if (oldClient == null)
			return;
		if (this.client != null)
			if (this.client.contains(oldClient)) {
				this.client.remove(oldClient);
				oldClient.removeCommercant(this);
			}
	}

	public void removeAllClient() {
		if (client != null) {
			Client oldClient;
			for (java.util.Iterator iter = getIteratorClient(); iter.hasNext();) {
				oldClient = (Client) iter.next();
				iter.remove();
				oldClient.removeCommercant(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Commercant [toString()=" + super.toString() + "]";
	}

}
