
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is used to get user input of location return dangerous level and
 * distance to the user.
 * 
 * @author Zhonglei Wang
 * @version 2.0
 */
public class WarningMessage {
	/**
	 * This method change latitude or longitude from degree representation to radian
	 * representation.
	 * 
	 * @param d Latitude or longitude in degree representation.
	 * @return Latitude or longitude in radian representation.
	 */
	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * This method find the min element from the input array of integers and return
	 * its index.
	 * 
	 * @param array Array of integers
	 * @return Index of minimum integer.
	 */
	static int getMinIndex(int[] array) {
		int ind = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[ind])
				ind = i;
		}
		return ind;
	}

	/**
	 * This method get input location (longitude and latitude), get region which
	 * contain its location and surrounding regions from map. Find all high
	 * accidents locations from all those regions and calculate each distances from
	 * input location. Set distance to each high accident location and sort them by
	 * distance. If all distance are higher than warn range, state that user is safe
	 * at current location. Otherwise, get all high accident locations which inside
	 * warn range and find the one which has the highest dangerous level. State the
	 * distance and level of that high accident location to user.
	 * 
	 * @param args Input of user's location (longitude and latitude).
	 * @throws IOException On input error.
	 */
	public static String message(double latitude, double longitude) throws IOException {
		HighAccidLoca input = new HighAccidLoca(latitude, longitude, 0);
		double warnRange = 500;

		GraphMap m = new GraphMap("data/Map.txt");
		ArrayList<HighAccidLoca> list = m.findRegion(input);
		/*
		for(int x = 0; x < list.size(); x++) {
			System.out.println("la: "+ list.get(x).getLatitude() + " Lo: " + list.get(x).getLongtitude());
		}
		*/
		double[] dislist = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			double r1 = rad(input.getLatitude()) - rad(list.get(i).getLatitude());
			double r2 = rad(input.getLongtitude()) - rad(list.get(i).getLongtitude());
			dislist[i] = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(r1 / 2), 2) + Math.cos(rad(input.getLatitude()))
					* Math.cos(rad(list.get(i).getLatitude())) * Math.pow(Math.sin(r2 / 2), 2))) * 6378137;
			list.get(i).setDistance(dislist[i]);
		}
		
		QuickSortArrayList.sortBasicQuick(list);
		/*
		for(int y = 0; y < list.size(); y++) {
			System.out.println("dis: "+ list.get(y).getDistance());
		}
		*/
		if (list.size() == 0 || list.get(0).getDistance() > warnRange) {
			return ("You are safe at the current location");
		}
		
		else {
			int n = 0;
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).getDistance() <= warnRange)
					n++;
			}
			int[] levellist = new int[n];
			for (int k = 0; k < n; k++) {
				levellist[k] = list.get(k).getLevel();
			}
			int index = getMinIndex(levellist);
			return (String.format("There will be a danger zone with warning "
					+ "level %d in %.2f meters. Please drive carefully!", 
					list.get(index).getLevel(), list.get(index).getDistance()));
		}

	}

}
