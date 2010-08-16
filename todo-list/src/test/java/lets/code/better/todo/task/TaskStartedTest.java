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
import lets.code.better.todo.util.Transaction;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskStartedTest {


	@Test
	public void testStartedFromService() throws Exception {
		TaskService taskService = new TaskService();
		
		Transaction.begin();
		Task task = taskService.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		assertFalse(task.isStarted());

		task = taskService.start(task.getId());
		Transaction.commit();
		
		assertTrue(task.isStarted());
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void testStartedFromFacade() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		
		Transaction.begin();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		task = taskFacade.start(task.getId());
		Transaction.commit();
		
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void testStartedFromController() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		
		Transaction.begin();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		Transaction.commit();
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.start(task.getId());
		
		assertTrue( ( (String)result.included("message") ).contains(TITLE) );
	}
	
}
