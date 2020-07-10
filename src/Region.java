
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * the ADT that will be used for as vertices in graphMap
 * 
 * @author Baosheng Chang
 *
 * @param <Location> the type of ADT that will be stored in Region ADT
 */
public class Region<Location extends HighAccidLoca> implements Comparable {

	private final double LatitudeHi;
	private final double LatitudeLo;
	private final double LongitudeHi;
	private final double LongitudeLo;
	private ArrayList<Location> RegionLst = new ArrayList<Location>();

	/**
	 * constructor of Region
	 * 
	 * @param LaHi the value going to be assigned to LatitudeHi
	 * @param LaLo the value going to be assigned to LatitudeLo
	 * @param LoHi the value going to be assigned to LongitudeHi
	 * @param LoLo the value going to be assigned to LongitudeLo
	 */
	public Region(double LaHi, double LaLo, double LoHi, double LoLo) {
		LatitudeHi = LaHi;
		LatitudeLo = LaLo;
		LongitudeHi = LoHi;
		LongitudeLo = LoLo;
	}

	/**
	 * accessor method for LatitudeHi
	 * 
	 * @return this.LatitudeHi
	 */
	public double showLatitudeHi() {
		return LatitudeHi;
	}

	/**
	 * accessor method for LatitudeLo
	 * 
	 * @return this.LatitudeLo
	 */
	public double showLatitudeLo() {
		return LatitudeLo;
	}

	/**
	 * accessor method for LongitudeHi
	 * 
	 * @return this.LongitudeHi
	 */
	public double showLongitudeHi() {
		return LongitudeHi;
	}

	/**
	 * accessor method for LongitudeLo
	 * 
	 * @return this.LongitudeLo
	 */
	public double showLongitudeLo() {
		return LongitudeLo;
	}

	/**
	 * accessor method for RegionLst
	 * 
	 * @return this.RegionLst
	 */
	public ArrayList<Location> showLocation() {
		return RegionLst;
	}

	/**
	 * append the given location into the Region
	 * @param in the location that need to be appended in to the Region
	 */
	public void appendLocation(Location in) {
		RegionLst.add(in);
	}

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

}
