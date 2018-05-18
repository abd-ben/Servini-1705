package servini.service;

import java.util.List;

import servini.bean.Commercant;
import servini.bean.Produit;
import servini.dao.Service;

public class CommercantService extends Service<Commercant> {
	
	public void addCommercant(Commercant o) {
		super.addObjet(o);
	}

	public List<Commercant> getAllCommercant() {
		return super.getAllObjets("Commercant");
	}

	public Commercant getCommercantById(int id) {
		return super.getById(Commercant.class, id);
	}

	public void deleteCommercant(Commercant o) {
		super.deleteObjet(Commercant.class, o.getIdPersonne());
	}

	public void updateCommercant(Commercant obj) {
		super.updateObjet(obj);
	}

}
