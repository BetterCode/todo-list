package lets.code.better.todo.task;

import java.util.List;

import lets.code.better.todo.util.Transaction;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class TaskController {

	private Result result;
	
	public TaskController(Result result) {
		this.result = result;
	}
	
	public void create(){
	}

	public void createTask(String title, String description, String executor) {
		try {
			Transaction.begin();
			Task.create(title, description, executor);
			result.include("message", String.format("Task '%s' created.", title));
			Transaction.commit();
			result.redirectTo(TaskController.class).list();
		} finally {
			Transaction.rollbackIfActive();
		}
	}

	public List<Task> list() {
		try {
			Transaction.begin();
			final List<Task> list = Task.list();
			Transaction.commit();
			return list;
		} finally {
			Transaction.rollbackIfActive();
		}
	}

	public void start(Integer id) {
		try {
			Transaction.begin();
			final Task task = Task.findById(id).start();
			result.include("message",
					String.format("Task '%s' started.", task.getTitle()));
			Transaction.commit();
			result.redirectTo(TaskController.class).list();
		} finally {
			Transaction.rollbackIfActive();
		}
	}

	public void finish(Integer id) {
		try {
			Transaction.begin();
			final Task task = Task.findById(id).finish();
			result.include("message",
					String.format("Task '%s' finished.", task.getTitle()));
			Transaction.commit();
			result.redirectTo(TaskController.class).list();
		} finally {
			Transaction.rollbackIfActive();
		}
	}

}
