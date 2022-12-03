package hotelCalifornia;

import java.io.FileWriter;
import java.io.IOException;

/**
 * This class contains methods used to export and import CSV files containing
 * informations on the rooms
 * 
 * @author Sarah Katz
 *
 */
public class CSVManager {
	private static final String DELIMITER = ",";
	private static final String SEPARATOR = "\n";
	private static final String HEADER = "Numéro de chambre,Catégorie,Capacité,Prix,Disponible";

	protected static void exportCSV(final Room[] roomArray, final RoomCategory[] catArray) {
		FileWriter roomListCSV = null;
		try {
			roomListCSV = new FileWriter("Liste_des_chambres.csv");
			roomListCSV.append(HEADER).append(SEPARATOR);
			for (Room room : roomArray) {
				int roomId = room.getId();
				String idString = Integer.toString(roomId);
				int price = room.getPrice();
				String priceString = Integer.toString(price);
				int category = room.getCategory().getId();
				String categoryString = Integer.toString(category);
				int capacity = room.getCapacity();
				String capacityString = Integer.toString(capacity);
				boolean available = room.isAvailable();
				String availString = Boolean.toString(available);
				roomListCSV.append(idString).append(DELIMITER);
				roomListCSV.append(categoryString).append(DELIMITER);
				roomListCSV.append(capacityString).append(DELIMITER);
				roomListCSV.append(priceString).append(DELIMITER);
				roomListCSV.append(availString).append(SEPARATOR);
			}
			roomListCSV.close();

		} catch (IOException e1) {
			System.out.println("__________________________________________________________");
			System.out.println("|Une erreur relative à l'export du fichier s'est produite|");
			System.out.println("|________________________________________________________|");
			Menu.menu(roomArray, catArray);
		}
	}
}
