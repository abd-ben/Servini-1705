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
@Table(name = "Stock")
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idStock;
	private int quantite;
	private Date dateAjoute;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "stock")
	public java.util.List<Produit> produit;

	public Stock() {

	}

	public Stock(int quantite, Date dateAjoute) {
		super();
		this.quantite = quantite;
		this.dateAjoute = dateAjoute;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int newIdStock) {
		idStock = newIdStock;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int newQuantite) {
		quantite = newQuantite;
	}

	public Date getDateAjoute() {
		return dateAjoute;
	}

	public void setDateAjoute(Date newDateAjoute) {
		dateAjoute = newDateAjoute;
	}

	public java.util.List<Produit> getProduit() {
		if (produit == null)
			produit = new java.util.ArrayList<Produit>();
		return produit;
	}

	public java.util.Iterator getIteratorProduit() {
		if (produit == null)
			produit = new java.util.ArrayList<Produit>();
		return produit.iterator();
	}

	public void setProduit(java.util.List<Produit> newProduit) {
		removeAllProduit();
		for (java.util.Iterator iter = newProduit.iterator(); iter.hasNext();)
			addProduit((Produit) iter.next());
	}

	public void addProduit(Produit newProduit) {
		if (newProduit == null)
			return;
		if (this.produit == null)
			this.produit = new java.util.ArrayList<Produit>();
		if (!this.produit.contains(newProduit)) {
			this.produit.add(newProduit);
			newProduit.addStock(this);
		}
	}

	public void removeProduit(Produit oldProduit) {
		if (oldProduit == null)
			return;
		if (this.produit != null)
			if (this.produit.contains(oldProduit)) {
				this.produit.remove(oldProduit);
				oldProduit.removeStock(this);
			}
	}

	public void removeAllProduit() {
		if (produit != null) {
			Produit oldProduit;
			for (java.util.Iterator iter = getIteratorProduit(); iter.hasNext();) {
				oldProduit = (Produit) iter.next();
				iter.remove();
				oldProduit.removeStock(this);
			}
		}
	}

}