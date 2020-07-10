import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccidentEvalTest {
	private AccidentEvent a;
	private AccidentEvent extreme1;
	private AccidentEvent extreme2;

	@Before
	public void setUp() throws Exception {
		a = new AccidentEvent(3, 16, 0, 1, 3, 0, 0, 5, 60.2333, 30.2222);
		extreme1 = new AccidentEvent(0,0,0,0,0,0,0,0,0,0);
		extreme2 = new AccidentEvent(999999,99999,99999,1,8,1,1,99999,999999,999999);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		AccidentEval.Evaluation(a);
		assertTrue(a.getScore() == 38);
	}
	
	@Test
	public void testExtreme1() {
		AccidentEval.Evaluation(extreme1);
		assertTrue(extreme1.getScore() == 0);
	}
	
	@Test
	public void testExtreme2() {
		AccidentEval.Evaluation(extreme2);
		assertTrue(extreme2.getScore() == 100);
	}
}
