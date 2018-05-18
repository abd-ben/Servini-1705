package servini.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Livreur")
public class Livreur extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="idLivreur")
	public java.util.List<Commande> commande;

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
			newCommande.setLivreur(this);
		}
	}

	public void removeCommande(Commande oldCommande) {
		if (oldCommande == null)
			return;
		if (this.commande != null)
			if (this.commande.contains(oldCommande)) {
				this.commande.remove(oldCommande);
				oldCommande.setLivreur((Livreur) null);
			}
	}

	public void removeAllCommande() {
		if (commande != null) {
			Commande oldCommande;
			for (java.util.Iterator iter = getIteratorCommande(); iter.hasNext();) {
				oldCommande = (Commande) iter.next();
				iter.remove();
				oldCommande.setLivreur((Livreur) null);
			}
		}
	}

}