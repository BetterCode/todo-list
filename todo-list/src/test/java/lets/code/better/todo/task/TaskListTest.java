package lets.code.better.todo.task;

import static lets.code.better.todo.task.TaskConstants.DESCRIPTION;
import static lets.code.better.todo.task.TaskConstants.EXECUTOR;
import static lets.code.better.todo.task.TaskConstants.TITLE;
import static org.junit.Assert.assertTrue;

import java.util.List;

import lets.code.better.todo.util.Transaction;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;


public class TaskListTest {

	@Test
	public void taskListing() throws Exception {
		
		Transaction.begin();
		Task task1 = newTask(1);
		Task task2 = newTask(2);
		List<Task> tasks = Task.list();
		Transaction.commit();

		assertTrue(tasks.contains(task1));
		assertTrue(tasks.contains(task2));
	}
	
	@Test
	public void taskListingFromController() throws Exception {
		Transaction.begin();
		Task task1 = newTask(1);
		Task task2 = newTask(2);
		Transaction.commit();
		
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);
		List<Task> tasks = taskController.list();
		
		assertTrue(tasks.contains(task1));
		assertTrue(tasks.contains(task2));
	}
	
	private Task newTask(int i) {
		return Task.create(TITLE,DESCRIPTION, EXECUTOR);
	}
}
