import java.util.ArrayList;

public class QuickSortArrayList {

	/**
	  * exchange the two items in the arraylist
	  * @author Di Wu
	  * @param x the arraylist that need to be regulated
	  * @param i the first location of item in the arraylist
	  * @param j the first location of item in the arraylist
      */
	private static void exch(ArrayList<HighAccidLoca> x, int i, int j) {
		HighAccidLoca t = x.get(i);
		HighAccidLoca q = x.get(j);
		x.set(j, t);
		x.set(i, q);
	}

	/**
	  * determine whether x1 is smaller than x2
	  * @author Di Wu
	  * @param x1 the first item that need to be compared
	  * @param x2 the second item that need to be compared
	  * @return true if x1 is less than x2
      */
	private static boolean less(HighAccidLoca x1, HighAccidLoca x2) {
		return x1.compareTo(x2) < 0;
	}
	
	/**
	  * get the input arraylist from the user
	  * @author Di Wu
	  * @param x the arraylist that needs to be sorted
      */
	public static void sortBasicQuick(ArrayList<HighAccidLoca> x) {
		sort(x, 0, x.size() - 1);
	}
	
	/**
	  * sort the arraylist based on the head and tail
	  * @author Di Wu
	  * @param a the arraylist that need to be sorted
	  * @param head the head value in the quick sort
	  * @param tail the tail value in the quick sort
      */
	private static void sort(ArrayList<HighAccidLoca> a, int head, int tail) {
		if (tail <= head) {
			return;
		}
		int x = head, y = tail + 1;
		HighAccidLoca v = a.get(head);
		while (true) {
			while (less(a.get(++x), v)) {
				if (x == tail) {
					break;
				}
			}
			while (less(v, a.get(--y))) {
				if (y == head) {
					break;
				}
			}
			if (x >= y) {
				break;
			}
			exch(a, x, y);
		}
		exch(a, head, y);
		int j = y;
		sort(a, head, j - 1);
		sort(a, j + 1, tail);
	}
	
	/**
	  * cgeck whether the related array list is sorted
	  * @author Di Wu
	  * @param a the arraylist that need to be checked
	  * @return true is all of the items in the array list is in order
      */
	public static boolean isSorted(ArrayList<HighAccidLoca> a) {
		for(int i = 0; i < a.size()-1; i++) {
			if(a.get(i).compareTo(a.get(i+1)) > 0) {
				return false;
			}
		}
		return true;
	}
}
