package Cards;

/*
	Stwórz obiekt typu Karta (Card). Kartę będą opisywać dwa pola klas enumowych Rank(Ranga np. dziewiątka, as) oraz Suit (Kolor - np. pik).
	Stwórz dwie dowolne karty w mainie, różniące się rangą i kolorem, zaprezentuj je wykorzystując nadpisaną metodę toString.
	W mainie wyświetl wszystkie możliwe rangi wykorzystując statyczną metodę enumów - values().
	Każda z rang ma mieć przypisaną siłę, dla dwójki 2, trójki 3 itd.
	Obiekty kart mają mieć metodę pozwalającą na pobranie siły karty. Stwórz dodatkowy serwis pozwalający porównać dwie karty, drukujący tą która jest większa i zwracający ją.
	Stwórz listę wszystkich możliwych rang w kolorze pik. (wykorzystaj pętle dla automatyzacji zadania)
	Stwórz całą talię, czyli listę wszystkich możliwych rang dla wszystkich możliwych kolorów.
*/

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import java.util.ArrayList;
import java.util.List;

public class CardsGame {
	private static JTextPane gameText;
	private static JTextPane topCardText;
	private static JTextPane bottomCardText;
	private static StyledDocument topCardDocument;
	private static StyledDocument bottomCardDocument;
	private static Card krolPik = new Card(Ranks.Król, Suits.Pik);
	private static Card asKaro = new Card(Ranks.As, Suits.Karo);
	private static Card asTrefl = new Card(Ranks.As, Suits.Trefl);
	private static List<Card> player1deck = new ArrayList<>();
	private static List<Card> player2deck = new ArrayList<>();
	
	// getting the handles for GUI components we want to change during the game.
	public static void setGUIvariables(JTextPane[] textPaneArray, StyledDocument doc1, StyledDocument doc2) {
		gameText = textPaneArray[0];
		topCardText = textPaneArray[1];
		bottomCardText = textPaneArray[2];
		topCardDocument = doc1;
		bottomCardDocument = doc2;
	
//		String[] initString = {
//				"As\n",	// card value
//				" "	// card suit
//		};
//		String[] initStyles = { "regular", "pik" };
//		updateContent(topCardDocument, initString, initStyles);

		updateContent(topCardDocument, "Król", "pik");
		updateContent(bottomCardDocument, "As", "karo");
	
	}
	
	public static void prepareDecks() {
		List<Card> fullDeckList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				fullDeckList.add(new Card(Ranks.values()[j], Suits.values()[i]));
			}
		}
		for (Card card : fullDeckList) {
			System.out.println(card);
		}
		
	}
	
	public static void updateContent(StyledDocument document, String cardValue, String cardSuit) {
		String[] initString = {
				cardValue + "\n",	// card value
				" "	// card suit
		};
		String[] initStyles = { "regular", cardSuit };
		
		for (int i = 0; i < initString.length; i++) {
			try {
				document.insertString(
						document.getLength(),
//						i,
						initString[i],
						document.getStyle(initStyles[i]));
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void nextRound() {
		bottomCardText.setText(null);
		topCardText.setText(null);
		updateContent(topCardDocument, "As", "trefl");
		updateContent(bottomCardDocument, "As", "karo");
		displayResult(asTrefl, asKaro);
	}

	private static String compareCards(Card card1, Card card2){
		int result = card1.compareTo(card2);
		String resultString = "";
		switch (result) {
			case 1 -> resultString = "Karta " + card1 + " jest większa.";
			case -1 -> resultString = "Karta " + card2 + " jest większa.";
			case 0 -> resultString = "Obie karty są równe!";
		}
		return resultString;
	}
	
	public static void main(String[] args) {
		
//	How does it look?
		UIManager.put("swing.boldMetal", Boolean.FALSE);	// getting rid of the forced bold font setting
//		try {
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//			System.err.println(e.getMessage());
//		}

		JFrame frame = new JFrame("Card Game!");
		frame.setContentPane(new MainForm().getMainContainer());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
//		Card krolPik = new Card(Ranks.KING, Suits.SPADES);
//		Card asKaro = new Card(Ranks.ACE, Suits.DIAMONDS);
//		Card asTrefl = new Card(Ranks.ACE, Suits.CLUBS);
		
		prepareDecks();
		
		displayResult(krolPik, asKaro);

		/*
		JTextPane textPane = new JTextPane();
StyledDocument doc = textPane.getStyledDocument();
addStylesToDocument(doc);

//Load the text pane with styled text.
try {
    for (int i=0; i < initString.length; i++) {
        doc.insertString(doc.getLength(), initString[i],
                         doc.getStyle(initStyles[i]));
    }
} catch (BadLocationException ble) {
    System.err.println("Couldn't insert initial text into text pane.");
}
		 */
		
//		for (Ranks value : Ranks.values()) {
//			System.out.println("Karta: " + value + "; Siła: " + value.getValue());
//		}
	
	}
	
	public static void displayResult(Card card1, Card card2) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(compareCards(card1, card2)).append("\n");
//		sb.append(compareCards(asTrefl, asKaro)).append("\n");
		
		sb.append(card1);
		
		gameText.setText(sb.toString());
	}
}
