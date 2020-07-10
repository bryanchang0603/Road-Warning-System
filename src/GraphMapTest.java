import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphMapTest {

	private GraphMap testGraph;

	@Before
	public void setUp() throws Exception {
		testGraph = new GraphMap(10, 0, 5, 0, 1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		ArrayList<ArrayList<Region>> output = testGraph.showMap();
		boolean result = true;
		result = result && output.size() == 11;
		for (int i = 0; i < 11; i++) {
			result = result && output.get(i).size() == 6;
		}

		assertTrue(result);
	}

	@Test
	public void testAdjConor() {
		ArrayList[][] output = testGraph.showAdj();
		boolean result = true;
		ArrayList<Integer> test1 = output[0][0];
		ArrayList<Integer> test2 = output[10][0];
		ArrayList<Integer> test3 = output[0][5];
		ArrayList<Integer> test4 = output[10][5];
		result = result && test1.size() == 3;
		result = result && test2.size() == 3;
		result = result && test4.size() == 3;
		result = result && test3.size() == 3;
		assertTrue(result);
	}

	@Test
	public void testAdjEdge() {
		ArrayList[][] output = testGraph.showAdj();
		boolean result = true;
		ArrayList<Integer> test1 = output[0][1];
		ArrayList<Integer> test2 = output[10][1];
		ArrayList<Integer> test3 = output[1][5];
		ArrayList<Integer> test4 = output[9][5];
		result = result && test1.size() == 5;
		result = result && test2.size() == 5;
		result = result && test4.size() == 5;
		result = result && test3.size() == 5;
		assertTrue(result);
	}

	@Test
	public void testAdjNormal() {
		ArrayList[][] output = testGraph.showAdj();
		boolean result = true;
		ArrayList<Integer> test1 = output[1][1];
		result = result && test1.size() == 8;
		assertTrue(result);
	}

	@Test
	public void testFindRegion() {
		HighAccidLoca input = new HighAccidLoca(0.5, 0.5, 1);
		ArrayList<HighAccidLoca> test = testGraph.findRegion(input);
		assertTrue(test.size() == 0);
	}

	@Test
	public void testAppendLocation() {
		HighAccidLoca input = new HighAccidLoca(0.5, 0.5, 1);
		testGraph.appendLocation(input);
		ArrayList<ArrayList<Region>> output = testGraph.showMap();
		ArrayList<HighAccidLoca> test = output.get(0).get(0).showLocation();
		assertTrue(test.size() == 1);
	}

	@Test
	public void testFindRegion2() {
		HighAccidLoca input = new HighAccidLoca(0.5, 0.5, 1);
		testGraph.appendLocation(input);
		ArrayList<HighAccidLoca> test = testGraph.findRegion(input);
		assertTrue(test.size() == 1);
	}

	@Test
	public void testFindRegion3() {
		HighAccidLoca input = new HighAccidLoca(0.5, 0.5, 1);
		HighAccidLoca input2 = new HighAccidLoca(1.5, 1.5, 1);
		testGraph.appendLocation(input2);
		ArrayList<HighAccidLoca> test = testGraph.findRegion(input);
		assertTrue(test.size() == 1);
	}

	@Test
	public void testAppendLocation2() {
		HighAccidLoca input = new HighAccidLoca(1, 0.1, 1);
		testGraph.appendLocation(input);
		ArrayList<ArrayList<Region>> output = testGraph.showMap();
		ArrayList<HighAccidLoca> test = output.get(0).get(0).showLocation();
		ArrayList<HighAccidLoca> test2 = output.get(1).get(0).showLocation();
		assertTrue(test.size() == 1 && test2.size() == 0);
	}

	@Test
	public void testAppendLocation3() {
		HighAccidLoca input = new HighAccidLoca(1, 1, 1);
		testGraph.appendLocation(input);
		ArrayList<ArrayList<Region>> output = testGraph.showMap();
		ArrayList<HighAccidLoca> test = output.get(0).get(0).showLocation();
		ArrayList<HighAccidLoca> test2 = output.get(1).get(0).showLocation();
		assertTrue(test.size() == 1 && test2.size() == 0);
	}


}
