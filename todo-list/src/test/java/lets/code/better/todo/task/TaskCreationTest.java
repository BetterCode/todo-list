package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public final class TaskCreationTest extends TransactionTest{
	
	
	@Test
	public void taskCreation() {
		
		final Task task = Task.create(TITLE, DESCRIPTION, EXECUTOR);

		assertNotNull(task);
		assertEquals(TITLE, task.getTitle());
		assertEquals(DESCRIPTION, task.getDescription());
		assertEquals(EXECUTOR, task.getExecutor());
		assertNotNull(task.getCreatedAt());
		assertNotNull(task.getId());
		assertNull(task.getStartedAt());
		assertNull(task.getFinishedAt());
		
		final Task task2 = Task.findById(task.getId());
		assertEquals(task, task2);
	}

	@Test
	public void taskCreationFromController(){
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.createTask(TITLE,DESCRIPTION,EXECUTOR);
		
		assertTrue( ( (String)result.included("message") ).contains(TITLE) );
	}

}
