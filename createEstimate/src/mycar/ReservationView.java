package mycar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ReservationView extends MycarController {
	JFrame frame;
	String[] combotimes;
	JComboBox<String> combo;
	JLabel label;

	public ReservationView() {
		label = new JLabel("시간 선택");
		frame = new JFrame();
		combotimes = new String[] { "10", "11", "12", "13", "14", "15", "16" };
		combo = new JComboBox<String>(combotimes);
	}

	public void selectTime() {
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(label);
		label.setForeground(Color.WHITE);
		combo.setBackground(Color.WHITE);
		combo.setForeground(Color.BLACK);
		frame.add(combo);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.setResizable(false);
		frame.setBounds(150, 150, 200, 100);
		frame.setSize(200, 100);

		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				users.get(cnt).setReservTime(combo.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null,
						users.get(cnt).getReservYear() + "년" + users.get(cnt).getReservMonth() + "월"
								+ users.get(cnt).getReservDate() + "일" + users.get(cnt).getReservTime()
								+ "시에 예약이 완료되었습니다.");
				frame.dispose();
				TEST2.gui.show.append("※" + users.get(cnt).getName() + "님이 " + users.get(cnt).getReservYear() + "년"
						+ users.get(cnt).getReservMonth() + "월" + users.get(cnt).getReservDate() + "일"
						+ users.get(cnt).getReservTime() + "시 시승예약 하셨습니다.\n");
			}
		});
	}

}
