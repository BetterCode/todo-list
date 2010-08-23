package lets.code.better.todo.task;

import lets.code.better.todo.util.Transaction;

import org.junit.After;
import org.junit.Before;

public class TransactionTest {

	@Before
	public void beginTransaction() {
		Transaction.begin();
	}

	@After
	public void endTransactino() {
		Transaction.rollbackIfActive();
	}

}