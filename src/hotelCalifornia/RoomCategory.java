package hotelCalifornia;

/**
 * This class represents a room category and it's informations : the category ID
 * and it's description.
 *
 * @author Sarah Katz
 *
 */
public class RoomCategory {
	int id;
	String description;

	/**
	 * This constructor creates an instance of Room using parameters.
	 *
	 * @param id   Category ID
	 * @param desc Category description
	 */
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
