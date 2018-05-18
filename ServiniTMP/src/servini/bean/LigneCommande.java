package servini.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class LigneCommande implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(updatable = false)
	private double prix;

	@Column(updatable = false)
	private int qte;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Produit produitA;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Commande commandeB;

	public LigneCommande() {
		// TODO: implement
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int newQte) {
		qte = newQte;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double newPrix) {
		prix = newPrix;
	}

	public Produit getProduitA() {
		return produitA;
	}

	public void setProduitA(Produit produitA) {
		this.produitA = produitA;
	}

	public Commande getCommandeB() {
		return commandeB;
	}

	public void setCommandeB(Commande commandeB) {
		this.commandeB = commandeB;
	}
}
