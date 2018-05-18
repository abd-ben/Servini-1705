package servini.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCategorie;
	@Column(name = "nomCategorie")
	private String nomCategorie;
	@Column(name = "description")
	private String description;

	@Transient
	public ArrayList<Produit> produit;

	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Produit> getProduit() {
		if (produit == null)
			produit = new ArrayList<Produit>();
		return produit;
	}

	public Iterator getIteratorProduit() {
		if (produit == null)
			produit = new ArrayList<Produit>();
		return produit.iterator();
	}

	public void setProduit(Collection<Produit> newProduit) {
		removeAllProduit();
		for (Iterator iter = newProduit.iterator(); iter.hasNext();)
			addProduit((Produit) iter.next());
	}

	public void addProduit(Produit newProduit) {
		if (newProduit == null)
			return;
		if (this.produit == null)
			this.produit = new ArrayList<Produit>();
		if (!this.produit.contains(newProduit)) {
			this.produit.add(newProduit);
			newProduit.setCategorie(this);
		}
	}

	public void removeProduit(Produit oldProduit) {
		if (oldProduit == null)
			return;
		if (this.produit != null)
			if (this.produit.contains(oldProduit)) {
				this.produit.remove(oldProduit);
				oldProduit.setCategorie((Categorie) null);
			}
	}

	public void removeAllProduit() {
		if (produit != null) {
			Produit oldProduit;
			for (Iterator iter = getIteratorProduit(); iter.hasNext();) {
				oldProduit = (Produit) iter.next();
				iter.remove();
				oldProduit.setCategorie((Categorie) null);
			}
		}
	}

}
