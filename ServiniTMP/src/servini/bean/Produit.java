package servini.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduit;
	private String nomProduit;
	private String marque;
	private int description;
	private int prix;

	@ManyToOne
	@JoinColumn(name = "idCommercant")
	private Commercant commercant;

	@ManyToOne
	@JoinColumn(name = "idCategorie")
	private Categorie categorie;

	@Transient
	private java.util.List<Commande> commande;

	@ElementCollection
	@JoinTable(name = "ligneCommande", joinColumns = @JoinColumn(name = "idProduit"))
	public List<LigneCommande> ligneCommandeA;

	@ElementCollection
	@JoinTable(name = "Achat", joinColumns = @JoinColumn(name = "idProduit"))
	public List<Achat> achatA;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Produit_Stock", joinColumns = {
			@JoinColumn(name = "idProduit", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idStock", nullable = false, updatable = false) })
	public java.util.List<Stock> stock;

	public Produit() {
		super();
	}

	public Produit(String nomProduit, String marque, int description, int prix, Commercant commercant,
			Categorie categorie) {
		super();
		this.nomProduit = nomProduit;
		this.marque = marque;
		this.description = description;
		this.prix = prix;
		this.commercant = commercant;
		this.categorie = categorie;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getDescription() {
		return description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Commercant getCommercant() {
		return commercant;
	}

	public void setCommercant(Commercant newCommercant) {
		this.commercant = newCommercant;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie newCategorie) {
		if (this.categorie == null || !this.categorie.equals(newCategorie)) {
			if (this.categorie != null) {
				Categorie oldCategorie = this.categorie;
				this.categorie = null;
				oldCategorie.removeProduit(this);
			}
			if (newCategorie != null) {
				this.categorie = newCategorie;
				this.categorie.addProduit(this);
			}
		}
	}

	public java.util.List<Stock> getStock() {
		if (stock == null)
			stock = new java.util.ArrayList<Stock>();
		return stock;
	}

	public java.util.Iterator getIteratorStock() {
		if (stock == null)
			stock = new java.util.ArrayList<Stock>();
		return stock.iterator();
	}

	public void setStock(java.util.List<Stock> newStock) {
		removeAllStock();
		for (java.util.Iterator iter = newStock.iterator(); iter.hasNext();)
			addStock((Stock) iter.next());
	}

	public void addStock(Stock newStock) {
		if (newStock == null)
			return;
		if (this.stock == null)
			this.stock = new java.util.ArrayList<Stock>();
		if (!this.stock.contains(newStock)) {
			this.stock.add(newStock);
			newStock.addProduit(this);
		}
	}

	public void removeStock(Stock oldStock) {
		if (oldStock == null)
			return;
		if (this.stock != null)
			if (this.stock.contains(oldStock)) {
				this.stock.remove(oldStock);
				oldStock.removeProduit(this);
			}
	}

	public void removeAllStock() {
		if (stock != null) {
			Stock oldStock;
			for (java.util.Iterator iter = getIteratorStock(); iter.hasNext();) {
				oldStock = (Stock) iter.next();
				iter.remove();
				oldStock.removeProduit(this);
			}
		}
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", marque=" + marque
				+ ", description=" + description + ", prix=" + prix + "]";
	}

}
