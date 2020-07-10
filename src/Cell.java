
import java.util.ArrayList;

/**
 * ADT designed to be the element of CellMap. each cell contain the values of
 * its boundaries and an ArrayList containing all locations belong to this cell.
 * 
 * @author Baosheng Chang
 *
 * @param <Location> Indicate what type of location is going to be stored in the
 *                   cell
 */
public class Cell<Location extends AccidentEvent> implements Comparable {

	private final double LatitudeHi;
	private final double LatitudeLo;
	private final double LongitudeHi;
	private final double LongitudeLo;
	private ArrayList<Location> RegionLst = new ArrayList<Location>();

	/**
	 * Constructor of the cell. The constructor will set the boundaries of the cell
	 * 
	 * @param laH the highest value of the location's possible latitude. If
	 *            exceeded, the location will not be located in the cell if the
	 *            latitude exceed this value
	 * @param laL the lowest value of the location's possible latitude for being
	 *            able to located in the cell
	 * @param loH the highest value of the location's possible longitude value for
	 *            being located into the cell
	 * @param loL the lowest value of the location's possible longitude value for
	 *            being located into the cell
	 */
	public Cell(double laH, double laL, double loH, double loL) {
		LatitudeHi = laH;
		LatitudeLo = laL;
		LongitudeHi = loH;
		LongitudeLo = loL;
	}

	/**
	 * accessor method
	 * 
	 * @return return the field LatitudeHi
	 */
	public double showLatitudeHi() {
		return LatitudeHi;
	}

	/**
	 * accessor method
	 * 
	 * @return return the field LatitudeLo
	 */
	public double showLatitudeLo() {
		return LatitudeLo;
	}

	/**
	 * accessor method
	 * 
	 * @return return the field LongitudeHi
	 */
	public double showLongitudeHi() {
		return LongitudeHi;
	}

	/**
	 * accessor method
	 * 
	 * @return return the field LongitudeLo
	 */
	public double showLongitudeLo() {
		return LongitudeLo;
	}

	/**
	 * accessor method
	 * 
	 * @return return the field Regionlst
	 */
	public ArrayList<Location> showLocation() {
		return RegionLst;
	}

	/**
	 * append the location into the RegionLst
	 * 
	 * @param in the location that will be appended into
	 */
	public void appendLocation(Location in) {
		RegionLst.add(in);
	}


	/**
	 * compareTo for Comparable ADT
	 */
	@Override
	public int compareTo(Object that) {
		if (this.LatitudeLo < ((Region) that).showLatitudeLo())
			return -1;
		if (this.LatitudeLo > ((Region) that).showLatitudeLo())
			return 1;
		if (this.LongitudeLo < ((Region) that).showLongitudeLo())
			return -1;
		if (this.LongitudeLo > ((Region) that).showLongitudeLo())
			return 1;
		return 0;
	}

	/**
	 * return the middle value for the cell's latitude.
	 * 
	 * @return the middle vale of LatitudeHi and LatitudeLo
	 */
	public double getLatitude() {
		return (this.LatitudeHi + this.LatitudeLo) / 2.0;
	}

	/**
	 * return the middle value for the cell's longitude.
	 * 
	 * @return the middle vale of LongitudeHi and LongitudeLo
	 */
	public double getLongtitude() {
		return (this.LongitudeHi + this.LongitudeLo) / 2.0;
	}

	/**
	 * calculate the total score, number of accidents and the average score
	 * 
	 * @return the list containing value mentioned above
	 */
	public double[] getRegionAverage() {
		double sum = 0;
		for (int i = 0; i < this.RegionLst.size(); i++) {
			AccidentEval.Evaluation(this.RegionLst.get(i));
			sum += this.RegionLst.get(i).getScore();
		}
		double[] result = { sum, this.RegionLst.size(), sum / this.RegionLst.size() };
		return result;
	}
}
