package hotelCalifornia;

public class RoomCategory {
	int id;
	String description;
	
	RoomCategory(int id, String desc) {
		this.id = id;
		this.description = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
