import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The ADT for map of cells. all accidents will be located in to the cell
 * belonging to
 * 
 * @author Baosheng Chang
 *
 * @param <Location> the type of location that will be append into the cell of
 *                   cellMap
 */
public class CellMap<Location extends AccidentEvent> {
	private ArrayList<ArrayList<Cell>> Map = new ArrayList<ArrayList<Cell>>();

	/**
	 * the constructor for constructing all elements in the 2-d array list
	 * 
	 * @param d the max latitude of the map
	 * @param e the min latitude of the map
	 * @param f the max longitude of the map
	 * @param g the min longitude of the map
	 * @param h the difference between cell's LatitudeHi and LatitudeLo
	 * @param k the difference between cell's LongitudeHi and LongitudeLo
	 */
	public CellMap(double d, double e, double f, double g, double h, double k) {
		for (double i = e; i <= d; i += h) {
			double LaL = i;
			double LaH = i + h;
			ArrayList<Cell> tempArray = new ArrayList<Cell>();
			for (double j = g; j <= f; j += k) {
				double LoL = j;
				double LoH = j + k;
				Cell tempRegion = new Cell(LaH, LaL, LoH, LoL);
				tempArray.add(tempRegion);
			}
			Map.add(tempArray);
		}
	}

	/**
	 * accessor method
	 * 
	 * @return return the 2-d ArrayList matrix to the user
	 */
	public ArrayList<ArrayList<Cell>> showMap() {
		return Map;
	}

	/**
	 * return the deminson m of the 2-d ArrayList matrix. m represent the number of
	 * coloumns.
	 * 
	 * @return return the number of coloumns of the map.
	 */
	public int sizeM() {
		return Map.size();
	}

	/**
	 * return the deminson n of the 2-d ArrayList matrix. n represent the number of
	 * rows.
	 * 
	 * @return return the number of rows of the map.
	 */
	public int sizeN() {
		return Map.get(0).size();
	}

	/**
	 * return the specific cell from the map with coordinate[i][j]
	 * @param i the matrix coordinate i
	 * @param j the matrix coordinate j
	 * @return return the cell at location[i][j] of the map
	 */
	public Cell getRegion(int i, int j) {
		return Map.get(i).get(j);
	}
	/**
	 * append the location to the cell it belongs in the cellMap
	 * @param in the location that need to be appended into the map
	 */
	public void appendLocation(Location in) {
		boolean foundLa = false;
		int midLa = Map.size() / 2;
		int lowLa = 0;
		int highLa = Map.size() - 1;

		do {
			double guessLaLo = Map.get(midLa).get(0).showLatitudeLo();
			double guessLaHi = Map.get(midLa).get(0).showLatitudeHi();
			// System.out.println(lowLa +"\t" + midLa + "\t" + highLa);
			if (in.getDEC_LAT() > guessLaLo && in.getDEC_LAT() <= guessLaHi) {
				foundLa = true;
				boolean foundLo = false;
				int midLo = Map.get(midLa).size() / 2;
				int lowLo = 0;
				int highLo = Map.get(midLa).size();
				// System.out.println(guessLaLo + "\t" + guessLaHi);
				do {
					double guessLoLo = Map.get(midLa).get(midLo).showLongitudeLo();
					double guessLoHi = Map.get(midLa).get(midLo).showLongitudeHi();
					// System.out.println(lowLo +"\t" + midLo + "\t" + highLo);
					// System.out.println(guessLoLo + "\t" + guessLoHi);
					if (in.getDEC_LONG() > guessLoLo && in.getDEC_LONG() <= guessLoHi) {
						Map.get(midLa).get(midLo).appendLocation(in);
						// System.out.println(guessLoLo + "\t" + guessLoHi);
						foundLo = true;
					} else if (in.getDEC_LONG() <= guessLoLo) {
						highLo = midLo - 1;
						midLo = (lowLo + highLo) / 2;
					} else if ((in.getDEC_LONG() > guessLoHi)) {
						lowLo = midLo + 1;
						midLo = (lowLo + highLo) / 2;
					}
				} while (foundLo == false);
			} else if (in.getDEC_LAT() <= guessLaLo) {
				highLa = midLa;
				midLa = (lowLa + highLa) / 2;
			} else if (in.getDEC_LAT() > guessLaHi) {
				lowLa = midLa;
				midLa = (lowLa + highLa) / 2;
			}
		} while (foundLa == false);
	}

	public static void main(String[] args) {
		CellMap testmap = new CellMap(41.03, 40.0970993, -74.94589996, -80.4866, 0.006, 0.006);
		System.out.println(testmap.sizeM() + "\t" + testmap.sizeN());
		ArrayList<ArrayList<Cell>> returnedMap = testmap.showMap();
		AccidentEvent temp = new AccidentEvent(0, 0, 0, 0, 0, 0, 0, 0, 41.01869965, -75.31729889);
		System.out.println(temp.getDEC_LAT() + "\t" + temp.getDEC_LONG());
		testmap.appendLocation(temp);
		ArrayList<Cell> testing = returnedMap.get(153);
	}
}
