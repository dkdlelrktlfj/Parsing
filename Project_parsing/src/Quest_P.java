import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Quest_P extends JPanel {
	private EntityCtrl EC = new EntityCtrl(); // 1
	private AnswerEntity answerentity = AnswerEntity.getInstance();
	private int success = 0, faild = 0;
	private JPanel panel2;
	private JButton choose_b1, choose_b2, choose_b3, choose_b4, previous;
	private JLabel japan_c_label, japan_label, success_label, faild_label, status;
	private Frame F;
	

	public Quest_P(Frame f) {
		if (f != null) {
			setSize(500, 500);
			setLayout(new BorderLayout());

			F = f;
			
			panel2 = new JPanel();
			JPanel panel2_text = new JPanel();
			panel2_text.setLayout(new GridLayout(0, 1));
			panel2_text.add(japan_c_label = new JLabel("1"));
			japan_c_label.setPreferredSize(new Dimension(50, 50));
			japan_c_label.setFont(japan_c_label.getFont().deriveFont(30.0f));
			japan_c_label.setHorizontalAlignment(JLabel.CENTER);

			panel2_text.add(japan_label = new JLabel("2"));
			japan_label.setPreferredSize(new Dimension(50, 50));
			japan_label.setFont(japan_label.getFont().deriveFont(20.0f));
			japan_label.setHorizontalAlignment(JLabel.CENTER);

			JPanel panel2_button = new JPanel();
			panel2_button.setLayout(new GridLayout(0, 2));
			panel2_button.add(choose_b1 = new JButton());
			panel2_button.add(choose_b2 = new JButton());
			panel2_button.add(choose_b3 = new JButton());
			panel2_button.add(choose_b4 = new JButton());

			choose_b1.addActionListener(new ClickButton());
			choose_b2.addActionListener(new ClickButton());
			choose_b3.addActionListener(new ClickButton());
			choose_b4.addActionListener(new ClickButton());
			
			JPanel panel3_bottom = new JPanel();
			panel3_bottom.setLayout(new BorderLayout());
			previous = new JButton("돌아가기");
			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					F.ChangeMain();
				}
			});
			
			JPanel panel3_label = new JPanel();
			success_label = new JLabel(String.format("%d", success));
			faild_label = new JLabel(String.format("%d", faild));
			status = new JLabel("환영합니다.");
			
			panel3_label.setLayout(new GridLayout(0,1));
			panel3_label.add(success_label);
			panel3_label.add(faild_label);
			panel3_label.add(status);
			
			panel3_bottom.add(previous, BorderLayout.WEST);
			panel3_bottom.add(panel3_label, BorderLayout.CENTER);
			
			panel2.setLayout(new BorderLayout());
			panel2.add(panel2_text, BorderLayout.NORTH);
			panel2.add(panel2_button, BorderLayout.CENTER);
			panel2.add(panel3_bottom, BorderLayout.SOUTH);

			add(panel2);

			setVisible(true);
		}
	}

	public void setText(int Level) {
		String[] text = EC.setTest(Level);
		japan_label.setText("11");
		japan_label.setText(text[0]);
		japan_c_label.setText(text[1]);
		int random = (int) (Math.random() * 4);
		if (random == 0) {
			answerentity.clickButtonSet(random);
			choose_b1.setText(text[2]);
			choose_b2.setText(text[3]);
			choose_b3.setText(text[4]);
			choose_b4.setText(text[5]);
		} else if (random == 1) {
			answerentity.clickButtonSet(random);
			choose_b1.setText(text[3]);
			choose_b2.setText(text[2]);
			choose_b3.setText(text[4]);
			choose_b4.setText(text[5]);
		} else if (random == 2) {
			answerentity.clickButtonSet(random);
			choose_b1.setText(text[3]);
			choose_b2.setText(text[4]);
			choose_b3.setText(text[2]);
			choose_b4.setText(text[5]);
		} else {
			answerentity.clickButtonSet(random);
			choose_b1.setText(text[3]);
			choose_b2.setText(text[4]);
			choose_b3.setText(text[5]);
			choose_b4.setText(text[2]);
		}
		
		success_label.setText(String.format("%d", success));
		faild_label.setText(String.format("%d", faild));
	}

	public class ClickButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == choose_b1) {
				if (0 == answerentity.clickButtonGet()) {
					status.setText("정답");
					success += 1;
					setText(3);
				} else {
					status.setText("오답");
					faild += 1;
					setText(3);
				}
			} else if (e.getSource() == choose_b2) {
				if (1 == answerentity.clickButtonGet()) {
					status.setText("정답");
					success += 1;
					setText(3);
				} else {
					status.setText("오답");
					faild += 1;
					setText(3);
				}
			} else if (e.getSource() == choose_b3) {
				if (2 == answerentity.clickButtonGet()) {
					status.setText("정답");
					success += 1;
					setText(3);
				} else {
					status.setText("오답");
					faild += 1;
					setText(3);
				}
			} else {
				if (3 == answerentity.clickButtonGet()) {
					status.setText("정답");
					success += 1;
					setText(3);
				} else {
					status.setText("오답");
					faild += 1;
					setText(3);
				}
			}
		}
	}
}