import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * The graph that will be used by the client to produce the final result
 * 
 * @author Baosheng Chang
 *
 * @param <Location> the type of ADT that is going to be used for the vertex
 */
public class GraphMap<Location extends HighAccidLoca> {
	private ArrayList<ArrayList<Region>> Map = new ArrayList<ArrayList<Region>>();
	private ArrayList[][] adj;

	/**
	 * construct all the vertices of the graph graphMap without input the txt file
	 * 
	 * @param LaHi    the max latitude of the graph
	 * @param LaLo    the min latitude of the graph
	 * @param LoHi    the max longitude of the graph
	 * @param LoLo    the min longitude of the graph
	 * @param DeltaLa the difference between vertex's LatitudeHi and LatitudeLo
	 * @param DeltaLo the difference between vertex's LongitudeHi and LongitudeLo
	 */
	public GraphMap(double LaHi, double LaLo, double LoHi, double LoLo, double DeltaLa, double DeltaLo) {
		for (double i = LaLo; i <= LaHi; i += DeltaLa) {
			double LaL = i;
			double LaH = i + DeltaLa;
			ArrayList<Region> tempArray = new ArrayList<Region>();
			for (double j = LoLo; j <= LoHi; j += DeltaLo) {
				double LoL = j;
				double LoH = j + DeltaLo;
				Region tempRegion = new Region(LaH, LaL, LoH, LoL);
				tempArray.add(tempRegion);
			}
			Map.add(tempArray);
		}
		this.adj = new ArrayList[Map.size()][Map.get(0).size()];
		addedges();
	}

