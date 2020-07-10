public class AccidentEval {
	/**
	  * calculate the related score for Automobile count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_AUTO(AccidentEvent x) {
		if (x.getAUTOMOBILE_COUNT() == 0) {
			return 0;
		} else if (0 < x.getAUTOMOBILE_COUNT() && x.getAUTOMOBILE_COUNT() <= 3) {
			return 4;
		} else if (3 < x.getAUTOMOBILE_COUNT() && x.getAUTOMOBILE_COUNT() <= 8) {
			return 8;
		} else {
			return 12;
		}
	}

	/**
	  * calculate the related score for the fatal count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_FATAL(AccidentEvent x) {
		if (x.getFATAL_COUNT() == 0) {
			return 0;
		} else {
			return 20;
		}
	}

	/**
	  * calculate the related score for the injury count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_INJURY(AccidentEvent x) {
		if (x.getINJURY_COUNT() == 0) {
			return 0;
		} else if (1 <= x.getINJURY_COUNT() && x.getINJURY_COUNT() <= 15) {
			return 5;
		} else if (16 <= x.getINJURY_COUNT() && x.getINJURY_COUNT() <= 30) {
			return 10;
		} else {
			return 15;
		}
	}

	/**
	  * calculate the related score for the related vehicle count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_VEHICLE(AccidentEvent x) {
		if (x.getVHICLE_COUNT() == 0) {
			return 0;
		} else if (1 <= x.getVHICLE_COUNT() && x.getVHICLE_COUNT() <= 5) {
			return 4;
		} else if (6 <= x.getVHICLE_COUNT() && x.getVHICLE_COUNT() <= 10) {
			return 8;
		} else {
			return 12;
		}
	}

	/**
	  * calculate the related score for the related collision count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_COLLISION(AccidentEvent x) {
		if (x.getCOLLISION_TYPE() == 8) {
			return 11;
		} else if (x.getCOLLISION_TYPE() == 0) {
			return 0;
		} else {
			return 5;
		}
	}

	/**
	  * calculate the related score for the related curved road count
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_CURVED(AccidentEvent x) {
		if (x.getCURVED_ROAD() == 0) {
			return 0;
		} else {
			return 10;
		}
	}
	
	/**
	  * calculate the related score for whether the related area has deers
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_DEER(AccidentEvent x) {
		if (x.getDEER_RELATED() == 0) {
			return 0;
		} else {
			return 5;
		}
	}

	/**
	  * calculate the related score for whether the related area has schools
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
	  * @return an integer which represents the score
      */
	private static int Eval_SCHOOL(AccidentEvent x) {
		if (x.getSCHOOL_ZONE() == 0) {
			return 0;
		} else {
			return 15;
		}
	}

	/**
	  * calculate the total scores for an accident event
	  * @author Di Wu
	  * @param x the accident event that need to be calculated
     */
	public static void Evaluation(AccidentEvent x) {
		int A1 = Eval_AUTO(x);
		int A2 = Eval_FATAL(x);
		int A3 = Eval_INJURY(x);
		int A4 = Eval_VEHICLE(x);
		int A5 = Eval_COLLISION(x);
		int A6 = Eval_CURVED(x);
		int A7 = Eval_DEER(x);
		int A8 = Eval_SCHOOL(x);
		int score = A1 + A2 + A3 + A4 + A5 + A6 + A7 + A8;
		x.setScore(score);
	}
}
