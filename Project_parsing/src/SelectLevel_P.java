import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectLevel_P extends JPanel {
	private Frame F;
	Quest_P Q = new Quest_P(null);
	private JButton back;
	private JButton[] button = null;
	private String[] s = {"N1","N2","N3","N4","N5"};
	
	SelectLevel_P(Frame f){
		setSize(500,500);
		setLayout(new GridLayout(0,1));
		
		F = f;
		
		button = new JButton[s.length];
		
		for(int i=0; i < button.length; i++) {
			button[i] = new JButton(s[i]);
			button[i].addActionListener(new ClickButton());
			add(button[i]);
		}
		add(back = new JButton("돌아가기"));
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				F.ChangeMain();
			}
		});
		setVisible(true);
	}
	
	public class ClickButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("N1")) {
				System.out.println("동작1");
				F.getCardLayout().show(F.getContentPane(), "Quest");
				F.QuestSet(3);
			}
			else if(e.getActionCommand().equals("N2")) {
				System.out.println("동작2");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N3")) {
				System.out.println("동작3");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N4")) {
				System.out.println("����4");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N5")) {
				System.out.println("동작5");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
		}
	}
}
