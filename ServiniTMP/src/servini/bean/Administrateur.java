package servini.bean;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;

}