	/**
	 * construct the graph graphMap from the inputFile. All locations are added into
	 * the graph as well
	 * 
	 * @param inputFile the txt file that contain all the information
	 * @throws IOException
	 */
	public GraphMap(String inputFile) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(inputFile));
		String line = f.readLine();
		ArrayList<Region> initlizedArray = new ArrayList<Region>();
		if (line != null) {
			String[] regionInfo = line.split(",");
			Region tempRegion = new Region(Double.parseDouble(regionInfo[0]), Double.parseDouble(regionInfo[1]),
					Double.parseDouble(regionInfo[2]), Double.parseDouble(regionInfo[3]));
			for (int i = 4; i < regionInfo.length - 3; i += 3) {
				HighAccidLoca tempLoc = new HighAccidLoca(Double.parseDouble(regionInfo[i]),
						Double.parseDouble(regionInfo[i + 1]), Integer.parseInt(regionInfo[i + 2]));
				tempRegion.appendLocation(tempLoc);
			}
			Map.add(initlizedArray);
			Map.get(0).add(tempRegion);
		}
		int m = 0;
		int j = 0;
		line = f.readLine();
		while (line != null) {
			String[] regionInfo = line.split(",");
			Region tempRegion = new Region(Double.parseDouble(regionInfo[0]), Double.parseDouble(regionInfo[1]),
					Double.parseDouble(regionInfo[2]), Double.parseDouble(regionInfo[3]));
			for (int i = 4; i < regionInfo.length; i += 3) {
				HighAccidLoca tempLoc = new HighAccidLoca(Double.parseDouble(regionInfo[i]),
						Double.parseDouble(regionInfo[i + 1]), Integer.parseInt(regionInfo[i + 2]));
				tempRegion.appendLocation(tempLoc);
			}
			double appendingLatitude = tempRegion.showLatitudeHi() * 100;
			appendingLatitude = Math.round(appendingLatitude);
			double currentLatitude = Map.get(m).get(0).showLatitudeHi() * 100;
			currentLatitude = Math.round(currentLatitude);
			if (appendingLatitude == currentLatitude)
				Map.get(m).add(tempRegion);
			else {
				m++;
				initlizedArray = new ArrayList<Region>();
				Map.add(initlizedArray);
				Map.get(m).add(tempRegion);
			}
			line = f.readLine();
		}
		f.close();
		this.adj = new ArrayList[Map.size()][Map.get(0).size()];
		addedges();
	}
	/**
	 * accessor method for adj list
	 * @return the adjacent list for all vertices of the graph
	 */
	public ArrayList[][] showAdj(){
		return adj;
	}

	/**
	 * add edges for all vertices to all other vertices next to it
	 */
	private void addedges() {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[0].length; j++) {
				adj[i][j] = new ArrayList<Integer>();
				if (i == 0) {
					adj[i][j].add((i + 1) * 10 + j);
					if (j == 0) {
						adj[i][j].add((i + 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
					} else if (j == adj[0].length - 1) {
						adj[i][j].add((i + 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
					} else {
						adj[i][j].add((i + 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
						adj[i][j].add((i + 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
					}
				} else if (i == adj.length - 1) {
					adj[i][j].add((i - 1) * 10 + j);
					if (j == 0) {
						adj[i][j].add((i - 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
					} else if (j == adj[0].length - 1) {
						adj[i][j].add((i - 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
					} else {
						adj[i][j].add((i - 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
						adj[i][j].add((i - 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
					}
				} else {
					adj[i][j].add((i + 1) * 10 + j);
					adj[i][j].add((i - 1) * 10 + j);
					if (j == 0) {
						adj[i][j].add((i - 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
						adj[i][j].add((i + 1) * 10 + j + 1);
					} else if (j == adj[0].length - 1) {
						adj[i][j].add((i - 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
						adj[i][j].add((i + 1) * 10 + j - 1);
					} else {
						adj[i][j].add((i - 1) * 10 + j - 1);
						adj[i][j].add(i * 10 + j - 1);
						adj[i][j].add((i + 1) * 10 + j - 1);
						adj[i][j].add((i - 1) * 10 + j + 1);
						adj[i][j].add(i * 10 + j + 1);
						adj[i][j].add((i + 1) * 10 + j + 1);
					}
				}
			}
		}
	}

	/**
	 * accessor method to return the graph ArrayList<ArrayList<Region>>
	 * 
	 * @return return the private variable map
	 */
	public ArrayList<ArrayList<Region>> showMap() {
		return Map;
	}

	/**
	 * find the vertex that the input is located at and return all locations in that
	 * vertex and vertices adjacent to it
	 * 
	 * @param current the input location
	 * @return the ArrayList of location that are in the specific vertex and
	 *         vertices adjacent to it
	 */
	public ArrayList<Location> findRegion(Location current) {
		int targetRegion_La = -1;
		int targetRegion_Lo = -1;
		ArrayList<Location> possibleLocation = new ArrayList<Location>();
		boolean foundLa = false;
		int midLa = Map.size() / 2;
		int lowLa = 0;
		int highLa = Map.size() - 1;
		do {
			double guessLaLo = Map.get(midLa).get(0).showLatitudeLo();
			double guessLaHi = Map.get(midLa).get(0).showLatitudeHi();
			if (current.getLatitude() >= guessLaLo && current.getLatitude() <= guessLaHi) {
				targetRegion_La = midLa;
				foundLa = true;
				boolean foundLo = false;
				int midLo = Map.get(midLa).size() / 2;
				int lowLo = 0;
				int highLo = Map.get(midLa).size();
				do {
					double guessLoLo = Map.get(midLa).get(midLo).showLongitudeLo();
					double guessLoHi = Map.get(midLa).get(midLo).showLongitudeHi();
					if (current.getLongtitude() >= guessLoLo && current.getLongtitude() <= guessLoHi) {
						targetRegion_Lo = midLo;
						foundLo = true;
					} else if (current.getLongtitude() < guessLoLo) {
						highLo = midLo - 1;
						midLo = (lowLo + highLo) / 2;
					} else if (current.getLongtitude() > guessLoHi) {
						lowLo = midLo + 1;
						midLo = (lowLo + highLo) / 2;
					}
				} while (foundLo == false);
			} else if (current.getLatitude() < guessLaLo) {
				highLa = midLa - 1;
				midLa = (lowLa + highLa) / 2;
			} else if (current.getLatitude() > guessLaHi) {
				lowLa = midLa + 1;
				midLa = (lowLa + highLa) / 2;
			}
		} while (foundLa == false);

		if (targetRegion_La == -1 || targetRegion_Lo == -1) {
			return possibleLocation;
		}

		possibleLocation.addAll(Map.get(targetRegion_La).get(targetRegion_Lo).showLocation());
		ArrayList<Integer> adjRegion = adj[targetRegion_La][targetRegion_Lo];
		possibleLocation.addAll(ModifiedBFS(adjRegion));
		return possibleLocation;
	}

	/**
	 * Modified BFS, will access all adjacent vertices to the input vertex and out
	 * put the ArrayList containing all locations in these vertices
	 * 
	 * @param adjRegion the input location
	 * @return all locations in all adjacent vertices
	 */
	private ArrayList<Location> ModifiedBFS(ArrayList<Integer> adjRegion) {
		ArrayList<Location> outputList = new ArrayList<Location>();
		for (int k = 0; k < adjRegion.size(); k++) {
			int LaIndex = adjRegion.get(k) / 10;
			int LoIndex = adjRegion.get(k) % 10;
			outputList.addAll(Map.get(LaIndex).get(LoIndex).showLocation());
		}
		return outputList;
	}

	/**
	 * append the location in the required vertex
	 * 
	 * @param in the location that need to be appended
	 */
	public void appendLocation(Location in) {
		boolean foundLa = false;
		int midLa = Map.size() / 2;
		int lowLa = 0;
		int highLa = Map.size() - 1;
		int midLo = 0;
		do {
			double guessLaLo = Map.get(midLa).get(0).showLatitudeLo();
			double guessLaHi = Map.get(midLa).get(0).showLatitudeHi();
			if (in.getLatitude() > guessLaLo && in.getLatitude() <= guessLaHi) {
				foundLa = true;
				boolean foundLo = false;
				midLo = Map.get(midLa).size() / 2;
				int lowLo = 0;
				int highLo = Map.get(midLa).size();
				do {
					double guessLoLo = Map.get(midLa).get(midLo).showLongitudeLo();
					double guessLoHi = Map.get(midLa).get(midLo).showLongitudeHi();
					if (in.getLongtitude() > guessLoLo & in.getLongtitude() <= guessLoHi) {
						this.Map.get(midLa).get(midLo).appendLocation(in);
						foundLo = true;
						/*
						 * System.out.println("locaAppended" + midLa + "\t" + midLo + "\t" +
						 * Map.get(midLa).get(midLo).showLocation().size());
						 */
					} else if (in.getLongtitude() <= guessLoLo) {
						highLo = midLo - 1;
						midLo = (lowLo + highLo) / 2;
					} else if (in.getLongtitude() > guessLoHi) {
						lowLo = midLo + 1;
						midLo = (lowLo + highLo) / 2;
					}
				} while (foundLo == false);
			} else if (in.getLatitude() <= guessLaLo) {
				highLa = midLa - 1;
				midLa = (lowLa + highLa) / 2;
			} else if (in.getLatitude() > guessLaHi) {
				lowLa = midLa + 1;
				midLa = (lowLa + highLa) / 2;
			}
		} while (foundLa == false);
	}

	/**
	 * the writer method to write the graph graphMap to the given location
	 * 
	 * @param file the required location that the graphMap need to be writen to.
	 * @throws IOException
	 */
	public void Export(String file) throws IOException {
		File f = new File(file);
		Writer wr = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < Map.size(); i++) {
			for (int j = 0; j < Map.get(i).size(); j++) {
				Region tempRegion = Map.get(i).get(j);
				wr.write(String.valueOf(tempRegion.showLatitudeHi()) + ",");
				wr.write(String.valueOf(tempRegion.showLatitudeLo()) + ",");
				wr.write(String.valueOf(tempRegion.showLongitudeHi()) + ",");
				wr.write(String.valueOf(tempRegion.showLongitudeLo()));
				for (int k = 0; k < tempRegion.showLocation().size(); k++) {
					ArrayList<Location> templocation = tempRegion.showLocation();
					wr.write("," + String.valueOf(templocation.get(k).getLatitude()));
					wr.write("," + String.valueOf(templocation.get(k).getLongtitude()));
					wr.write("," + String.valueOf(templocation.get(k).getLevel()));
				}
				wr.write("\n");
			}
		}
		wr.close();
	}

	public static void main(String[] args) throws IOException {
		ArrayList<AccidentEvent> accidentArray = Read.ReadAccident();
		ArrayList<HighAccidLoca> highAccidentLoca = AccidentIdntfy.accidentIdentify(accidentArray);
		GraphMap testMap = new GraphMap(41.1, 40, -74.8, -80.5, 0.05, 0.05);

		for (int i = 0; i < highAccidentLoca.size(); i++) {
			testMap.appendLocation(highAccidentLoca.get(i));
		}
		ArrayList<ArrayList<Region>> checking2 = testMap.showMap();
		testMap.Export("data/Map.txt");
	}
}
