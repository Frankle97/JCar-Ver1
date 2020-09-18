package MyCar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Calendar_VIEW extends Calendar_CONTROLLER {
	JFrame frame;
	JButton[] button;
	JButton[] ccc;
	JLabel label;

	Calendar_VIEW() {
		Calendar cal = Calendar.getInstance();
		frame = new JFrame("*MY CALENDAR*");
		button = new JButton[7];
		ccc = new JButton[42];
		button[0] = new JButton(year + "년 " + month + "월 " + cal.get(Calendar.DAY_OF_MONTH) + "일 " + tdy());
		button[1] = new JButton("◀");
		button[2] = new JButton("▶");
		button[3] = new JButton(year + "년 " + month + "월 ");
		label = new JLabel(
				"일                    월                     화                    수                    목                      금                   토");
		button[4] = new JButton("닫기");
		button[5] = new JButton("▲");
		button[6] = new JButton("▼");
		for (int i = 0; i < ccc.length; i++) {
			ccc[i] = new JButton("");
		}
	}

	void calc() {
		for (int i = 0; i < ccc.length; i++) {
			ccc[i].setText("");
		}

		one = 0;
		two = 100;
		three = 70;
		four = 30;
		cnt = 0;
		days = 0;
		days();
		button[3].setText(year + "년 " + month + "월");

		for (int i = 0; i < ccc.length; i++) {
			if (i % 7 != 0) {
				one += 75;
			} else {
				one = 0;
				two += 35;
			}
			ccc[i].setBounds(one, two, three, four);

			if (i < days % 7 + 1 && (days % 7) + 1 != 7) {
				ccc[i].setText("");
			} else if (cnt < mon[month]) {
				ccc[i].setText("" + (++cnt));
				if (ccc[i].getText().equals("" + mon[month]))
					return;
			}
		}
	}

	void createGui() {

		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(530, 400);
		frame.setVisible(true);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setBackground(Color.WHITE);

		}
		button[0].setBounds(150, 10, 200, 30);
		button[0].setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		button[1].setBounds(10, 50, 50, 30);
		button[3].setBounds(130, 50, 260, 30);
		button[4].setBounds(400, 10, 100, 30);
		button[5].setBounds(70, 50, 50, 30);
		button[6].setBounds(400, 50, 50, 30);
		button[2].setBounds(460, 50, 50, 30);
		frame.add(label);
		label.setBounds(33, 100, 510, 30);
		for (int i = 0; i < ccc.length; i++) {
			frame.add(ccc[i]);
			ccc[i].setBackground(Color.WHITE);
			ccc[i].setForeground(Color.BLACK);
		}

		if (once == false) {
			for (int i = 0; i < ccc.length; i++) {
				if (i % 7 != 0) {
					one += 75;
				} else {
					one = 0;
					two += 35;
				}
				ccc[i].setBounds(one, two, three, four);
				if (i < days % 7 + 1) {
					ccc[i].setText("");
				} else if (cnt < mon[month]) {
					ccc[i].setText("" + (++cnt));
				}
			}
			once = true;
		}

		button[3].setForeground(Color.RED);
		button[0].setForeground(Color.BLUE);

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[1])) {
						if (month == 1) {
							year--;
							month = 13;
						}
						month--;
						calc();
					} else if (e.getSource().equals(button[2])) {
						if (month == 12) {
							year++;
							month = 0;
						}
						month++;
						calc();
					} else if (e.getSource().equals(button[5])) {
						year++;
						calc();
					} else if (e.getSource().equals(button[6])) {
						year--;
						calc();
					} else if (e.getSource().equals(button[0])) {
						year = cal.get(Calendar.YEAR);
						month = (cal.get(Calendar.MONTH) + 1);
						calc();
					} else if (e.getSource().equals(button[4])) {
						chk = true;
						frame.setVisible(false);
					}
				}
			});
		}

		for (int i = 0; i < ccc.length; i++) {
			int a = i;
			ccc[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(ccc[a])) {
				
						frame.setVisible(false);
						MyCar_Controller.users.get(MyCar_Controller.cnt).setReservYear(Integer.toString(year));
						MyCar_Controller.users.get(MyCar_Controller.cnt).setReservMonth(Integer.toString(month));
						MyCar_Controller.users.get(MyCar_Controller.cnt).setReservDate(ccc[a].getText());
						chk = true;
						new MyCar_View_SelectResTime().selectTime();
					}

				}
			});
		}

	}
}
