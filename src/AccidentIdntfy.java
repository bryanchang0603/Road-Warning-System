import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Identify the high accident locations based on the accidentEvents
 * 
 * @author Xinyu Huang, Lab 01
 * @version 1.0
 */
public class AccidentIdntfy {
	/**
	 * Identify the high accident locations based on the accidentEvents
	 * 
	 * @param accidentArray - An array list contains the accidentEvents
	 * @return The array list contains the HighAccidLocas
	 */
	public static ArrayList<HighAccidLoca> accidentIdentify(ArrayList<AccidentEvent> accidentArray) {

		ArrayList<HighAccidLoca> accidentLocation = new ArrayList<HighAccidLoca>();

		CellMap map = new CellMap(41.03, 40.09, -74.9, -80.5, 0.006, 0.006);
		for (int i = 0; i < accidentArray.size(); i++) {
			AccidentEval.Evaluation(accidentArray.get(i));
			map.appendLocation(accidentArray.get(i));
		}

		for (int i = 0; i < map.sizeM(); i++) { // map.sizeM() return the number of rows m of the map
			for (int j = 0; j < map.sizeN(); j++) { // map.sizeN() return the number of columns n of the map
				Cell cell = map.getRegion(i, j);
				double[] average = cell.getRegionAverage(); 
				int level = accidentLevel(average[2] + average[1] * 0.1);
				double latitude = cell.getLatitude();
				double longtitude = cell.getLongtitude();
				HighAccidLoca appendingLoc = new HighAccidLoca(latitude, longtitude, level);
				if (level < 4)
					accidentLocation.add(appendingLoc);
			}
		}
		return accidentLocation;
	}

	/**
	 * Classify the accident level for the level of the HighAccidLoca
	 * 
	 * @param average - the average accident score for the cell
	 * @return The level of the HighAccidLoca
	 */
	private static int accidentLevel(double average) {
		if (average > 40)
			return 1;
		else if (average > 35)
			return 2;
		else if (average > 30)
			return 3;
		else
			return 4;
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<AccidentEvent> accidentArray = Read.ReadAccident();
		ArrayList<HighAccidLoca> highAccidentLoca = accidentIdentify(accidentArray);
		for (int i = 0; i < highAccidentLoca.size(); i++) {
			System.out.println(i + " " + "highAccidentLocation: " + highAccidentLoca.get(i).toString());
		}

	}

}
