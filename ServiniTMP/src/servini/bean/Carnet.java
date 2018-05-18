package servini.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Embeddable
public class Carnet implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(updatable = false)
	private double solde;

	@Column(updatable = false)
	private double reste;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Client clientA;

	@ManyToOne(fetch = FetchType.EAGER)
	@Transient
	public Commercant commercantB;

	public double getReste() {
		return reste;
	}

	public void setReste(double newReste) {
		reste = newReste;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClientA() {
		return clientA;
	}

	public void setClientA(Client clientA) {
		this.clientA = clientA;
	}

	public Commercant getCommercantB() {
		return commercantB;
	}

	public void setCommercantB(Commercant commercantB) {
		this.commercantB = commercantB;
	}

}
