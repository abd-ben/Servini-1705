
package servini.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class Achat implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(updatable = false)
	private int idAchat;
	@Column(updatable = false)
	private int quantite;
	@Column(updatable = false)
	private Date dateAchat;
	@Column(updatable = false)
	private int prix;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Fournisseur fournisseurA;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Produit produitB;

	public int getIdAchat() {
		return idAchat;
	}

	public void setIdAchat(int newIdAchat) {
		idAchat = newIdAchat;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int newQuantite) {
		quantite = newQuantite;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date newDateAchat) {
		dateAchat = newDateAchat;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int newPrix) {
		prix = newPrix;
	}

	public Achat() {
	}

}