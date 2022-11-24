package hotelCalifornia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Billing {
	// TODO : Generate a RESET method.
	// TODO : static Room[] roomArray =
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

	public static Room[] createRoom(RoomCategory[] catArray) {
		Room[] rooms = new Room[31];
		rooms[0] = new Room(1, catArray[0], 1, 100, true, false, false);
		rooms[1] = new Room(2, catArray[1], 1, 120, true, false, false);
		rooms[2] = new Room(3, catArray[2], 1, 130, true, false, false);
		rooms[3] = new Room(4, catArray[3], 1, 150, true, false, false);
		rooms[4] = new Room(5, catArray[0], 2, 130, true, false, false);
		rooms[5] = new Room(6, catArray[1], 2, 160, true, false, false);
		rooms[6] = new Room(7, catArray[2], 2, 170, true, false, false);
		rooms[7] = new Room(8, catArray[3], 2, 190, true, false, false);
		rooms[8] = new Room(9, catArray[0], 3, 170, true, false, false);
		rooms[9] = new Room(10, catArray[1], 3, 200, true, false, false);
		rooms[10] = new Room(11, catArray[2], 3, 210, true, false, false);
		rooms[11] = new Room(12, catArray[3], 3, 210, true, false, false);
		rooms[12] = new Room(13, catArray[4], 3, 270, true, false, false);
		rooms[13] = new Room(14, catArray[5], 3, 350, true, false, false);
		rooms[14] = new Room(15, catArray[0], 4, 150, true, false, false);
		rooms[15] = new Room(16, catArray[1], 4, 230, true, false, false);
		rooms[16] = new Room(17, catArray[2], 4, 240, true, false, false);
		rooms[17] = new Room(18, catArray[3], 4, 260, true, false, false);
		rooms[18] = new Room(19, catArray[4], 4, 300, true, false, false);
		rooms[19] = new Room(20, catArray[5], 4, 400, true, false, false);
		rooms[20] = new Room(21, catArray[0], 1, 100, true, false, false);
		rooms[21] = new Room(22, catArray[1], 2, 160, true, false, false);
		rooms[22] = new Room(23, catArray[0], 2, 130, true, false, false);
		rooms[23] = new Room(24, catArray[2], 1, 130, true, false, false);
		rooms[24] = new Room(25, catArray[2], 2, 170, true, false, false);
		rooms[25] = new Room(26, catArray[3], 4, 260, true, false, false);
		rooms[26] = new Room(27, catArray[4], 4, 300, true, false, false);
		rooms[27] = new Room(28, catArray[1], 2, 160, true, false, false);
		rooms[28] = new Room(29, catArray[3], 3, 230, true, false, false);
		rooms[29] = new Room(30, catArray[2], 2, 170, true, false, false);
		rooms[30] = new Room(31, catArray[3], 2, 190, true, false, false);
		return rooms;
	}

	public static int inputCapacity(Room[] roomArray, RoomCategory[] catArray) {
		Scanner in = new Scanner(System.in);
		int userCapResponse;
		do {
			System.out.println("Indiquez le nombre de personnes (max 4) : ");
			userCapResponse = in.nextInt();
		} while (userCapResponse < 1 || userCapResponse > 4);
		return userCapResponse;
	}

	public static int inputCategory(Room[] roomArray, RoomCategory[] catArray) {
		Scanner in = new Scanner(System.in);
		int userCatResponse;
		do {
			System.out.println("Choissez le numéro correspondant à la catégorie de chambre souhaitée");
			for (int i = 0; i < catArray.length; i++) {
				System.out.println(catArray[i].getId() + " - " + catArray[i].getDescription());
			}
			userCatResponse = in.nextInt();
		} while (userCatResponse < 1 || userCatResponse > 6);
		return userCatResponse;
	}

	public static void filterAvailable(Room[] roomArray, RoomCategory[] catArray, int cap, int cat) {
		List<Room> availableRooms = new ArrayList<Room>();
		for (int i = 0; i < roomArray.length; i++) {
			if (roomArray[i].isAvailable() == true && roomArray[i].getCategory().getId() == cat
					&& roomArray[i].getCapacity() == cap) {
				availableRooms.add(roomArray[i]);
			}
		}
		displayAvailableRooms(roomArray, catArray, availableRooms);
	}

	public static void displayAvailableRooms(Room[] roomArray, RoomCategory[] catArray, List<Room> availableRooms) {
		StringBuilder userChoice = new StringBuilder();
		userChoice.append("Voici la liste des chambres disponible ");
		userChoice.append("\n");
		for (Room room : availableRooms) {
			userChoice.append("Chambre n°");
			userChoice.append(room.getId());
			userChoice.append(", Capacité : ");
			userChoice.append(room.getCapacity());
			userChoice.append(" personnes, Equipements : ");
			userChoice.append(room.getCategory().getDescription());
			userChoice.append(" prix : ");
			userChoice.append(room.getPrice());
			userChoice.append(" €");
			userChoice.append("\n");
		}
		System.out.println(userChoice);
		userChoice.toString();
		inputUserChoice(roomArray, catArray, availableRooms);
	}

	public static void inputUserChoice(Room[] roomArray, RoomCategory[] catArray, List<Room> availableRooms) {
		Scanner in = new Scanner(System.in);
		System.out.println(
				"Veuillez indiquer le n° de la chambre que vous souhaitez reserver, indiquez 0 pour annuler votre commande.");
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

	public static void roomRenter(Room[] roomArray, RoomCategory[] catArray, int userRoomChoice) {
		for (int i = 0; i < roomArray.length; i++) {
			if (userRoomChoice == roomArray[i].getId()) {
				roomArray[i].setAvailable(false);
				displayBillingConfirm(roomArray, catArray, userRoomChoice);
			}
		}
	}

	public static void displayBillingConfirm(Room[] roomArray, RoomCategory[] catArray, int userRoomChoice) {
		StringBuilder result = new StringBuilder();
		result.append("Votre réservation de la chambre n°");
		result.append(userRoomChoice);
		result.append(" est confirmée.");
		System.out.println(result);
		Tester.program(roomArray, catArray);
	}
	
	public static void displayCancel(Room[] roomArray, RoomCategory[] catArray) {
		System.out.println("Your billing has been canceled");
		Tester.program(roomArray, catArray);
	}
	
	public static void reset(Room[] roomArray, RoomCategory[] catArray) {
		System.out.println("---");
		System.out.println("---");
		System.out.println("Retour début de programme");
		System.out.println("---");
		System.out.println("---");
		Tester.program(roomArray, catArray);
	}
}