import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame {
	private CardLayout cards = new CardLayout();
	private EntityCtrl EC = new EntityCtrl();
	private Main_P mainPanel;
	private SelectLevel_P levelPanel;
	private Quest_P questPanel;
	public Frame(){
		setSize(650,650);
		getContentPane().setLayout(cards);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EC.EntitySet();
		setTitle("JapaneseTest");
		setLocationRelativeTo(null);
		getContentPane().add("Main", mainPanel = new Main_P(this));
		getContentPane().add("SelectLevel", levelPanel = new SelectLevel_P(this));
		getContentPane().add("Quest", questPanel = new Quest_P(this));
		setVisible(true);
	}
	
	public void QuestSet(int level) {
		questPanel.setText(level);
	}
	
	public CardLayout getCardLayout() {
		 return cards;
	}
	
	public void ChangeMain() {
		getCardLayout().show(getContentPane(), "Main");
	}

}
