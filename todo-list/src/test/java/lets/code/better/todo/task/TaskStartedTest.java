package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.CREATED_AT;
import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.*;
import lets.code.better.todo.controller.TaskController;
import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;
import lets.code.better.todo.service.TaskService;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskStartedTest {


	@Test
	public void testStartedFromService() throws Exception {
		TaskService taskService = new TaskService();
		Task task = taskService.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		task = taskService.start(task.getId());
		
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void testStartedFromFacade() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		task = taskFacade.start(task.getId());
		
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void testStartedFromController() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.start(task.getId());
		
		assertEquals( String.format("Task %s started.",TITLE ),((String)result.included("message")) );
	}
	
}
