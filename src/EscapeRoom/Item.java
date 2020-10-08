package EscapeRoom;

public abstract class Item {
	private String name;
	private String description;
	
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	// this method returns:
	// 0 for actions (items that cannot be picked up)
	// 1 for items that can be picked up
	// -1 for ending the game
	public abstract int use(Player player);
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name + ": " + description;
	}
}
