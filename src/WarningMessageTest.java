import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WarningMessageTest {

	private int[] array1 = {1,1,1,1};
	private int[] array2 = {2,3,1,3};
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public  void testGetMinIndex() {
		assertEquals(WarningMessage.getMinIndex(array1), 0);
		assertEquals(WarningMessage.getMinIndex(array2), 2);
	}
	
	
	@Test
	public void testMessage() throws IOException {
	     String outContent1 = WarningMessage.message(40.51300000000002, -79.95099999999998);
	     String expectedOutput1  = "There will be a danger zone with warning level 3 in 0.00 meters. Please drive carefully!"; 
	     assertTrue(expectedOutput1.compareTo(outContent1)==0);
	     
	     String outContent2 = WarningMessage.message(40.651, -79.911);
	     String expectedOutput2  = "You are safe at the current location"; 
	     assertEquals(expectedOutput2, outContent2);
	     
	     String outContent3 = WarningMessage.message(40.472, -79.931);
	     String expectedOutput3  = "There will be a danger zone with warning level 2 in 356.56 meters. Please drive carefully!"; 
	     assertEquals(expectedOutput3, outContent3);
	     
	     String outContent4 = WarningMessage.message(40.465, -79.938);
	     String expectedOutput4  = "There will be a danger zone with warning level 3 in 84.69 meters. Please drive carefully!"; 
	     assertEquals(expectedOutput4, outContent4);
	     
	     String outContent5 = WarningMessage.message(40.459, -79.837098);
	     String expectedOutput5  = "There will be a danger zone with warning level 1 in 499.90 meters. Please drive carefully!"; 
	     assertEquals(expectedOutput5, outContent5);
	}
	

}
