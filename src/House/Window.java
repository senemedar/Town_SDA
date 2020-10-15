package House;


public class Window {
	private boolean isOpen;
	
	public Window() {
		this.isOpen = false;
	}
	
	public void openWindow() {
		this.isOpen = true;
	}
	
	public void closeWindow() {
		this.isOpen = false;
	}
	
	@Override
	public String toString() {
		String ret = "To okno jest ";
		if (isOpen)
			ret += "otwarte";
		else
			ret += "zamknięte";
		
		return ret;
	}
}
