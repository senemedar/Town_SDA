package Cards;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
	private JPanel mainContainer;
	private JPanel gamePanel;
	private JPanel topCardPanel;
	private JPanel bottomCardPanel;
	private JLabel gameTitle;
	private JButton nextRound;
	private JLabel topCardText;
	private JLabel bottomCardText;
	private JLabel gameAreaText;
	
	public MainForm() {
		nextRound.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameAreaText.setText("Wcisnąłeś przycisk!!");
			}
		});
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
