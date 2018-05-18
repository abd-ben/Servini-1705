package servini.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "Fournisseur")
public class Fournisseur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idFournisseur;
	private String nomFournisseur;
	private String ville;
	private String adresse;
	private String tel;
	private String email;

	@ElementCollection
	@JoinTable(name = "Achat", joinColumns = @JoinColumn(name = "idFournisseur"))
	public List<Achat> achatA;

	public int getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(int newIdFournisseur) {
		idFournisseur = newIdFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String newNomFournisseur) {
		nomFournisseur = newNomFournisseur;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String newVille) {
		ville = newVille;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String newAdresse) {
		adresse = newAdresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String newTel) {
		tel = newTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}

	public Fournisseur() {
		// TODO: implement
	}

}