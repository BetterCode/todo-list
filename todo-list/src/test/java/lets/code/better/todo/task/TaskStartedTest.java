package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskStartedTest extends TransactionTest{


	@Test
	public void testStarted() throws Exception {
		
		Task task = Task.create(TITLE,DESCRIPTION, EXECUTOR);
		assertFalse(task.isStarted());

		task.start();
		
		assertTrue(task.isStarted());
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void testStartedFromController() throws Exception {
		
		Task task = Task.create(TITLE,DESCRIPTION, EXECUTOR);
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.start(task.getId());
		
		assertTrue( ( (String)result.included("message") ).contains(TITLE) );
	}
	
}
