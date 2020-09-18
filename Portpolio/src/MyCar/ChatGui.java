package MyCar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ChatGui {
	JFrame frame; JTextField text; TextArea show; JLabel label; JButton[] buttons; 

		
	public ChatGui() {
	frame = new JFrame("[JAVA TALK!]");
	buttons = new JButton[] {new JButton("전송"), new JButton("닫기")};
	text = new JTextField();
	show = new TextArea();
	label = new JLabel("00:00:00", JLabel.RIGHT);

	
	}
	
	public void createGui() {
	show.setBackground(Color.WHITE);
	
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setSize(400,400);
	frame.setLayout(null);
	frame.add(text); 
	frame.add(show);
	frame.setBounds(600, 0, 400, 400);
	show.setBounds(0, 30, 400, 300); show.setForeground(Color.BLACK);

	for (int i=0; i<buttons.length; i++) {frame.add(buttons[i]); buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR)); if (i!=3)buttons[i].setBackground(Color.DARK_GRAY); buttons[i].setForeground(Color.LIGHT_GRAY); }
	label.setOpaque(true); 
    label.setBackground(Color.DARK_GRAY);
	label.setForeground(Color.LIGHT_GRAY);
	text.requestFocus();
	frame.add(label);
	label.setBounds(0, 0, 393, 28);

	label.setBackground(Color.DARK_GRAY);
	text.setBounds(10, 332, 240, 20);
	show.setEditable(false);
	
	buttons[0].setBounds(255, 330, 60, 25);
	buttons[1].setBounds(320, 330, 60, 25);
	
	
	buttons[1].addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}});

	
	}
}



