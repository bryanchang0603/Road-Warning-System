import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellTest {
	private Cell test;
	@Before
	public void setUp() throws Exception {
		test = new Cell(2,1,4,3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_showLatitudeHi() {
		assertTrue( 2 == test.showLatitudeHi());
	}
	
	@Test
	public void test_showLatitudeLo() {
		assertTrue( 1 == test.showLatitudeLo());
	}
	
	@Test
	public void test_showLongitudeHi() {
		assertTrue( 4 == test.showLongitudeHi());
	}
	
	@Test
	public void test_showLongitudeLo() {
		assertTrue( 3 == test.showLongitudeLo());
	}
	
	@Test
	public void test_showLocation() {
		assertTrue( 0 == test.showLocation().size());
	}
	
	@Test
	public void test_getLatitude() {
		assertTrue( 1.5 == test.getLatitude());
	}
	
	public void test_getLongitude() {
		assertTrue( 1.5 == test.getLongtitude());
	}
	
	@Test
	public void test_appendLocation() {
		AccidentEvent appendingTest;
		for(int i = 0; i < 10; i++) {
			appendingTest = new AccidentEvent(1,1,1,1,1,1,1,1,1,1);
			test.appendLocation(appendingTest);
		}
		assertTrue( 10 == test.showLocation().size());
	}
	
	@Test
	public void test_getRegionAverage() {
		AccidentEvent appendingTest;
		for(int i = 0; i < 10; i++) {
			appendingTest = new AccidentEvent(0,0,0,0,0,0,0,0,0,0);
			test.appendLocation(appendingTest);
		}
		double[] output = test.getRegionAverage();
		assertTrue(output[2] == 0);
	}
	
	@Test
	public void test_getRegionAverage_emptyList() {
		double[] output = test.getRegionAverage();
		assertTrue(Double.isNaN(output[2]));
	}

}
