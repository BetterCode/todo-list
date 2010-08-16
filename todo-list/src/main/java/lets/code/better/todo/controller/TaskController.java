package lets.code.better.todo.controller;

import java.util.Date;
import java.util.List;

import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;
import lets.code.better.todo.util.Transaction;
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
	
	public void create(){
	}

	public void createTask(String title, String description, String executor) {
		try {
			Transaction.begin();
			taskFacade.createTask(title, description, executor, new Date());
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
			List<Task> list = taskFacade.list();
			Transaction.commit();
			return list;
		} finally {
			Transaction.rollbackIfActive();
		}
	}

	public void start(Integer id) {
		try {
			Transaction.begin();
			Task start = taskFacade.start(id);
			result.include("message",
					String.format("Task '%s' started.", start.getTitle()));
			Transaction.commit();
			result.redirectTo(TaskController.class).list();
		} finally {
			Transaction.rollbackIfActive();
		}
	}

	public void finish(Integer id) {
		try {
			Transaction.begin();
			Task start = taskFacade.finish(id);
			result.include("message",
					String.format("Task '%s' finished.", start.getTitle()));
			Transaction.commit();
			result.redirectTo(TaskController.class).list();
		} finally {
			Transaction.rollbackIfActive();
		}
	}

}
