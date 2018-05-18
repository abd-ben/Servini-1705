package servini.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vente")
public class Vente implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idVente;
	private Date dateVente;
	private int nbrVente;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "vente")
	public java.util.List<Commande> commande;

	public int getIdVente() {
		return idVente;
	}

	public void setIdVente(int newIdVente) {
		idVente = newIdVente;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date newDateVente) {
		dateVente = newDateVente;
	}

	public int getNbrVente() {
		return nbrVente;
	}

	public void setNbrVente(int newNbrVente) {
		nbrVente = newNbrVente;
	}

	public Vente() {
		// TODO: implement
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
			newCommande.addVente(this);
		}
	}

	public void removeCommande(Commande oldCommande) {
		if (oldCommande == null)
			return;
		if (this.commande != null)
			if (this.commande.contains(oldCommande)) {
				this.commande.remove(oldCommande);
				oldCommande.removeVente(this);
			}
	}

	public void removeAllCommande() {
		if (commande != null) {
			Commande oldCommande;
			for (java.util.Iterator iter = getIteratorCommande(); iter.hasNext();) {
				oldCommande = (Commande) iter.next();
				iter.remove();
				oldCommande.removeVente(this);
			}
		}
	}

}