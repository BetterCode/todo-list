package lets.code.better.todo.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

public class GenericDao {

	public <T extends Serializable>void save(T entity) {
		entityManager().persist(entity);
	}
	
	public <T extends Serializable>void update(T entity) {
		entityManager().merge(entity);
	}
	
	public <T extends Serializable> T find(Class<T> type, Integer id){
		return entityManager().find(type, id);
	}
	
	public Session session(){
		return (Session)entityManager().getDelegate();
	}
	
	public void rollbackIfActive() {
		EntityTransaction transaction = entityManager().getTransaction();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
			entityManager().close();
		}
	}

	public void beginTransaction() {
		entityManager().getTransaction().begin();
	}

	private EntityManager entityManager() {
		return EntityManagerFactory.getEntityManager();
	}

	public void commitTransaction() {
		entityManager().getTransaction().commit();
		entityManager().close();
	}

}