package lets.code.better.todo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

	private static javax.persistence.EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("default");
	}
	
	public synchronized static EntityManager getEntityManager(){
		if(entityManager == null || !entityManager.isOpen()){
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}
	
}
