package Cards;

public enum Ranks {
	Dwójka(2), Trójka(3), Czwórka(4), Piątka(5), Szóstka(6),
	Siódemka(7), Ósemka(8),	Dzięwiątka(9), Dziesiątka (10),
	Walet(11), Dama(12), Król(13), As(14);
	
	private int value;
	
	Ranks(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
