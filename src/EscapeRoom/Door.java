package EscapeRoom;

public class Door extends Item {
	private boolean isClosed = true;
	// a shorthand constructor for "default" entrance door
	public Door() {
		super("Drzwi wejściowe", "Solidne, dębowe drzwi z żelaznymi okuciami.");
	}
	
	// constructor for extra doors
	public Door(String name, String description) {
		super(name, description);
	}
	
	@Override
	public int use(Player player) {
		for (Item playersItem : player.getItemsList()) {    // iterating through player's belongings to find if he has a key
			if (playersItem instanceof Key) {    // we've found a key
				player.removeItem(playersItem);
				System.out.println(player.getName() + " otworzył drzwi \"" + this.getName() + "\"");
				return -1;	// the doors are open so we're ending the game
				}
		}
			// player doesn't have any keys
			System.out.println("Niestety, " + player.getName() + " nie posiada klucza aby otworzyć drzwi: \"" +
					this.getName() + "\"");
		
		return 0;	// returning '0' since it's not an item to be picked
	}
	
	@Override
	public String toString() {
		String ending;
		if (isClosed)
			ending = "zamknięte.";
		else
			ending = "otwarte.";
		
		return super.toString() + " Drzwi są " + ending;
	}
}
