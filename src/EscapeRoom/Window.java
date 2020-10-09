package EscapeRoom;

public class Window extends Item {
	
	private boolean isClosed = true;
	// a shorthand constructor for "default" entrance door
	public Window() {
		super("Okno", "Niewielkie, przeszklone okno. Zakratowane.");
	}
	
	// constructor for extra doors
	public Window(String name, String description) {
		super(name, description);
	}
	
	@Override
	public int use(Player player) {
		if (this.isClosed) {
			this.isClosed = false;
			System.out.println(player.getName() + " otworzył okno.");
		} else {
			this.isClosed = true;
			System.out.println(player.getName() + " zamknął okno.");
		}
		return 0;	// returning '0' since it's not an item to be picked
	}
	
	@Override
	public String toString() {
		String ending;
		if (isClosed)
			ending = "zamknięte.";
		else
			ending = "otwarte.";
		
		return super.toString() + " Okno jest " + ending;
	}
}
