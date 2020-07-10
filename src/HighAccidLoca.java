
/**
 * The High Accident Location ADT. The ADT contains the information about the
 * high accident location, like latitude, longitude, level, and distance.
 * 
 * @author Xinyu Huang, Lab 01
 * @version 1.2
 */
public class HighAccidLoca implements Comparable<HighAccidLoca> {
	private double latitude;
	private double longitude;
	private int level;
	private double distance;

	/**
	 * The constructor of the HighAccidLoca
	 * 
	 * @param latitude - The latitude of the location
	 * @param longitude - The longitude of the location
	 * @param level - the level of the High Accident Location
	 */
	public HighAccidLoca(double latitude, double longitude, int level) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.level = level;
	}

	/**
	 * Return the latitude of the location
	 * 
	 * @return The latitude of the location
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * Return the longitude of the location
	 * 
	 * @return The longitude of the location
	 */
	public double getLongtitude() {
		return longitude;
	}

	/**
	 * Return the level of the location
	 * 
	 * @return The level of the location
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * Return the distance of the location
	 * 
	 * @return The distance of the location
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * Set the distance of the location
	 * 
	 * @param distance - the distance from the current point to this location
	 */
	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 * toString() method shows the  information of the location
	 * 
	 * @return The information of the location
	 */
	public String toString() {
		String s = "Latitude: " + latitude + "  Longitude: " + longitude + "  Level: " + level;
		return s;
	}

	/**
	 * compareTo() method provide the distance compare method for two locations.
	 * 
	 * @return The compared result between this location and that location.
	 */
	@Override
	public int compareTo(HighAccidLoca that) {
		if (this.distance < that.getDistance())
			return -1;
		if (this.distance > that.getDistance())
			return 1;
		return 0;
	}
}
