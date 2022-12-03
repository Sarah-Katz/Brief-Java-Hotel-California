package hotelCalifornia;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarah Katz
 *
 */
public class Room {
	private int id;
	private RoomCategory category;
	private int capacity;
	private int price;
	private boolean isAvailable;
	
	public Room (final int id,final RoomCategory cat,final int cap,final int price,final boolean isAvailable) {
		this.id = id;
		this.category = cat;
		this.capacity = cap;
		this.price = price;
		this.isAvailable = isAvailable;
	}
		
	public static List<Room> showAvailable(Room[] roomArray) {
		List<Room> availRooms = new ArrayList<Room>();
		for (Room room : roomArray) {
			if (room.isAvailable() == true) {
				availRooms.add(room);
			}
		}
		return availRooms;
	}

	public static void showInfos(List<Room> availRooms) {
		for (Room room : availRooms) {
			StringBuilder infos = new StringBuilder();
			infos.append("N° chambre : ").append(room.getId()).append("\n");
			infos.append("Options : ").append(room.category.getDescription()).append("\n");
			infos.append("Capacité : ").append(room.getCapacity()).append("\n");
			infos.append("Prix : ").append(room.getPrice()).append("€").append("\n");
			System.out.println(infos);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomCategory getCategory() {
		return category;
	}

	public void setCategory(RoomCategory category) {
		this.category = category;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}