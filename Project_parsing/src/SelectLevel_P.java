import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectLevel_P extends JPanel {
	private Frame F;
	private EntityCtrl EC = new EntityCtrl();
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
		add(back = new JButton("���ư���"));
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
				System.out.println("����1");
				F.getCardLayout().show(F.getContentPane(), "Quest");
				
				String[] s = EC.setTest(3);
				if(s != null) {
					
				}
			}
			else if(e.getActionCommand().equals("N2")) {
				System.out.println("����2");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N3")) {
				System.out.println("����3");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N4")) {
				System.out.println("����4");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
			else if(e.getActionCommand().equals("N5")) {
				System.out.println("����5");
				F.getCardLayout().show(F.getContentPane(), "Quest");
			}
		}
	}
}
