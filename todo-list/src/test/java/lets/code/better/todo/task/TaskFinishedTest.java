package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import lets.code.better.todo.util.Transaction;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskFinishedTest {


	@Test
	public void finishedShouldHaveStartDate() throws Exception {
		Transaction.begin();
		Task task = Task.create(TITLE,DESCRIPTION, EXECUTOR);
		assertFalse(task.isFinished());
		
		task.finish();
		Transaction.commit();
		
		assertTrue(task.isFinished());
		assertNotNull(task.getFinishedAt());
		
		assertTrue(task.isStarted());
		assertNotNull(task.getStartedAt());
	}
	
	@Test
	public void finishShouldNotChangeStartDate() throws Exception {
		Transaction.begin();
		Task task = Task.create(TITLE,DESCRIPTION, EXECUTOR);
		assertFalse(task.isFinished());
		task.start();
		final Date start = task.getStartedAt();
		task.finish();
		Transaction.commit();
		
		assertTrue(task.isFinished());
		assertNotNull(task.getFinishedAt());
		
		assertTrue(task.isStarted());
		assertNotNull(task.getStartedAt());
		assertEquals(start, task.getStartedAt());
	}
	
	
	@Test
	public void testFinishedFromController() throws Exception {
		
		Transaction.begin();
		Task task = Task.create(TITLE,DESCRIPTION, EXECUTOR);
		Transaction.commit();
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);
		taskController.finish(task.getId());
		
		assertTrue( ( (String)result.included("message") ).contains(TITLE) );
	}
	
}
