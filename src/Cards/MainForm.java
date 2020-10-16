package Cards;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
	private JPanel mainContainer;
	private JPanel gamePanel;
	private JLabel gameTitle;
	private JButton nextRound;
	private JTextPane gameAreaText;
	private JButton exitButton;
	private JTextPane topCardText;
	private JTextPane bottomCardText;
	private JTextPane middleText;
	private JLabel scorePlayer1;
	private JLabel scorePlayer2;
	private JLabel roundIndicator;
	
	public MainForm() {
		// setting up the game environment
		// passing the handles over to CardDemo
		
		// horizontal text center for middle text
		StyledDocument doc = middleText.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		StyledDocument docTopCard = topCardText.getStyledDocument();
		StyledDocument docBottomCard = bottomCardText.getStyledDocument();

		setIcons(docTopCard);
		setIcons(docBottomCard);

		CardsGame.setGUIvariables(
				new JTextPane[] { gameAreaText, topCardText, bottomCardText },
				new JLabel[] { scorePlayer1, scorePlayer2, roundIndicator },
				docTopCard,
				docBottomCard);
		
		nextRound.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			gameAreaText.setText("Wcisnąłeś przycisk!!");
			CardsGame.nextRound();
		}
		
		});
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void setIcons(StyledDocument doc) {
		Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		// horizontal text center
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		// setting the icons
		Style regular = doc.addStyle("regular", def);
//		StyleConstants.setFontFamily(def, "SansSerif");
		Style iconTrefl = doc.addStyle("trefl", regular);
		Style iconKaro = doc.addStyle("karo", regular);
		Style iconKier = doc.addStyle("kier", regular);
		Style iconPik = doc.addStyle("pik", regular);
		
//		regular = doc.addStyle("regular", def);
//		StyleConstants.setFontFamily(def, "SansSerif");
//		StyleConstants.setAlignment(s, StyleConstants.ALIGN_CENTER);
//		java.net.URL imgURL = CardsDemo.class.getResource("CardIcons/Karo.png");
		ImageIcon cardIconTrefl = new ImageIcon("src/Cards/CardIcons/Trefl.png");	// imgURL
		ImageIcon cardIconKaro = new ImageIcon("src/Cards/CardIcons/Karo.png");	// imgURL
		ImageIcon cardIconKier = new ImageIcon("src/Cards/CardIcons/Kier.png");	// imgURL
		ImageIcon cardIconPik = new ImageIcon("src/Cards/CardIcons/Pik.png");	// imgURL
//				createImageIcon("images/Pig.gif",
//				"a cute pig");
		if (cardIconKaro != null) {
			StyleConstants.setIcon(iconTrefl, cardIconTrefl);
			StyleConstants.setIcon(iconKaro, cardIconKaro);
			StyleConstants.setIcon(iconKier, cardIconKier);
			StyleConstants.setIcon(iconPik, cardIconPik);
		} else {
			System.err.println("Nie znaleziono plików!");
		}
		
	}
	
	public JPanel getMainContainer() {
		return mainContainer;
	}
	
	/*
	public static void main(String[] args) {
		JFrame frame = new JFrame("MainForm");
		frame.setContentPane(new MainForm().mainContainer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}*/
}
