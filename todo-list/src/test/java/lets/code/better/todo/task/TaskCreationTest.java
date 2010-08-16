package lets.code.better.todo.task;

import static org.junit.Assert.*;
import static lets.code.better.todo.task.TaskConstants.*;


import lets.code.better.todo.controller.TaskController;
import lets.code.better.todo.dao.TaskDao;
import lets.code.better.todo.facade.TaskFacade;
import lets.code.better.todo.model.Task;
import lets.code.better.todo.service.TaskService;
import lets.code.better.todo.util.Transaction;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockResult;

public class TaskCreationTest {

	@Test
	public void taskCreation() {
		Task task = newTask();

		assertNotNull(task);
		assertEquals(TITLE, task.getTitle());
		assertEquals(DESCRIPTION, task.getDescr());
		assertEquals(EXECUTOR, task.getExecutor());
		assertEquals(CREATED_AT, task.getCreatedAt());
		assertNull(task.getStartedAt());
		assertNull(task.getFinishedAt());
	}

	@Test
	public void taskPersistence(){
		TaskDao taskDao = new TaskDao();
		Task task = newTask();
		Transaction.begin();
		taskDao.save(task);
		Transaction.commit();
		assertNotNull(task.getId());
	}
	
	@Test
	public void taskCreationFromService(){
		TaskService taskService = new TaskService();
		Transaction.begin();
		Task task = taskService.createTask(TITLE,DESCRIPTION,EXECUTOR,CREATED_AT);
		Transaction.commit();
		assertNotNull(task.getId());
		assertEquals(TITLE, task.getTitle());
		assertEquals(DESCRIPTION, task.getDescr());
		assertEquals(EXECUTOR, task.getExecutor());
		assertEquals(CREATED_AT, task.getCreatedAt());
		assertNull(task.getStartedAt());
		assertNull(task.getFinishedAt());
	}
	
	@Test
	public void taskCreationFromFacade(){
		TaskFacade taskFacade = new TaskFacade();
		Transaction.begin();
		Task task = taskFacade.createTask(TITLE,DESCRIPTION,EXECUTOR,CREATED_AT);
		Transaction.commit();
		assertNotNull(task.getId());
		assertEquals(TITLE, task.getTitle());
		assertEquals(DESCRIPTION, task.getDescr());
		assertEquals(EXECUTOR, task.getExecutor());
		assertEquals(CREATED_AT, task.getCreatedAt());
		assertNull(task.getStartedAt());
		assertNull(task.getFinishedAt());
	}
	
	@Test
	public void taskCreationFromController(){
		MockResult result = new MockResult();
		TaskController taskController = new TaskController(result);

		taskController.createTask(TITLE,DESCRIPTION,EXECUTOR);
		
		assertTrue( ( (String)result.included("message") ).contains(TITLE) );
	}

	private Task newTask() {
		Task task = new Task();
		task.setTitle(TITLE);
		task.setDescr(DESCRIPTION);
		task.setExecutor(EXECUTOR);
		task.setCreatedAt(CREATED_AT);

		return task;
	}
}
