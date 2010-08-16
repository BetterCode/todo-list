package lets.code.better.todo.task;

import java.util.List;

import org.hibernate.criterion.Order;

import lets.code.better.todo.repository.HibernateRepository;

public class Tasks extends HibernateRepository {

	@SuppressWarnings("unchecked")
	List<Task> list() {
		return session().createCriteria(Task.class).addOrder(Order.desc("id")).list();
	}

}
