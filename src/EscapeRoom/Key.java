package EscapeRoom;

public class Key extends Item {
	
	public Key(String name) {
		super(name, "Staroświecki, żelazny klucz.");
	}
	
	public Key(String name, String description) {
		super(name, description);
	}
	
	@Override
	public int use(Player player) {
		player.addItem(this);
		System.out.println(player.getName() + " podniósł \"" + this.getName() + "\"");
		return 1;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
