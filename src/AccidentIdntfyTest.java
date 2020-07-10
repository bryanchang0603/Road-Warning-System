import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccidentIdntfyTest {
	private ArrayList<HighAccidLoca> highAccidentLocas;

	@Before
	public void setUp() throws Exception {
		ArrayList<AccidentEvent> accidentArray = Read.ReadAccident();
		this.highAccidentLocas = AccidentIdntfy.accidentIdentify(accidentArray);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AccidentIdntfy_test_1() {
		System.out.println("AccidentIdntfy Module Test Case 1: ");
		HighAccidLoca location = highAccidentLocas.get(0);
		assertTrue((location.getLatitude() - 40.26700000000001) < 0.0000001);
		assertTrue((location.getLongtitude() - (-79.96299999999998)) < 0.0000001);
		assertTrue(location.getLevel() == 1);
		System.out.println("Test Case 1 success.");
	}

	@Test
	public void AccidentIdntfy_test_2() {
		System.out.println("AccidentIdntfy Module Test Case 2");
		HighAccidLoca location = highAccidentLocas.get(77);
		assertTrue((location.getLatitude() - 40.423000000000016) < 0.0000001);
		assertTrue((location.getLongtitude() - (-79.90299999999998)) < 0.0000001);
		assertTrue(location.getLevel() == 2);
		System.out.println("Test Case 2 success.");
	}

	@Test
	public void AccidentIdntfy_test_3() {
		System.out.println("AccidentIdntfy Module Test Case 3");
		HighAccidLoca location = highAccidentLocas.get(268);
		assertTrue((location.getLatitude() - 40.669000000000025) < 0.0000001);
		assertTrue((location.getLongtitude() - (-79.76499999999997)) < 0.0000001);
		assertTrue(location.getLevel() == 2);
		System.out.println("Test Case 3 success.");
	}

}
