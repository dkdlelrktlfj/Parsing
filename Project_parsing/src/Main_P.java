import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Main_P extends JPanel{
		private JPanel panel1;
		private JButton button1,button2,button3,button4;
		private Frame F;
		
		public Main_P(Frame f) {
			setSize(100,100);
			setLayout(new GridLayout(0,2));
			
			F = f;
			
			
			button1 = new JButton("�ܾ� ����");
			button1.addActionListener(new ClickButton());
			button2 = new JButton("���� Ǯ��");
			button2.addActionListener(new ClickButton());
			button3 = new JButton("3");
			button3.addActionListener(new ClickButton());
			button4 = new JButton("4");
			button4.addActionListener(new ClickButton());
			
			add(button1);
			add(button2);
			add(button3);
			add(button4);
			
			setVisible(true);
			
		}
		
		public class ClickButton implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button1) {
					System.out.println("����1");
					
				}
				else if(e.getSource() == button2) {
					System.out.println("����2");
					F.getCardLayout().show(F.getContentPane(), "SelectLevel");
				}
			}
		}
		
	}