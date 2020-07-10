import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		double latitude = Double.parseDouble(args[0]);
		double longitude = Double.parseDouble(args[1]);

		ArrayList<AccidentEvent> accidentArray = Read.ReadAccident();
		ArrayList<HighAccidLoca> highAccidentLoca = AccidentIdntfy.accidentIdentify(accidentArray);
		GraphMap Map = new GraphMap(41.1, 40, -74.8, -80.5, 0.05, 0.05);

		for (int i = 0; i < highAccidentLoca.size(); i++) {
			Map.appendLocation(highAccidentLoca.get(i));
		}
		Map.Export("data/Map.txt");

		String message = WarningMessage.message(latitude, longitude);
		System.out.print(message);
	}
}
