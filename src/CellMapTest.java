import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CellMapTest {

		CellMap testMap;

		@Before
		public void setUp() throws Exception {
			testMap = new CellMap(10, 0, 5, 0, 1, 1);
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void testConstructor() {
			ArrayList<ArrayList<Cell>> exportedMap = testMap.showMap();
			boolean result = true;
			result = result && (exportedMap.size() == 11);
			for (int i = 0; i < 11; i++) {
				result = result && (exportedMap.get(i).size() == 6);
				for(int j = 0; j < 6; j++) {
					result = result && (exportedMap.get(i).get(j).showLocation().size() == 0);
				}
			}
			assertTrue(result);

		}
		
		@Test
		public void test_sizeM() {
			assertTrue(testMap.sizeM() == 11);
		}
		
		@Test
		public void test_sizeN() {
			assertTrue(testMap.sizeN() == 6);
		}
		
		@Test
		public void test_getRegion() {
			Cell exportedCell = testMap.getRegion(0, 0);
			boolean result = true;
			result = result && exportedCell.showLatitudeHi() == 1 && exportedCell.showLatitudeLo() == 0;
			result = result && exportedCell.showLongitudeHi() == 1 && exportedCell.showLongitudeLo() == 0;
			assertTrue(result);
		}
		
		@Test
		public void test_appendLocation() {
			AccidentEvent appendingTest = new AccidentEvent(0,0,0,0,0,0,0,0,0.1,0.1);
			testMap.appendLocation(appendingTest);
			Cell exportedCell = testMap.getRegion(0, 0);
			assertTrue(exportedCell.showLocation().size() == 1);
		}
		
		@Test
		public void test_appendLocation2() {
			AccidentEvent appendingTest = new AccidentEvent(0,0,0,0,0,0,0,0,1,0.1);
			testMap.appendLocation(appendingTest);
			Cell exportedCell = testMap.getRegion(1, 0);
			Boolean result = true;
			result = result && exportedCell.showLocation().size() == 0;
			exportedCell = testMap.getRegion(0, 0);
			result = result && exportedCell.showLocation().size() == 1;
			assertTrue(result);
		}
		
		@Test
		public void test_appendLocation3() {
			AccidentEvent appendingTest = new AccidentEvent(0,0,0,0,0,0,0,0,0.5,0.5);
			testMap.appendLocation(appendingTest);
			Cell exportedCell = testMap.getRegion(0, 0);
			assertTrue(exportedCell.showLocation().size() == 1);
		}
		
		@Test
		public void test_appendLocation4() {
			AccidentEvent appendingTest = new AccidentEvent(0,0,0,0,0,0,0,0,0.1,1);
			testMap.appendLocation(appendingTest);
			Cell exportedCell = testMap.getRegion(0, 1);
			Boolean result = true;
			result = result && exportedCell.showLocation().size() == 0;
			exportedCell = testMap.getRegion(0, 0);
			result = result && exportedCell.showLocation().size() == 1;
			assertTrue(result);
		}


}
