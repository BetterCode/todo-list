package lets.code.better.todo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import lets.code.better.todo.util.Transaction;

import org.hibernate.Session;

public class HibernateRepository {

	public <T extends Serializable>void save(T entity) {
		entityManager().persist(entity);
	}
	
	public <T extends Serializable>void update(T entity) {
		entityManager().merge(entity);
	}
	
	public <T extends Serializable> T findById(Class<T> type, Integer id){
		return entityManager().find(type, id);
	}
	
	public Session session(){
		return (Session)entityManager().getDelegate();
	}
	
	private EntityManager entityManager() {
		return Transaction.entityManager();
	}

}