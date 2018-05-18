package servini.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Evaluation")
public class Evaluation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int idEvaluation;
	private String commentaire;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCommande")
	public Commande commande;

	public int getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(int newIdEvaluation) {
		idEvaluation = newIdEvaluation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String newCommentaire) {
		commentaire = newCommentaire;
	}

	public Evaluation() {
		// TODO: implement
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande newCommande) {
		if (this.commande == null || !this.commande.equals(newCommande)) {
			if (this.commande != null)
				this.commande.setEvaluation(null);
			this.commande = newCommande;
			if (this.commande != null)
				this.commande.setEvaluation(this);
		}
	}

}