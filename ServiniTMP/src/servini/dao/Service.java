package servini.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Service<T> {

	public void addObjet(T o) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
	}

	public List<T> getAllObjets(String _T) {
		SessionFactory sf = util.HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		List<T> liste = session.createQuery("from " + _T).list();
		session.getTransaction().commit();
		session.close();
		return liste;
	}

	public T getById(Class<T> obj, int id) {
		
		SessionFactory sf = util.HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		T o = session.get(obj, id);
		session.getTransaction().commit();
		session.close();
		return o;
	}

	public void deleteObjet(Class<T> obj, int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		T o = (T) session.get(obj, id);
		session.delete(o);
		session.getTransaction().commit();
	}

	public void updateObjet(T obj) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
	}

	public T getByLogin(String login, String password, String _T) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		T o = null;
		try {
			tx = session.beginTransaction();
			Query<T> q = session
					.createQuery("from " + _T + " where login='" + login + "' and password='" + password + "'");
			o = (T) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return o;
	}
}
