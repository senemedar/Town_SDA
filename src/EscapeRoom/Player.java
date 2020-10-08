package EscapeRoom;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Item> itemsList = new ArrayList<>();	// Player's inventory; starting empty
	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addItem(Item item) {
		return this.itemsList.add(item);
	}
	
	public boolean removeItem(Item item) {
		return this.itemsList.remove(item);
	}
	
	public List<Item> getItemsList() {
		return this.itemsList;
	}
}
