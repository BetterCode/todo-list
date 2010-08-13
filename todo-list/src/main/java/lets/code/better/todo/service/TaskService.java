package lets.code.better.todo.service;

import java.util.Date;
import java.util.List;

import lets.code.better.todo.dao.TaskDao;
import lets.code.better.todo.model.Task;

public class TaskService {

	private TaskDao dao = new TaskDao();

	public Task createTask(String title, String description, String executor, Date createdAt) {
			Task task = newTask(title, description, executor, createdAt);
			dao.save(task);
			return task;
	}

	public List<Task> list() {
		return dao.list();
	}

	public Task start(Integer taskId) {
			Task task = dao.find(Task.class, taskId);
			task.setStartedAt(new Date());
			dao.update(task);
			return task;
	}

	public Task finish(Integer taskId) {
			Task task = dao.find(Task.class, taskId);
			task.setFinishedAt(new Date());
			dao.update(task);
			return task;
	}

	private Task newTask(String title, String description, String executor, Date createdAt) {
		Task task = new Task();
		task.setTitle(title);
		task.setDescr(description);
		task.setExecutor(executor);
		task.setCreatedAt(createdAt);
		
		return task;
	}

	
}
