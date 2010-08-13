package lets.code.better.todo.facade;

import java.util.Date;
import java.util.List;

import lets.code.better.todo.model.Task;
import lets.code.better.todo.service.TaskService;

public class TaskFacade {

	private TaskService taskService = new TaskService();

	public Task createTask(String title, String description, String executor, Date createdAt) {
		return taskService.createTask(title, description, executor, createdAt);
	}

	public List<Task> list() {
		return taskService.list();
	}

	public Task start(Integer taskId) {
		return taskService.start(taskId);
	}

	public Task finish(Integer taskId) {
		return taskService.finish(taskId);
	}
	
}
