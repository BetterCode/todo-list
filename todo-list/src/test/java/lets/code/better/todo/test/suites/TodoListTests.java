package lets.code.better.todo.test.suites;

import lets.code.better.todo.task.TaskCreationTest;
import lets.code.better.todo.task.TaskFinishedTest;
import lets.code.better.todo.task.TaskListTest;
import lets.code.better.todo.task.TaskStartedTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { TaskCreationTest.class, TaskFinishedTest.class, TaskListTest.class, TaskStartedTest.class  })
public class TodoListTests {
}
