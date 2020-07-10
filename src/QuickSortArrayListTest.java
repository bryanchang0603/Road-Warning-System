import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QuickSortArrayListTest {

	private ArrayList<HighAccidLoca> a = new ArrayList<HighAccidLoca>();
	private ArrayList<HighAccidLoca> extreme = new ArrayList<HighAccidLoca>();
	private ArrayList<HighAccidLoca> empty = new ArrayList<HighAccidLoca>();
	
	@Before
	public void setUp() throws Exception {
		HighAccidLoca b1 = new HighAccidLoca(20.2233, -50.566, 72);
		b1.setDistance(77.89);
		HighAccidLoca b2 = new HighAccidLoca(30.223, -10.566, 12);
		b2.setDistance(12.12);
		HighAccidLoca b3 = new HighAccidLoca(44.22, -67.56, 42);
		b3.setDistance(33.2);
		HighAccidLoca b4 = new HighAccidLoca(67.121, -53.438, 82);
		b4.setDistance(11.02);
		HighAccidLoca b5 = new HighAccidLoca(-77.99, 111.1111, 34);
		b5.setDistance(90.2);
		HighAccidLoca b6 = new HighAccidLoca(67.889, -17.22, 87);
		b6.setDistance(43.6);
		HighAccidLoca b7 = new HighAccidLoca(95.543, -59.764, 12);
		b7.setDistance(68.33);
		HighAccidLoca b8 = new HighAccidLoca(112.333, 87.654, 7);
		b8.setDistance(53.38);
		HighAccidLoca b9 = new HighAccidLoca(43.2901, -111.2338, 99);
		b9.setDistance(79.6);
		a.add(b1);
		a.add(b2);
		a.add(b3);
		a.add(b4);
		a.add(b5);
		a.add(b6);
		a.add(b7);
		a.add(b8);
		a.add(b9);

		
		extreme.add(b5);
		extreme.add(b9);
		extreme.add(b1);
		extreme.add(b7);
		extreme.add(b8);
		extreme.add(b6);
		extreme.add(b3);
		extreme.add(b2);
		extreme.add(b4);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGeneral() {
		QuickSortArrayList.sortBasicQuick(a);
		assertTrue(QuickSortArrayList.isSorted(a));
	}
	
	@Test
	public void testBoundary() {
		QuickSortArrayList.sortBasicQuick(empty);
		assertTrue(QuickSortArrayList.isSorted(empty));
	}
	
	@Test
	public void testExtreme() {
		QuickSortArrayList.sortBasicQuick(extreme);
		assertTrue(QuickSortArrayList.isSorted(extreme));
	}

}
