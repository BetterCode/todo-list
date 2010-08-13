package lets.code.better.todo.task;

import static org.junit.Assert.*;
import static lets.code.better.todo.task.TaskConstants.*;

import java.util.Date;
import java.util.List;

import lets.code.better.todo.controller.TaskController;
import lets.code.better.todo.dao.TaskDao;
import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;
import lets.code.better.todo.service.TaskService;
import lets.code.better.todo.util.Transaction;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;


public class TaskListTest {

	@Test
	public void taskListingFromDao() throws Exception {
		TaskDao taskDao = new TaskDao();
		
		Transaction.begin();
		Task task1 = newTask(1);
		Task task2 = newTask(2);
		List<Task> tasks = taskDao.list();
		Transaction.commit();

		assertTrue(tasks.contains(task1));
		assertTrue(tasks.contains(task2));
	}
	
	@Test
	public void taskListingFromService() throws Exception {
		TaskService service = new TaskService();
		
		Transaction.begin();
		Task task1 = newTask(1);
		Task task2 = newTask(2);
		List<Task> tasks = service.list();
		Transaction.commit();
		
		assertTrue(tasks.contains(task1));
		assertTrue(tasks.contains(task2));
	}

	
	@Test
	public void taskListingFromFacade() throws Exception {
		TaskFacade facade = new TaskFacade();
		
		Transaction.begin();
		Task task1 = newTask(1);
		Task task2 = newTask(2);
		List<Task> tasks = facade.list();
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
		TaskService taskService = new TaskService();
		return taskService.createTask(TITLE+i, DESCRIPTION, EXECUTOR, new Date());
	}
}
