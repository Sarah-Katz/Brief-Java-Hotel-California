package hotelCalifornia;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Sarah Katz
 *
 */
public class Menu {

	public static void startProgram(final Room[] roomArray, final RoomCategory[] catArray) {
		menu(roomArray, catArray);

//		int userWantedCap = Billing.inputCapacity(roomArray, catArray);
//		int userWantedCat = Billing.inputCategory(roomArray, catArray);
//		Billing.filterAvailable(roomArray, catArray, userWantedCap, userWantedCat);
	}

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
				Room.showInfos(Room.showAvailable(Main.ROOMARRAY));
				menu(roomArray, catArray);
				break;
			case 2:
				Billing.booking(roomArray, catArray);
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("/!\\ Merci de renseigner le chiffre de l'action souhaitée /!\\");
			menu(roomArray, catArray);
		}

	}
}