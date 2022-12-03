package hotelCalifornia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Billing {
	// TODO : Generate a RESET method.
	// TODO : Generate a noRoomAvailable method
	// TODO : make parameters final in methods

	public static RoomCategory[] createRoomCategory() {
		RoomCategory[] catArray = new RoomCategory[6];
		catArray[0] = new RoomCategory(1, "Lavabo");
		catArray[1] = new RoomCategory(2, "WC, Télévision");
		catArray[2] = new RoomCategory(3, "Cabine Douche, Télévision");
		catArray[3] = new RoomCategory(4, "WC, Cabine Douche, Télévision");
		catArray[4] = new RoomCategory(5, "WC, Salle de bain + Douche, Télévision");
		catArray[5] = new RoomCategory(6, "2 pièces, Salle de bain + Douche, WC, Télévision");
		return catArray;
	}

	public static Room[] createRoom(final RoomCategory[] catArray) {
		Room[] rooms = new Room[31];
		rooms[0] = new Room(1, catArray[0], 1, 100, true);
		rooms[1] = new Room(2, catArray[1], 1, 120, true);
		rooms[2] = new Room(3, catArray[2], 1, 130, true);
		rooms[3] = new Room(4, catArray[3], 1, 150, true);
		rooms[4] = new Room(5, catArray[0], 2, 130, true);
		rooms[5] = new Room(6, catArray[1], 2, 160, true);
		rooms[6] = new Room(7, catArray[2], 2, 170, true);
		rooms[7] = new Room(8, catArray[3], 2, 190, true);
		rooms[8] = new Room(9, catArray[0], 3, 170, true);
		rooms[9] = new Room(10, catArray[1], 3, 200, true);
		rooms[10] = new Room(11, catArray[2], 3, 210, true);
		rooms[11] = new Room(12, catArray[3], 3, 210, true);
		rooms[12] = new Room(13, catArray[4], 3, 270, true);
		rooms[13] = new Room(14, catArray[5], 3, 350, true);
		rooms[14] = new Room(15, catArray[0], 4, 150, true);
		rooms[15] = new Room(16, catArray[1], 4, 230, true);
		rooms[16] = new Room(17, catArray[2], 4, 240, true);
		rooms[17] = new Room(18, catArray[3], 4, 260, true);
		rooms[18] = new Room(19, catArray[4], 4, 300, true);
		rooms[19] = new Room(20, catArray[5], 4, 400, true);
		rooms[20] = new Room(21, catArray[0], 1, 100, true);
		rooms[21] = new Room(22, catArray[1], 2, 160, true);
		rooms[22] = new Room(23, catArray[0], 2, 130, true);
		rooms[23] = new Room(24, catArray[2], 1, 130, true);
		rooms[24] = new Room(25, catArray[2], 2, 170, true);
		rooms[25] = new Room(26, catArray[3], 4, 260, true);
		rooms[26] = new Room(27, catArray[4], 4, 300, true);
		rooms[27] = new Room(28, catArray[1], 2, 160, true);
		rooms[28] = new Room(29, catArray[3], 3, 230, true);
		rooms[29] = new Room(30, catArray[2], 2, 170, true);
		rooms[30] = new Room(31, catArray[3], 2, 190, true);
		return rooms;
	}

	public static void inputCapacity(final Room[] roomArray, final RoomCategory[] catArray) {
		try {
			Scanner in = new Scanner(System.in);
			int userCapResponse;
			do {
				System.out.println("Indiquez le nombre de personnes (max 4) : ");
				userCapResponse = in.nextInt();
			} while (userCapResponse < 1 || userCapResponse > 4);
			inputCategory(roomArray, catArray, userCapResponse);
		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			inputCapacity(roomArray, catArray);
		}

	}

	private static void inputCategory(final Room[] roomArray, final RoomCategory[] catArray, final int userWantedCap) {
		try {
			Scanner in = new Scanner(System.in);
			int userCatResponse;
			do {
				System.out.println("Choissez le numéro correspondant à la catégorie de chambre souhaitée");
				for (int i = 0; i < catArray.length; i++) {
					System.out.println(catArray[i].getId() + " - " + catArray[i].getDescription());
				}
				userCatResponse = in.nextInt();
			} while (userCatResponse < 1 || userCatResponse > 6);
			filterAvailable(roomArray, catArray, userWantedCap, userCatResponse);
		} catch (InputMismatchException e) {
			System.out.println("___________________________________________________________");
			System.out.println("|Une erreur relative à l'entrée utilisateur s'est produite|");
			System.out.println("|_________________________________________________________|");
			inputCategory(roomArray, catArray, userWantedCap);
		}
	}

	private static void filterAvailable(final Room[] roomArray, final RoomCategory[] catArray, final int cap,
			final int cat) {
		List<Room> availableRooms = new ArrayList<Room>();
		for (int i = 0; i < roomArray.length; i++) {
			if (roomArray[i].isAvailable() == true && roomArray[i].getCategory().getId() == cat
					&& roomArray[i].getCapacity() == cap) {
				availableRooms.add(roomArray[i]);
			}
		}
		displayAvailableRooms(roomArray, catArray, availableRooms);
	}

	private static void displayAvailableRooms(final Room[] roomArray, final RoomCategory[] catArray,
			final List<Room> availableRooms) {
		StringBuilder availRooms = new StringBuilder();
		availRooms.append("Voici la liste des chambres disponible ");
		availRooms.append("\n");
		for (Room room : availableRooms) {
			availRooms.append("Chambre n°");
			availRooms.append(room.getId());
			availRooms.append(", Capacité : ");
			availRooms.append(room.getCapacity());
			availRooms.append(" personnes, Equipements : ");
			availRooms.append(room.getCategory().getDescription());
			availRooms.append(" prix : ");
			availRooms.append(room.getPrice());
			availRooms.append(" €");
			availRooms.append("\n");
		}
		System.out.println(availRooms);
		inputUserChoice(roomArray, catArray, availableRooms);
	}

	private static void inputUserChoice(final Room[] roomArray, final RoomCategory[] catArray,
			final List<Room> availableRooms) {
		Scanner in = new Scanner(System.in);
		System.out.println(
				"Veuillez indiquer le n° de la chambre que vous souhaitez réserver, indiquez 0 pour annuler votre commande.");
		int userRoomChoice = in.nextInt();
		List<Integer> roomNumbers = new ArrayList<Integer>();
		for (Room room : availableRooms) {
			roomNumbers.add(room.getId());
		}
		boolean isValid = false;
		for (int i = 0; i < roomNumbers.size(); i++) {
			if (userRoomChoice == roomNumbers.get(i)) {
				isValid = true;
				roomRenter(roomArray, catArray, userRoomChoice);
				break;
			} else if (userRoomChoice == 0) {
				displayCancel(roomArray, catArray);
			}
		}
		if (isValid == false) {
			displayAvailableRooms(roomArray, catArray, availableRooms);
		}
	}

	private static void roomRenter(final Room[] roomArray, final RoomCategory[] catArray, final int userRoomChoice) {
		for (int i = 0; i < roomArray.length; i++) {
			if (userRoomChoice == roomArray[i].getId()) {
				roomArray[i].setAvailable(false);
				CSVManager.exportCSV(roomArray, catArray);
				displayBillingConfirm(roomArray, catArray, userRoomChoice);
			}
		}
	}

	private static void displayBillingConfirm(final Room[] roomArray, final RoomCategory[] catArray,
			final int userRoomChoice) {
		StringBuilder result = new StringBuilder();
		result.append("Votre réservation de la chambre n°");
		result.append(userRoomChoice);
		result.append(" est confirmée.");
		System.out.println(result);
		Menu.menu(roomArray, catArray);
	}

	private static void displayCancel(final Room[] roomArray, final RoomCategory[] catArray) {
		System.out.println("Your billing has been canceled");
		Menu.menu(roomArray, catArray);
	}

}