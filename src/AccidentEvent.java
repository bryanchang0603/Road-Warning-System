/**
 * the ADT that will be used for as accidents in Read
 * 
 * @author Yachen Wu
 *
 */
public class AccidentEvent implements Comparable {
	private int AUTOMOBILE_COUNT;
	private int INJURY_COUNT;
	private int FATAL_COUNT;
	private int SCHOOL_ZONE;
	private int COLLISION_TYPE;
	private int CURVED_ROAD;
	private int DEER_RELATED;
	private int VHICLE_COUNT;
	private double DEC_LAT;
	private double DEC_LONG;
	private double score;
	/**
	 * constructor of AccidentEvent
	 * 
	 * @param this.AUTOMOBILE_COUNT assigned to AUTOMOBILE_COUNT
	 * @param this.INJURY_COUNT assigned to INJURY_COUNT
	 * @param this.FATAL_COUNT assigned to FATAL_COUNT
	 * @param this.SCHOOL_ZONE assigned to SCHOOL_ZONE
	 * @param this.COLLISION_TYPE assigned to COLLISION_TYPE
	 * @param this.CURVED_ROAD assigned to CURVED_ROAD
	 * @param this.DEER_RELATED assigned to DEER_RELATED
	 * @param this.VHICLE_COUNT assigned to VHICLE_COUNT
	 * @param this.DEC_LAT assigned to DEC_LAT
	 * @param this.DEC_LONG assigned to DEC_LONG
	 * @param set this.score=0
	 */
	public AccidentEvent(int AUTOMOBILE_COUNT, int INJURY_COUNT, int FATAL_COUNT, int SCHOOL_ZONE, int COLLISION_TYPE,
			int CURVED_ROAD, int DEER_RELATED, int VHICLE_COUNT, double DEC_LAT, double DEC_LONG) {
		this.AUTOMOBILE_COUNT = AUTOMOBILE_COUNT;
		this.INJURY_COUNT = INJURY_COUNT;
		this.FATAL_COUNT = FATAL_COUNT;
		this.SCHOOL_ZONE = SCHOOL_ZONE;
		this.COLLISION_TYPE = COLLISION_TYPE;
		this.CURVED_ROAD = CURVED_ROAD;
		this.DEER_RELATED = DEER_RELATED;
		this.VHICLE_COUNT = VHICLE_COUNT;
		this.DEC_LAT = DEC_LAT;
		this.DEC_LONG = DEC_LONG;
		this.score = 0;
	}

	/**
	 * accessor method for AUTOMOBILE_COUNT
	 * 
	 * @return AUTOMOBILE_COUNT
	 */
	public int getAUTOMOBILE_COUNT() {
		return AUTOMOBILE_COUNT;
	}
	/**
	 * accessor method for INJURY_COUNT
	 * 
	 * @return INJURY_COUNT
	 */
	public int getINJURY_COUNT() {
		return INJURY_COUNT;
	}
	/**
	 * accessor method for FATAL_COUNT
	 * 
	 * @return FATAL_COUNT
	 */
	public int getFATAL_COUNT() {
		return FATAL_COUNT;
	}
	/**
	 * accessor method for SCHOOL_ZONE
	 * 
	 * @return SCHOOL_ZONE
	 */
	public int getSCHOOL_ZONE() {
		return SCHOOL_ZONE;
	}
	/**
	 * accessor method for COLLISION_TYPE
	 * 
	 * @return COLLISION_TYPE
	 */
	public int getCOLLISION_TYPE() {
		return COLLISION_TYPE;
	}
	/**
	 * accessor method for CURVED_ROAD
	 * 
	 * @return CURVED_ROAD
	 */
	public int getCURVED_ROAD() {
		return CURVED_ROAD;
	}
	/**
	 * accessor method for DEER_RELATED
	 * 
	 * @return DEER_RELATED
	 */
	public int getDEER_RELATED() {
		return DEER_RELATED;
	}
	/**
	 * accessor method for VHICLE_COUNT
	 * 
	 * @return VHICLE_COUNT
	 */
	public int getVHICLE_COUNT() {
		return VHICLE_COUNT;
	}
	/**
	 * accessor method for DEC_LAT
	 * 
	 * @return DEC_LAT
	 */
	public double getDEC_LAT() {
		return DEC_LAT;
	}
	/**
	 * accessor method for DEC_LONG
	 * 
	 * @return DEC_LONG
	 */
	public double getDEC_LONG() {
		return DEC_LONG;
	}
	/**
	 * accessor method for score
	 * 
	 * @return this.score
	 */
	public double getScore() {
		return this.score;
	}
	/**
	 * mutator for score
	 * 
	 * @return this.score = score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * comparator for LATITUDE AND LONGITUDE
	 * 
	 * @return -1 if this.DEC_LONG and this.DEC_LAT smaller than the other in different AccidentEvent
	 * @return 1 if this.DEC_LONG and this.DEC_LAT greater than the other in different Accident
	 */	 
	@Override
	public int compareTo(Object that) {
		if (this.DEC_LONG < ((AccidentEvent) that).getDEC_LONG())
			return -1;
		if (this.DEC_LONG > ((AccidentEvent) that).getDEC_LONG())
			return 1;
		if (this.DEC_LAT < ((AccidentEvent) that).getDEC_LAT())
			return -1;
		if (this.DEC_LAT > ((AccidentEvent) that).getDEC_LAT())
			return 1;
		return 0;
	}
}