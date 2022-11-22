package hotelCalifornia;

public class Tester {
	
	public static void main(String[] args) {
		Room[] rooms = Billing.createRoom();			
		Billing.inputCapacity(rooms);
		System.out.println(rooms[8].hasEnoughCapacity);
	}	
}