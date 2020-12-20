package mycar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class MyCar_View_ extends MycarController {
	JFrame frame;
	JButton[] button;
	JLabel label, timer;
	ImageIcon[] icon;
	TEST2 server;

	public MyCar_View_() {
		frame = new JFrame("메인 페이지");
		icon = new ImageIcon[] {
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("genesis_BLACK.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("login.png"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("register.png"))) };
		button = new JButton[] { new JButton(icon[1]), new JButton(icon[2]), new JButton("ID찾기"), new JButton("PW찾기"),
				new JButton("종료") };
		label = new JLabel(icon[0]);
		timer = new JLabel();
		server = new TEST2();
		if (!once) {
			server.start();
			once = true;
			new TT().start();
		}
	}

	public void start() {

		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 400);
		frame.setLayout(null);
		frame.add(label);
		frame.setResizable(false);
		frame.add(timer);

		timer.setBounds(190, 335, 150, 30);
		timer.setForeground(Color.WHITE);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		label.setBounds(80, 0, 300, 100);
		button[0].setBounds(140, 100, 180, 50);
		for (int i = 1; i <= 4; i++) {
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
		}

		button[1].setBounds(140, 160, 180, 50);
		button[2].setBounds(80, 220, 150, 50);
		button[3].setBounds(230, 220, 150, 50);
		button[4].setBounds(150, 280, 150, 50);

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) { 
						frame.dispose();
						new LoginView().login();

					} else if (e.getSource().equals(button[1])) {
						new CreationUserView().register();
						frame.dispose();
					} else if (e.getSource().equals(button[2])) {

						String namechk = JOptionPane.showInputDialog("성함을 입력해주세요.");
						if (namechk.equals("")) {
							JOptionPane.showMessageDialog(null, "성함을 입력해주세요", "ID찾기 실패", JOptionPane.WARNING_MESSAGE);
							return;
						}
						String numbchk = JOptionPane.showInputDialog("연락처를 입력해주세요.");
						if (numbchk.equals("")) {
							JOptionPane.showMessageDialog(null, "연락처를 입력해주세요", "ID찾기 실패", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (users.size() == 0) {
							JOptionPane.showMessageDialog(null, "존재하지 않는 정보입니다.");
						}

						for (int i = 0; i < users.size(); i++) {
							if (users.get(i).getName().equals(namechk)
									&& users.get(i).getPhonenumber().equals(numbchk)) {
								JOptionPane.showMessageDialog(null,
										users.get(i).getName() + "님의 아이디 : " + users.get(i).getId());
								return;
							} else if (i == users.size() - 1) {
								JOptionPane.showMessageDialog(null, "존재하지 않는 정보입니다.");
							}
						}

					} else if (e.getSource().equals(button[3])) {
						String namechk = JOptionPane.showInputDialog("성함을 입력해주세요.");
						if (namechk.equals("")) {
							JOptionPane.showMessageDialog(null, "성함을 입력해주세요", "PW찾기 실패", JOptionPane.WARNING_MESSAGE);
							return;
						}
						String idchk = JOptionPane.showInputDialog("아이디를 입력해주세요.");
						if (idchk.equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요", "PW찾기 실패", JOptionPane.WARNING_MESSAGE);
							return;
						}
						if (users.size() == 0) {
							JOptionPane.showMessageDialog(null, "존재하지 않는 정보입니다.");
						}

						for (int i = 0; i < users.size(); i++) {
							if (users.get(i).getId().equals(idchk) && users.get(i).getName().equals(namechk)) {
								JOptionPane.showMessageDialog(null,
										users.get(i).getName() + "님의 비밀번호 : " + users.get(i).getPw());
								return;
							} else if (i == users.size() - 1) {
								JOptionPane.showMessageDialog(null, "존재하지 않는 정보입니다.");
							}
						}
					} else if (e.getSource().equals(button[4])) {
						System.exit(0);
					}

				}
			});
		}

	}
}
