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
import java.util.Collections;
import java.util.List;

public class CardsGame {
	private static JTextPane gameText;
	private static JTextPane topCardText;
	private static JTextPane bottomCardText;
	private static StyledDocument topCardDocument;
	private static StyledDocument bottomCardDocument;
	private static JLabel player1scoreField;
	private static JLabel player2scoreField;
	private static JLabel roundIndicatorField;
	private static JButton nextRoundButton;
	
//	private static Card krolPik = new Card(Ranks.Król, Suits.Pik);
//	private static Card asKaro = new Card(Ranks.As, Suits.Karo);
//	private static Card asTrefl = new Card(Ranks.As, Suits.Trefl);
	private static List<Card> player1deck = new ArrayList<>();
	private static List<Card> player2deck = new ArrayList<>();
	private static int round = 0;
	private static double player1score = 0;
	private static double player2score = 0;
	
	// getting the handles for GUI components we want to change during the game.
	public static void setGUIvariables(JTextPane[] textPaneArray, JLabel[] scoreArray, StyledDocument doc1, StyledDocument doc2, JButton nextRound) {
		gameText = textPaneArray[0];
		topCardText = textPaneArray[1];
		bottomCardText = textPaneArray[2];
		player1scoreField = scoreArray[0];
		player2scoreField = scoreArray[1];
		roundIndicatorField = scoreArray[2];
		topCardDocument = doc1;
		bottomCardDocument = doc2;
		nextRoundButton = nextRound;
	
//		String[] initString = {
//				"As\n",	// card value
//				" "	// card suit
//		};
//		String[] initStyles = { "regular", "pik" };
//		updateContent(topCardDocument, initString, initStyles);

//		updateContent(topCardDocument, "Król", "pik");
//		updateContent(bottomCardDocument, "As", "karo");
	
	}
	
	public static void prepareDecks() {
		List<Card> fullDeckList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				fullDeckList.add(new Card(Ranks.values()[j], Suits.values()[i]));
			}
		}
//		for (Card card : fullDeckList) {
//			System.out.println(card);
//		}
		Collections.shuffle(fullDeckList);
		int size = fullDeckList.size();
		player1deck = fullDeckList.subList(0, (size + 1) / 2);
		player2deck = fullDeckList.subList((size + 1) / 2, size);
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

		Card card1 = player1deck.get(round);
		Card card2 = player2deck.get(round);
		
		
		updateContent(topCardDocument, card1.getRank(), card1.getSuit());
		updateContent(bottomCardDocument, card2.getRank(), card2.getSuit());
		compareCards(card1, card2);
		player1scoreField.setText(String.valueOf(player1score));
		player2scoreField.setText(String.valueOf(player2score));

		round++;
		roundIndicatorField.setText("Runda " + round);
		if (round == player1deck.size()) {
			System.out.println("Karty się skończyły!\n Koniec gry!");
			displayResult(gameText.getText() + "\nKarty się skończyły!\nKoniec gry!");
			nextRoundButton.setEnabled(false);
//			System.exit(0);
		}
	}

	private static void compareCards(Card card1, Card card2) {
		StringBuilder sb = new StringBuilder();

//		sb.append(compareCards(card1, card2)).append("\n");

		int result = card1.compareTo(card2);
//		String resultString = "";
		switch (result) {
			case 1 -> {
				sb.append("Karta ").append(card1).append(" jest większa.\nGracz 1 otrzymuje punkt.");
				player1score++;
			}
			case -1 -> {
				sb.append("Karta ").append(card2).append(" jest większa.\nGracz 2 otrzymuje punkt.");
				player2score++;
			}
			case 0 -> {
				sb.append("Obie karty są równe!\nObaj gracze otrzymują po pół punktu!");
				player1score += 0.5;
				player2score += 0.5;
			}
		}
		
		displayResult(sb.toString());
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
		
//		displayResult(krolPik, asKaro);
		
		nextRound();

		
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
	
	public static void displayResult(String text) {
//		StringBuilder sb = new StringBuilder();
		
//		sb.append(compareCards(card1, card2)).append("\n");
//		sb.append(compareCards(asTrefl, asKaro)).append("\n");
		
//		sb.append(card1);
		
		gameText.setText(text);
	}
}
