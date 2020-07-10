import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadTest {
	private ArrayList<AccidentEvent> accidents = new ArrayList<AccidentEvent>();
	@Before
	public void setUp() throws Exception {
		setAccidents(Read.ReadAccident());
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("");
		setAccidents(null);
	}	

	@Test
	public void testAUTOMOBILE_COUNT() {
		AccidentEvent first = accidents.get(0);
		int a = first.getAUTOMOBILE_COUNT();
		assertTrue(a == 0);
	}
	
	@Test
	public void testINJURY_COUNT() {
		AccidentEvent first = accidents.get(1);
		int a = first.getINJURY_COUNT();
		assertTrue(a == 1);
	}
	
	@Test
	public void testFATAL_COUNT() {
		AccidentEvent first = accidents.get(0);
		int a = first.getFATAL_COUNT();
		assertTrue(a == 0);
	}
	
	@Test
	public void testAll() {
		AccidentEvent first = accidents.get(53538);
		
		double a = first.getDEC_LAT();
		double b = first.getDEC_LONG();
		int c = first.getCOLLISION_TYPE();
		int d = first.getAUTOMOBILE_COUNT();
		int e = first.getCURVED_ROAD();
		int f = first.getDEER_RELATED();
		int g = first.getFATAL_COUNT();
		int h = first.getSCHOOL_ZONE();
		int i = first.getINJURY_COUNT();
		int j = first.getVHICLE_COUNT();
		assertTrue(a == 40.55659866 && b == -80.10620117 && c == 7 && d == 1 && e == 1 && f == 0 && g == 0 && h == 0 && i == 1 && j == 1);
	}
	
	

	public ArrayList<AccidentEvent> getAccidents() {
		return accidents;
	}

	public void setAccidents(ArrayList<AccidentEvent> accidents) {
		this.accidents = accidents;
	}

}
