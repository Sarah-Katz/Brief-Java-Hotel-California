package hotelCalifornia;

import java.util.Scanner;

public class Billing {
	// TODO : Generate a STOP method.
	static Room[] createRoom() {
		Room[] rooms = new Room[31];
		rooms[0] = new Room(1, 1, 1, 100, true, false, false);
		rooms[1] = new Room(2, 2, 1, 120, true, false, false);
		rooms[2] = new Room(3, 3, 1, 130, true, false, false);
		rooms[3] = new Room(4, 4, 1, 150, true, false, false);
		rooms[4] = new Room(5, 1, 2, 130, true, false, false);
		rooms[5] = new Room(6, 2, 2, 160, true, false, false);
		rooms[6] = new Room(7, 3, 2, 170, true, false, false);
		rooms[7] = new Room(8, 4, 2, 190, true, false, false);
		rooms[8] = new Room(9, 1, 3, 170, true, false, false);
		rooms[9] = new Room(10, 2, 3, 200, true, false, false);
		rooms[10] = new Room(11, 3, 3, 210, true, false, false);
		rooms[11] = new Room(12, 4, 3, 210, true, false, false);
		rooms[12] = new Room(13, 5, 3, 270, true, false, false);
		rooms[13] = new Room(14, 6, 3, 350, true, false, false);
		rooms[14] = new Room(15, 1, 4, 150, true, false, false);
		rooms[15] = new Room(16, 2, 4, 230, true, false, false);
		rooms[16] = new Room(17, 3, 4, 240, true, false, false);
		rooms[17] = new Room(18, 4, 4, 260, true, false, false);
		rooms[18] = new Room(19, 5, 4, 300, true, false, false);
		rooms[19] = new Room(20, 6, 4, 400, true, false, false);
		rooms[20] = new Room(21, 1, 1, 100, true, false, false);
		rooms[21] = new Room(22, 2, 2, 160, true, false, false);
		rooms[22] = new Room(23, 1, 2, 130, true, false, false);
		rooms[23] = new Room(24, 3, 1, 130, true, false, false);
		rooms[24] = new Room(25, 3, 2, 170, true, false, false);
		rooms[25] = new Room(26, 4, 4, 260, true, false, false);
		rooms[26] = new Room(27, 5, 4, 300, true, false, false);
		rooms[27] = new Room(28, 2, 2, 160, true, false, false);
		rooms[28] = new Room(29, 4, 3, 230, true, false, false);
		rooms[29] = new Room(30, 3, 2, 170, true, false, false);
		rooms[30] = new Room(31, 4, 2, 190, true, false, false);
		return rooms;
	}

	static void inputCapacity(Room[] roomArray) {

		Scanner in = new Scanner(System.in);
		System.out.println("Indiquez le nombre de personnes (max 4) : ");
		int userResponse = in.nextInt();
		if (userResponse < 1 || userResponse > 4) {
			System.out.println("Saisissez un nombre valide (max 4).");
			inputCapacity(roomArray);
		}
		filterCapacity(userResponse, roomArray);
	}

	static void filterCapacity(int wantedCapacity, Room[] roomArray) {
		for (int i = 0; i < roomArray.length; i++) {

			if (roomArray[i].getCapacity() >= wantedCapacity) {
				roomArray[i].setHasEnoughCapacity(true);
				System.out.println("ça marche");
			} else {
				roomArray[i].setHasEnoughCapacity(false);
			}
		}

	}
}
