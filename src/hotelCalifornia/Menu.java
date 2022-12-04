package hotelCalifornia;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contain the navigation menu.
 *
 * @author Sarah Katz
 *
 */
public class Menu {

	/**
	 * *This is the method starting the main menu.
	 *
	 * @param roomArray the Array of Room
	 * @param catArray  the Array of RoomCategory
	 */
	public static void menu(final Room[] roomArray, final RoomCategory[] catArray) {
		try {
			Scanner in = new Scanner(System.in);
			System.out.println("________________________________________________");
			System.out.println("|       Bienvenue à l'hotel California !       |");
			System.out.println("|----------------------------------------------|");
			System.out.println("|Vous souhaitez :                              |");
			System.out.println("|                                              |");
			System.out.println("|1 - Afficher la liste des chambres disponibles|");
			System.out.println("|                                              |");
			System.out.println("|2 - Réserver une chambre                      |");
			System.out.println("|                                              |");
			System.out.println("|----------------------------------------------|");
			System.out.println("|3 - Quitter le programme                      |");
			System.out.println("|______________________________________________|");
			int userChoice = in.nextInt();
			switch (userChoice) {
			case 1:
				Room.showInfos(Room.showAvailable(roomArray));
				menu(roomArray, catArray);
				break;
			case 2:
				Billing.inputCapacity(roomArray, catArray);
				break;
			case 3:
				System.exit(0);
			}
		} catch (InputMismatchException e) {
			System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
			menu(roomArray, catArray);
		}
	}

	// Unused for now
	public static void reset(final Room[] roomArray, final RoomCategory[] catArray) {
		System.out.println("---");
		System.out.println("---");
		System.out.println("Retour début de programme");
		System.out.println("---");
		System.out.println("---");
		Menu.menu(roomArray, catArray);
	}
}