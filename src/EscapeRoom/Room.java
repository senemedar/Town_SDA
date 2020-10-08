package EscapeRoom;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private String name;
	private String description;
	private List<Item> itemsList = new ArrayList<>();	// list of items (unpicked) that are in the room
	private List<Player> playerList = new ArrayList<>();	// list of players in the room
	
	// constructors
	public Room() {		// default constructor that can be used for initial room
		this.name = "Mroczny pokój";
		this.description = "Duży, lecz pogrążony w półmroku pokój, ledwie oświetlany przez dwa kinkiety " +
				"znajdujące się na przeciwległej ścianie.";
		this.fillRoom();
	}
	
	public Room(String name, String description) {
		this.name = name;
		this.description = description;
		this.fillRoom();
	}
	
	// players management
	public void walkIn(Player player) {
		playerList.add(player);
		System.out.println(player.getName() + " wszedł do pokoju.");
	}
	
	// items management
	public boolean addItem(Item item) {
		return this.itemsList.add(item);
	}
	
	public boolean removeItem(Item item) {
		return this.itemsList.remove(item);
	}
	
	public List<Item> getItemsList() {
		return this.itemsList;
	}
	
	// basic room setup
	private void fillRoom() {
		addItem(new Key("Klucz do wyjścia"));
		addItem(new Door());
	}
	
	public void listItems() {
		StringBuilder sb = new StringBuilder("\nW pokoju znajdują się następujące przedmioty:\n");
		int itemNo = 0;
		for (Item item : itemsList) {
			itemNo++;
			sb.append(itemNo).append(") ").append(item).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(name).append(": ");
		sb.append(description);
		sb.append("\nW pokoju znajdują się następujące przedmioty:\n");
		int itemNo = 0;
		for (Item item : itemsList) {
			itemNo++;
			sb.append(itemNo).append(") ").append(item).append("\n");
		}
		
		return sb.toString();
	}
}
