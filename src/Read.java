
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to get the dangerous locations in the data set
 * return as an AccidentEvent ADT with all the informations needed.
 * @author Yachen Wu
 */
public class Read {
	/**
	 * This method uses buffer reader read through the information in the given csv file
	 * return as an array list of AccidentEvents
	 */
	public static ArrayList<AccidentEvent> ReadAccident() throws NumberFormatException, IOException {
		ArrayList<AccidentEvent> accidents = new ArrayList<AccidentEvent>();

		int AUTOMOBILE_COUNT;
		int INJURY_COUNT;
		int FATAL_COUNT;
		int SCHOOL_ZONE;
		int COLLISION_TYPE;
		int CURVED_ROAD;
		int DEER_RELATED;
		int VHICLE_COUNT;
		double DEC_LAT;
		double DEC_LONG;

		String csvFile = "Dataset/Allegheny_Crash_Data.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		br = new BufferedReader(new FileReader(csvFile));
		String firstLine = br.readLine();
		String[] header = firstLine.split(",");
		while ((line = br.readLine()) != null) {

			String[] country = line.split(cvsSplitBy);
			/*
			System.out.println("Country [COLLISION_TYPE=" + country[13] + ",VHICLE_COUNT=" + country[23]
					+ "INJURY_COUNT=" + country[33] + " CURVED_ROAD=" + country[1] + "LATITUDE=" + country[63]
					+ " LONGITUDE=" + country[64] + "  DEER_RELATED=" + country[65] + "AUTOMOBILE_COUNT= "
					+ country[24] + " , FATAL_COUNT=" + country[32] + "INJURY_COUNT=" + country[33] + "FATAL_COUNT="
					+ country[32] + "DEER_RELATED=" + country[118] + "]");
			System.out.println(country[63].length() + "\t" + country[64].length());
			*/
			if (country[63].length() != 0 && country[64].length() != 0) {
				COLLISION_TYPE = Integer.parseInt(country[13]);
				VHICLE_COUNT = Integer.parseInt(country[23]);
				AUTOMOBILE_COUNT = Integer.parseInt(country[24]);
				FATAL_COUNT = Integer.parseInt(country[32]);
				INJURY_COUNT = Integer.parseInt(country[33]);
				DEC_LAT = Double.parseDouble(country[63]);
				DEC_LONG = Double.parseDouble(country[64]);
				SCHOOL_ZONE = Integer.parseInt(country[111]);
				CURVED_ROAD = Integer.parseInt(country[149]);
				DEER_RELATED = Integer.parseInt(country[162]);

				AccidentEvent accident = new AccidentEvent(AUTOMOBILE_COUNT, INJURY_COUNT, FATAL_COUNT, SCHOOL_ZONE,
						COLLISION_TYPE, CURVED_ROAD, DEER_RELATED, VHICLE_COUNT, DEC_LAT, DEC_LONG);
				accidents.add(accident);
			}

		}
		br.close();
		return accidents;
	}
	
	/**
	 * This method print out the information stored in the AccidentEvent ADT to test the result is correct or not
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		ArrayList<AccidentEvent> accidents = ReadAccident();
		AccidentEvent first = accidents.get(0);
		System.out.println(first.getCOLLISION_TYPE() + "\t" + first.getVHICLE_COUNT() +"\t"+ first.getAUTOMOBILE_COUNT());
		System.out.println(first.getFATAL_COUNT() + "\t" + first.getINJURY_COUNT() +"\t"+ first.getDEC_LAT() +"\t"+ first.getDEC_LONG());
		System.out.println(first.getSCHOOL_ZONE() + "\t" + first.getCURVED_ROAD() +"\t"+ first.getDEER_RELATED());
		int size = accidents.size();
		System.out.println(size);
		first = accidents.get(160282);
		System.out.println(first.getCOLLISION_TYPE() + "\t" + first.getVHICLE_COUNT() +"\t"+ first.getAUTOMOBILE_COUNT());
		System.out.println(first.getFATAL_COUNT() + "\t" + first.getINJURY_COUNT() +"\t"+ first.getDEC_LAT() +"\t"+ first.getDEC_LONG());
		System.out.println(first.getSCHOOL_ZONE() + "\t" + first.getCURVED_ROAD() +"\t"+ first.getDEER_RELATED());
	}
}
