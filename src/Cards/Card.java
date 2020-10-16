package Cards;

public class Card {
	private Ranks rank;
	private Suits suit;
	
	public Card(Ranks rank, Suits suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public String getRank() {
		return rank.name();
	}
	
	public String getSuit() {
		return suit.name().toLowerCase();
	}
	
	public int compareTo(Card cardToCompare) {
		int ret = 0;
		// 1 - pierwsza większa
		// -1 - druga większa
		// 0 - karty równe
		if (this.rank.getValue() > cardToCompare.rank.getValue()) {
//			System.out.println("Karta " + this + " jest większa.");
			ret = 1;
		} else if (this.rank.getValue() < cardToCompare.rank.getValue()) {
//			System.out.println("Karta " + cardToCompare + " jest większa.");
			ret = -1;
		} else if (this.rank.getValue() == cardToCompare.rank.getValue()) {
//			System.out.println("Obie karty są tej samej wartości.");
			ret = 0;
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		return "[" + rank + " " + suit + "]";
	}
}
