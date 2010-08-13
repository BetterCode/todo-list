package lets.code.better.todo.dao;

import java.util.List;

import lets.code.better.todo.model.Task;

public class TaskDao extends GenericDao {

	@SuppressWarnings("unchecked")
	public List<Task> list() {
		return session().createCriteria(Task.class).list();
	}

}
