package hotelCalifornia;

public class Room {
	private int id;
	private RoomCategory category;
	private int capacity;
	private int price;
	private boolean isAvailable;
	private boolean hasEnoughCapacity;
	private boolean isChosenCategory;
	
	public Room (final int id,final RoomCategory cat,final int cap,final int price,final boolean isAvailable,final boolean hasEnoughCapacity,final boolean isChosenCategory) {
		this.id = id;
		this.category = cat;
		this.capacity = cap;
		this.price = price;
		this.isAvailable = isAvailable;	
		this.hasEnoughCapacity = hasEnoughCapacity;
		this.isChosenCategory = isChosenCategory;
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

	public boolean isHasEnoughCapacity() {
		return hasEnoughCapacity;
	}

	public void setHasEnoughCapacity(boolean hasEnoughCapacity) {
		this.hasEnoughCapacity = hasEnoughCapacity;
	}

	public boolean isChosenCategory() {
		return isChosenCategory;
	}

	public void setChosenCategory(boolean isChosenCategory) {
		this.isChosenCategory = isChosenCategory;
	}
}
