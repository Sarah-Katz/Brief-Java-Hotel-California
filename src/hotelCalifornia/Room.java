package hotelCalifornia;

public class Room {
	int id;
	int category;
	int capacity;
	int prix;
	boolean isAvailable;
	boolean hasEnoughCapacity;
	boolean isChosenCategory;
	
	public Room (int id, int cat, int cap, int prix, boolean isAvailable, boolean hasEnoughCapacity, boolean isChosenCategory) {
		this.id = id;
		this.category = cat;
		this.capacity = cap;
		this.prix = prix;
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

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
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
