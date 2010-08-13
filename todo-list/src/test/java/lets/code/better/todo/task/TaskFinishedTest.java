package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.CREATED_AT;
import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import lets.code.better.todo.controller.TaskController;
import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;
import lets.code.better.todo.service.TaskService;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskFinishedTest {


	@Test
	public void testFinishedFromService() throws Exception {
		TaskService taskService = new TaskService();
		Task task = taskService.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		task = taskService.finish(task.getId());
		
		assertNotNull(task.getFinishedAt());
	}
	
	@Test
	public void testFinishedFromFacade() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		task = taskFacade.finish(task.getId());
		
		assertNotNull(task.getFinishedAt());
	}
	
	@Test
	public void testFinishedFromController() throws Exception {
		TaskFacade taskFacade = new TaskFacade();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION, EXECUTOR, CREATED_AT);
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.finish(task.getId());
		
		assertEquals( String.format("Task %s finished.",TITLE ),((String)result.included("message")) );
	}
	
}
