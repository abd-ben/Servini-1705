package servini.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private transient java.util.List<Commercant> commercant;
	@Transient
	private transient java.util.List<Commande> commande;
	
	@ElementCollection
	@JoinTable(name="Carnet", joinColumns=@JoinColumn(name="idClient"))
	private transient List<Carnet> carnets;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nom, String prenom, String email, String adresse, int tel, String login, String password) {
		super(nom, prenom, email, adresse, tel, login, password);
		// TODO Auto-generated constructor stub
	}

	public java.util.List<Commercant> getCommercant() {
		if (commercant == null)
			commercant = new java.util.ArrayList<Commercant>();
		return commercant;
	}

	public java.util.Iterator getIteratorCommercant() {
		if (commercant == null)
			commercant = new java.util.ArrayList<Commercant>();
		return commercant.iterator();
	}

	public void setCommercant(java.util.List<Commercant> newCommercant) {
		removeAllCommercant();
		for (java.util.Iterator iter = newCommercant.iterator(); iter.hasNext();)
			addCommercant((Commercant) iter.next());
	}

	public void addCommercant(Commercant newCommercant) {
		if (newCommercant == null)
			return;
		if (this.commercant == null)
			this.commercant = new java.util.ArrayList<Commercant>();
		if (!this.commercant.contains(newCommercant)) {
			this.commercant.add(newCommercant);
			newCommercant.addClient(this);
		}
	}

	public void removeCommercant(Commercant oldCommercant) {
		if (oldCommercant == null)
			return;
		if (this.commercant != null)
			if (this.commercant.contains(oldCommercant)) {
				this.commercant.remove(oldCommercant);
				oldCommercant.removeClient(this);
			}
	}

	public void removeAllCommercant() {
		if (commercant != null) {
			Commercant oldCommercant;
			for (java.util.Iterator iter = getIteratorCommercant(); iter.hasNext();) {
				oldCommercant = (Commercant) iter.next();
				iter.remove();
				oldCommercant.removeClient(this);
			}
		}
	}

	public java.util.List<Commande> getCommande() {
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
			newCommande.setClient(this);
		}
	}

	public void removeCommande(Commande oldCommande) {
		if (oldCommande == null)
			return;
		if (this.commande != null)
			if (this.commande.contains(oldCommande)) {
				this.commande.remove(oldCommande);
				oldCommande.setClient((Client) null);
			}
	}

	public void removeAllCommande() {
		if (commande != null) {
			Commande oldCommande;
			for (java.util.Iterator iter = getIteratorCommande(); iter.hasNext();) {
				oldCommande = (Commande) iter.next();
				iter.remove();
				oldCommande.setClient((Client) null);
			}
		}
	}

	@Override
	public String toString() {
		return "Client [toString()=" + super.toString() + "]";
	}
	
	
}
