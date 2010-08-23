package lets.code.better.todo.task;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class TaskController {

	private Result result;

	public TaskController(Result result) {
		this.result = result;
	}

	public void create() {
	}

	public void createTask(String title, String description, String executor) {
		Task.create(title, description, executor);
		result.include("message", String.format("Task '%s' created.", title));
		result.redirectTo(TaskController.class).list();
	}

	public List<Task> list() {
		final List<Task> list = Task.list();
		return list;
	}

	public void start(Integer id) {
		final Task task = Task.findById(id).start();
		result.include("message", String.format("Task '%s' started.", task
				.getTitle()));
		result.redirectTo(TaskController.class).list();
	}

	public void finish(Integer id) {
		final Task task = Task.findById(id).finish();
		result.include("message", String.format("Task '%s' finished.", task
				.getTitle()));
		result.redirectTo(TaskController.class).list();
	}

}
