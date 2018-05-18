package servini.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Commande")
public class Commande implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int idCommande;
	private int numCommande;
	private java.util.Date dateCammande;
	private int montant;
	private int quantite;
	private boolean estRecu;

	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "idCommercant")
	private Commercant commercant;

	@ElementCollection
	@JoinTable(name = "ligneCommande", joinColumns = @JoinColumn(name = "idCommande"))
	public List<LigneCommande> ligneCommandeA;

	@ManyToOne
	@JoinColumn(name = "idlivreur")
	public Livreur livreur;

	@Transient
	public Evaluation evaluation;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Commande_Vente", joinColumns = {@JoinColumn (name = "idCommande", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "idVente", nullable = false, updatable = false) })
	public java.util.List<Vente> vente;

	public Commande() {

	}

	public Commande(int numCommande, Date dateCammande, int montant, int quantite, boolean estRecu) {
		super();
		this.numCommande = numCommande;
		this.dateCammande = dateCammande;
		this.montant = montant;
		this.quantite = quantite;
		this.estRecu = estRecu;
	}

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}

	public java.util.Date getDateCammande() {
		return dateCammande;
	}

	public void setDateCammande(java.util.Date dateCammande) {
		this.dateCammande = dateCammande;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public boolean isEstRecu() {
		return estRecu;
	}

	public void setEstRecu(boolean estRecu) {
		this.estRecu = estRecu;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client newClient) {
		if (this.client == null || !this.client.equals(newClient)) {
			if (this.client != null) {
				Client oldClient = this.client;
				this.client = null;
				oldClient.removeCommande(this);
			}
			if (newClient != null) {
				this.client = newClient;
				this.client.addCommande(this);
			}
		}
	}

	public Commercant getCommercant() {
		return commercant;
	}

	public void setCommercant(Commercant newCommercant) {
		if (this.commercant == null || !this.commercant.equals(newCommercant)) {
			if (this.commercant != null) {
				Commercant oldCommercant = this.commercant;
				this.commercant = null;
				oldCommercant.removeCommande(this);
			}
			if (newCommercant != null) {
				this.commercant = newCommercant;
				this.commercant.addCommande(this);
			}
		}
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur newLivreur) {
		if (this.livreur == null || !this.livreur.equals(newLivreur)) {
			if (this.livreur != null) {
				Livreur oldLivreur = this.livreur;
				this.livreur = null;
				oldLivreur.removeCommande(this);
			}
			if (newLivreur != null) {
				this.livreur = newLivreur;
				this.livreur.addCommande(this);
			}
		}
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation newEvaluation) {
		if (this.evaluation == null || !this.evaluation.equals(newEvaluation)) {
			if (this.evaluation != null)
				this.evaluation.setCommande(null);
			this.evaluation = newEvaluation;
			if (this.evaluation != null)
				this.evaluation.setCommande(this);
		}
	}

	public java.util.List<Vente> getVente() {
		if (vente == null)
			vente = new java.util.ArrayList<Vente>();
		return vente;
	}

	public java.util.Iterator getIteratorVente() {
		if (vente == null)
			vente = new java.util.ArrayList<Vente>();
		return vente.iterator();
	}

	public void setVente(java.util.List<Vente> newVente) {
		removeAllVente();
		for (java.util.Iterator iter = newVente.iterator(); iter.hasNext();)
			addVente((Vente) iter.next());
	}

	public void addVente(Vente newVente) {
		if (newVente == null)
			return;
		if (this.vente == null)
			this.vente = new java.util.ArrayList<Vente>();
		if (!this.vente.contains(newVente)) {
			this.vente.add(newVente);
			newVente.addCommande(this);
		}
	}

	public void removeVente(Vente oldVente) {
		if (oldVente == null)
			return;
		if (this.vente != null)
			if (this.vente.contains(oldVente)) {
				this.vente.remove(oldVente);
				oldVente.removeCommande(this);
			}
	}

	public void removeAllVente() {
		if (vente != null) {
			Vente oldVente;
			for (java.util.Iterator iter = getIteratorVente(); iter.hasNext();) {
				oldVente = (Vente) iter.next();
				iter.remove();
				oldVente.removeCommande(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", numCommande=" + numCommande + ", dateCammande=" + dateCammande
				+ ", montant=" + montant + ", quantite=" + quantite + ", estRecu=" + estRecu + "]";
	}
	
	

}
