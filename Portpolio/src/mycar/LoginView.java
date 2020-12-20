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
import javax.swing.JTextField;

public class LoginView extends MycarController {
	JFrame frame;
	JButton[] button;
	JTextField[] text;
	JLabel[] label;
	ImageIcon[] icon;

	LoginView() {
		frame = new JFrame("로그인 페이지");
		icon = new ImageIcon[] { new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis_BLACK.png"))) };

		label = new JLabel[] { new JLabel(icon[0]) };
		button = new JButton[] { new JButton("로그인"), new JButton("회원가입"), new JButton("돌아가기"), new JButton("아이디"),
				new JButton("비밀번호") };
		text = new JTextField[] { new JTextField(), new JTextField() };

	}

	void login() {

		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setSize(450, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < text.length; i++) {
			frame.add(text[i]);
		}
		frame.add(label[0]);
		frame.setResizable(false);
		frame.setLayout(null);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		button[3].setBorderPainted(false);
		button[4].setBorderPainted(false);

		label[0].setBounds(80, 0, 300, 100);
		text[0].setBounds(140, 120, 200, 30);
		text[1].setBounds(140, 170, 200, 30);
		button[0].setBounds(140, 220, 200, 50);
		button[1].setBounds(140, 290, 100, 50);
		button[2].setBounds(240, 290, 100, 50);
		button[3].setBounds(40, 110, 100, 50);
		button[4].setBounds(40, 160, 100, 50);
		button[3].setEnabled(false);
		button[4].setEnabled(false);
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						if (text[0].getText().equals("admin") && text[1].getText().equals("admin")) {
							frame.dispose();
							new AdminView().adminPage();
							return;
						}
						if (userAuth(text[0].getText(), text[1].getText()) == true) {
							JOptionPane.showMessageDialog(null, "로그인 성공");
							TEST2.gui.show.append("※" + users.get(cnt).getName() + "님이 로그인하셨습니다.\n");
							frame.dispose();

							new MenuView().login_to_menu();
						}
					} else if (e.getSource().equals(button[1])) {
						new CreationUserView().register();

						frame.dispose();
					} else if (e.getSource().equals(button[2])) {
						new MyCar_View_().start();
						frame.dispose();
					}

				}
			});
		}
		text[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (text[0].getText().equals("admin") && text[1].getText().equals("admin")) {
					frame.dispose();
					new AdminView().adminPage();
					return;
				}
				if (userAuth(text[0].getText(), text[1].getText()) == true) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					frame.dispose();

					new MenuView().login_to_menu();
				}

			}
		});
	}
}
