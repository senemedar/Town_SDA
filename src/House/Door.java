package House;

public class Door {
	enum TypeOfDoors {
		FRONT,
		INTERNAL
	}
	private TypeOfDoors doors;
	private boolean areOpen;
	
	public Door(boolean areInternal) {
		if (areInternal) {
			this.doors = TypeOfDoors.INTERNAL;
		} else {
			this.doors = TypeOfDoors.FRONT;
		}
	}
}
