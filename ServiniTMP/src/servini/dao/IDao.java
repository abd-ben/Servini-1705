package servini.dao;

import java.util.List;

public interface IDao<T> {
	public boolean addObjet(T o);

	public boolean deleteObjet(T o);

	public boolean updateObjet(T o);

	public T getById(int idn);

	public List<T> getAllObjets();

}
