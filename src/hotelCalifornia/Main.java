package hotelCalifornia;

/**
 * @author Sarah Katz
 *
 */
public class Main {
	protected final static RoomCategory[] CATARRAY = Billing.createRoomCategory();
	protected final static Room[] ROOMARRAY = Billing.createRoom(CATARRAY);

	public static void main(String[] args) {
		CSVManager.importCSV(ROOMARRAY, CATARRAY);
//		Menu.menu(ROOMARRAY, CATARRAY);
	}
}
