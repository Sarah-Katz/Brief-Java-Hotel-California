package hotelCalifornia;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	/**
	 * TODO : doc
	 */
	protected static void importCSV(final Room[] roomArray, final RoomCategory[] catArray) {
		try {
			List<Room> newRoomList = new ArrayList<>();
			Room[] newRoomArray = new Room[31];
			File file = new File("Liste_des_chambres.csv");
			Scanner in = new Scanner(file);
			in.nextLine(); // Skips the first line in the .CSV to have an exception cause by non decimal
							// characters in rows where Integers are wanted
			while (in.hasNext()) {
				String str = in.nextLine();
				String[] roomInfo = str.split(DELIMITER);
				String number = roomInfo[0];
				String category = roomInfo[1];
				String capacity = roomInfo[2];
				String price = roomInfo[3];
				String availability = roomInfo[4];
				Integer roomId;
				Integer roomCategory;
				Integer roomCapacity;
				Integer roomPrice;
				Boolean roomAvailability;
				try {
					roomId = Integer.valueOf(number);
				} catch (NumberFormatException errId) {
					roomId = 0;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur la chambre : ").append(roomInfo[0]).append("\n")
							.append("Numéro de chambre invalide, nouvelle entrée = 0");
					System.out.println(error);
				}
				try {
					roomCategory = Integer.valueOf(category);
				} catch (NumberFormatException errCopies) {
					roomCategory = 0;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur la chambre ").append(roomInfo[0]).append("\n")
							.append("Catégorie invalide, nouvelle entrée = 0");
					System.out.println(error);
				}
				try {
					roomCapacity = Integer.valueOf(capacity);
				} catch (NumberFormatException errCopies) {
					roomCapacity = 0;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur la chambre : ").append(roomInfo[0]).append("\n")
							.append("Capacité invalide, nouvelle entrée = 0");
					System.out.println(error);
				}
				try {
					roomPrice = Integer.valueOf(price);
				} catch (NumberFormatException errCopies) {
					roomPrice = 0;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur la chambre : ").append(roomInfo[0]).append("\n")
							.append("Prix invalide, nouvelle entrée = 0");
					System.out.println(error);
				}
				try {
					roomAvailability = Boolean.valueOf(availability);
				} catch (NumberFormatException errCopies) {
					roomAvailability = false;
					StringBuilder error = new StringBuilder();
					error.append("Erreur sur la chambre : ").append(roomInfo[0]).append("\n")
							.append("disponibilité invalide, nouvelle entrée = faux");
					System.out.println(error);
				}
				
				
				Room room = new Room(roomId, catArray[roomCategory- 1], roomCapacity, roomPrice, roomAvailability);
				newRoomList.add(room);
				newRoomArray = newRoomList.toArray(new Room[31]);
			}
			System.out.println("Liste importée !");
			Menu.menu(newRoomArray, catArray);
		} catch (IOException e) {
			System.out.println("________________________________");
			System.out.println("|                              |");
			System.out.println("| /!\\  Fichier inexistant /!\\  |");
			System.out.println("|______________________________|");
			System.out.println("__________________________________________________________________________________");
			System.out.println("|                                                                                |");
			System.out.println("|Pour importer un fichier, déplacez-le à la racine du programme et nommez-le :   |");
			System.out.println("|                           Liste_des_chambres.csv                               |");
			System.out.println("|________________________________________________________________________________|");
			Menu.menu(roomArray, catArray);
		}
		catch (NumberFormatException e) {
			System.out.println("___________________________________________________________________________________");
			System.out.println("|                                                                                 |");
			System.out.println("|Une erreur existe dans le fichier, veuillez verifier ses données et son formatage|");
			System.out.println("|_________________________________________________________________________________|");
			Menu.menu(roomArray, catArray);
		}
	}
}
