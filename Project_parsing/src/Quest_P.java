import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quest_P extends JPanel{
		private JPanel panel2;
		private JButton choose_b1,choose_b2,choose_b3,choose_b4,previous;
		private JLabel japan_c_label,japan_label;
		private Frame F;
		
		public Quest_P(Frame f) {
			setSize(500,500);
			setLayout(new BorderLayout());
			
			F = f;
			
			panel2 = new JPanel();
			JPanel panel2_text = new JPanel();
			panel2_text.setLayout(new GridLayout(0,1));
			panel2_text.add(japan_c_label = new JLabel("한자"));
			japan_c_label.setPreferredSize(new Dimension(50,50));
			japan_c_label.setFont(japan_c_label.getFont().deriveFont(30.0f));
			japan_c_label.setHorizontalAlignment(JLabel.CENTER);
			
			
			panel2_text.add(japan_label = new JLabel("히라가나"));
			japan_label.setPreferredSize(new Dimension(50,50));
			japan_label.setFont(japan_label.getFont().deriveFont(20.0f));
			japan_label.setHorizontalAlignment(JLabel.CENTER);
			
			JPanel panel2_button = new JPanel();
			panel2_button.setLayout(new GridLayout(0,2));
			panel2_button.add(choose_b1 = new JButton());
			panel2_button.add(choose_b2 = new JButton());
			panel2_button.add(choose_b3 = new JButton());
			panel2_button.add(choose_b4 = new JButton());
			
			JPanel panel3_bottom = new JPanel();
			previous = new JButton("돌아가기");
			previous.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                F.ChangeMain();
	            }
	        });

			panel3_bottom.add(previous);
			
			panel2.setLayout(new BorderLayout());
			panel2.add(panel2_text,BorderLayout.NORTH);
			panel2.add(panel2_button,BorderLayout.CENTER);
			panel2.add(panel3_bottom,BorderLayout.SOUTH);
			
			add(panel2);
			
			setVisible(true);
		}
		
	}