package hotelCalifornia;

public class Tester {
	
	public static void main(String[] args) {
		RoomCategory[] catArray = Billing.createRoomCategory();
		Room[] rooms = Billing.createRoom(catArray);			
		Billing.inputCapacity(rooms, catArray);
	}	
}