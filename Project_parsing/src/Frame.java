import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame {
	private CardLayout cards = new CardLayout();
	private EntityCtrl EC = new EntityCtrl();
	
	public Frame(){
		setSize(500,500);
		getContentPane().setLayout(cards);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JapaneseTest");
		setLocationRelativeTo(null);
		getContentPane().add("Main", new Main_P(this));
		getContentPane().add("SelectLevel", new SelectLevel_P(this));
		getContentPane().add("Quest", new Quest_P(this));
		setVisible(true);
	}
	
	public CardLayout getCardLayout() {
		 return cards;
	}
	
	public void ChangeMain() {
		getCardLayout().show(getContentPane(), "Main");
	}

}
