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

public class CreationUserView extends MycarController {
	JFrame frame;
	JButton[] button;
	JLabel[] label;
	JTextField[] text;
	ImageIcon[] icon;
	static boolean checkone;

	public CreationUserView() {
		checkone = false;
		icon = new ImageIcon[] { new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis_BLACK.png")))

		};
		frame = new JFrame("회원가입 페이지");
		text = new JTextField[] { new JTextField(), new JTextField(), new JTextField(), new JTextField() };
		label = new JLabel[] { new JLabel(icon[0]), new JLabel("성함 : "), new JLabel("아이디 : "), new JLabel("비밀번호 : "),
				new JLabel("연락처 : ") };
		button = new JButton[] { new JButton("가입완료"), new JButton("돌아가기"), new JButton("중복확인") };

	}

	void register() {
		frame.getContentPane().setBackground(Color.BLACK);
		for (int i = 0; i < text.length; i++) {
			frame.add(text[i]);
		}
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 450);
		frame.setResizable(false);
		frame.setLayout(null);
		for (int i = 0; i < label.length; i++) {
			frame.add(label[i]);
			if (i != 0)
				label[i].setForeground(Color.WHITE);
		}
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
		}
		text[0].requestFocus();
		for (int i = 0, j = 90, c = 0; i <= text.length; i++, j += 70, c += 65) {
			if (i < text.length) {
				text[i].setBounds(160, j, 200, 30);
			}
			label[i].setBounds(95, c, 300, 100);
		}

		button[2].setBounds(380, 160, 100, 30);
		button[0].setBounds(160, 360, 100, 30);
		button[1].setBounds(270, 360, 90, 30);

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					if (e.getSource().equals(button[0])) {
						if (checkone != true) {
							JOptionPane.showMessageDialog(null, "중복확인을 해주세요.");
							button[2].requestFocus();
							return;
						}
						if (text[0].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "이름을 정확히 입력해주세요.");
							text[0].requestFocus();
							return;
						}
						if (text[1].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 정확히 입력해주세요.");
							text[1].requestFocus();
							return;
						}
						if (text[2].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "비밀번호를 정확히 입력해주세요.");
							text[2].requestFocus();
							return;
						}
						if (text[3].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "연락처를 정확히 입력해주세요.");
							text[3].requestFocus();
							return;
						}

						name = text[0].getText();
						id = text[1].getText();
						pw = text[2].getText();
						number = text[3].getText();

						new MycarController().add(id, pw, name, number, when);
						TEST2.gui.show.append("※" + name + "님이 회원가입 하셨습니다.\n");
						JOptionPane.showMessageDialog(null, "회원가입 완료\n메인페이지로 돌아갑니다.");
						checkone = false;
						new MyCar_View_().start();
						frame.dispose();

					} else if (e.getSource().equals(button[1])) {
						new MyCar_View_().start();
						frame.dispose();
					} else if (e.getSource().equals(button[2])) {
						if (text[1].getText().equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
							text[1].requestFocus();
							return;
						}
						if (users.size() == 0) {
							JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
							checkone = true;
							return;
						}
						for (int i = 0; i < users.size(); i++) {
							if (text[1].getText().equals(users.get(i).getId())) {
								JOptionPane.showMessageDialog(null, "중복된 아이디입니다.\n다시 입력해주세요.");
								text[1].requestFocus();
								return;
							} else if (i == users.size() - 1) {
								JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
								checkone = true;

							}

						}
					}

				}
			});
		}

	}
}
