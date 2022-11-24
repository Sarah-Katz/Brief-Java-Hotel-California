package hotelCalifornia;

/**
 * @author Sarah Katz
 *
 */
public class Tester {
	
	public static void main(String[] args) {
		RoomCategory[] catArray = Billing.createRoomCategory();
		Room[] roomArray = Billing.createRoom(catArray);			
		program(roomArray, catArray);
	}	
	public static void program(Room[] roomArray, RoomCategory[] catArray) {
		int userWantedCap = Billing.inputCapacity(roomArray, catArray);
		int userWantedCat = Billing.inputCategory(roomArray, catArray);
		Billing.filterAvailable(roomArray, catArray, userWantedCap, userWantedCat);
	}
}