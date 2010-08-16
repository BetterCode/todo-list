package lets.code.better.todo.dao;

import java.util.List;

import org.hibernate.criterion.Order;

import lets.code.better.todo.model.Task;

public class TaskDao extends GenericDao {

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return session().createCriteria(Task.class).addOrder(Order.desc("id")).list();
	}

}
