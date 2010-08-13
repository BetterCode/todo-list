package lets.code.better.todo.controller;

import java.util.Date;
import java.util.List;

import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class TaskController {

	private Result result;
	private TaskFacade taskFacade;

	public TaskController(Result result) {
		this.result = result;
		taskFacade = new TaskFacade();
	}

	public void createTask(String title, String description, String executor, Date createdAt) {
		taskFacade.createTask(title, description, executor, createdAt);
		result.include("message", String.format("Task %s created.", title));
	}

	public List<Task> list() {
		return taskFacade.list();
	}

	public void start(Integer id) {
		Task start = taskFacade.start(id);
		result.include("message", String.format("Task %s started.", start.getTitle()));
	}

	public void finish(Integer id) {
		Task start = taskFacade.finish(id);
		result.include("message", String.format("Task %s finished.", start.getTitle()));
	}

	
}
