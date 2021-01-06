package mycar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyinfoView extends MycarController {
	JFrame frame;
	JButton[] button;
	JLabel[] label;
	JPanel panel;
	Calendar cal = Calendar.getInstance();
	ImageIcon[] icon;

	MyinfoView() {
		icon = new ImageIcon[] { new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis_BLACK.png"))) };
		frame = new JFrame("내 정보 페이지");
		label = new JLabel[] { new JLabel(icon[0]), new JLabel("이름 : " + users.get(cnt).getName()),
				new JLabel("아이디 : " + users.get(cnt).getId()), new JLabel("비밀번호 : " + users.get(cnt).getPw()),
				new JLabel("연락처 : " + users.get(cnt).getPhonenumber()), new JLabel(users.get(cnt).getWhenadd()) };
		panel = new JPanel(new GridLayout());
		button = new JButton[] { new JButton("아이디 변경"), new JButton("비밀번호 변경"), new JButton("연락처 수정"),
				new JButton("돌아가기"), new JButton("회원탈퇴") };
	};

	void myInfo() {
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
			button[i].setFont(new Font("맑은 고딕", Font.BOLD, 23));
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		for (int i = 0; i < label.length; i++) {
			frame.add(label[i]);
			label[i].setFont(new Font("맑은 고딕", Font.BOLD, 17));
			label[i].setForeground(Color.WHITE);
		}
		
		
		label[0].setBounds(100, 20, 300, 50);
		label[1].setBounds(80, 80, 300, 50);
		button[0].setBounds(250, 130, 210, 30);
		label[2].setBounds(80, 120, 300, 50);
		button[1].setBounds(250, 170, 210, 30);
		label[3].setBounds(80, 160, 300, 50);
		button[2].setBounds(250, 210, 210, 30);
		label[4].setBounds(80, 200, 300, 50);
		button[3].setBounds(150, 300, 200, 50);
		label[5].setBounds(80, 250, 400, 50);
		button[4].setBounds(150, 370, 200, 50);

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						String input_id = JOptionPane.showInputDialog("변경하실 아이디를 입력해주세요.");
						for (int i = 0; i < users.size(); i++) {
							if (users.get(i).getId().equals(input_id)) {
								JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");
								return;
							} else if (i == users.size() - 1) {
								users.get(cnt).setId(input_id);
								JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
							}
						}
						label[2].setText("아이디 : " + users.get(cnt).getId());
					} else if (e.getSource().equals(button[1])) {
						users.get(cnt).setPw(JOptionPane.showInputDialog("변경하실 비밀번호를 입력해주세요."));
						JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
						label[3].setText("비밀번호 : " + MycarController.users.get(cnt).getPw());
					} else if (e.getSource().equals(button[2])) {
						users.get(cnt).setPhonenumber(JOptionPane.showInputDialog("수정하실 연락처를 입력해주세요."));
						JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.");
						label[4].setText("연락처 : " + users.get(cnt).getPhonenumber());
					} else if (e.getSource().equals(button[3])) {
						new MenuView().login_to_menu();
						frame.dispose();
					} else if (e.getSource().equals(button[4])) {
						int chk = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?");
						if (chk == 0) {
							String idchk = JOptionPane.showInputDialog("ID를 입력하시면 탈퇴가 완료됩니다.");
							if (idchk.equals(users.get(cnt).getId())) {
								JOptionPane.showMessageDialog(null, "탈퇴가 정상적으로 완료되었습니다.");
								TEST2.gui.show.append("※" + users.get(cnt).getName() + "님이 탈퇴하셨습니다.\n");
								users.remove(cnt);
								frame.dispose();
								new MyCar_View_().start();
							} else {
								JOptionPane.showMessageDialog(null, "아이디가 일치하지 않습니다.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "탈퇴가 취소되었습니다.");
						}
					}

				}
			});
		}
	}

}
