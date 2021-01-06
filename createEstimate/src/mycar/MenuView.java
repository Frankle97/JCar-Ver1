package mycar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class MenuView extends MycarController {
	JFrame frame;
	JButton[] button;
	JLabel[] label;
	ImageIcon[] icon;
	Font font;
	boolean flag;
	Test client;

	MenuView() {

		flag = false;
		font = new Font("맑은 고딕", Font.BOLD, 25);
		frame = new JFrame("인포 페이지");
		icon = new ImageIcon[] { new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis_BLACK.png"))) };
		button = new JButton[] { new JButton("견적내기"), new JButton("견적확인"), new JButton("견적삭제"), new JButton("시승신청"),
				new JButton("돌아가기"), new JButton("시승예약확인"), new JButton("회원정보"), new JButton("실시간상담채팅"),
				new JButton("최근 이슈보기") };
		label = new JLabel[] { new JLabel(icon[0]) };
		client = new Test();

	}

	void login_to_menu() {

		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
		frame.setSize(500, 900);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
			button[i].setFont(font);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		frame.add(label[0]);
		label[0].setBounds(90, 0, 300, 80);

		for (int i=0, j=70; i<button.length; i++, j+=100) {
			if (i==4) { j-=100; continue; }
			button[i].setBounds(130, j, 230, 80); 
		}
		button[4].setBounds(350, 10, 140, 40);
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						if (users.get(cnt).getPrice() != 0) {
							JOptionPane.showMessageDialog(null, "견적이 이미 존재합니다.");
							return;
						} else {
							new ChoiceModelView().choiceModel();
							frame.dispose();
						}
					} else if (e.getSource().equals(button[1])) {
						if (users.get(cnt).getPrice() == 0) {
							JOptionPane.showMessageDialog(null, "저장된 견적이 존재하지 않습니다.");
							return;
						}
						JOptionPane.showMessageDialog(null, users.get(cnt));
					} else if (e.getSource().equals(button[2])) {
						if (users.get(cnt).getPrice() == 0) {
							JOptionPane.showMessageDialog(null, "저장된 견적이 존재하지 않습니다.");
							return;
						}
						int ok = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?");
						if (ok == 0) {
							users.get(cnt).setPrice(0);
							users.get(cnt).setOutcolor(null);
							users.get(cnt).setIncolor(null);
							users.get(cnt).setOption(null);
							JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "삭제가 취소되었습니다.");
						}
					} else if (e.getSource().equals(button[3])) {
				
						
						try {
							if (users.get(cnt).getReservDate().equals(null)) {
								JOptionPane.showMessageDialog(null, "예약을 원하시는 날짜를 선택해주세요.");
								new CalendarView().createGui();
							} else {
								JOptionPane.showMessageDialog(null, "이미 시승예약을 하셨습니다.");
								return;
							}
						} catch (Exception ee) {

							JOptionPane.showMessageDialog(null, "예약을 원하시는 날짜를 선택해주세요.");
							new CalendarView().createGui();
						}
						
					} else if (e.getSource().equals(button[4])) {
						client.gui.show.setText("");
						client.gui.frame.setVisible(false);;
						TEST2.gui.show.append("※" + users.get(cnt).getName() + "님이 로그아웃하셨습니다.\n");

						frame.dispose();
						new MyCar_View_().start();

					} else if (e.getSource().equals(button[5])) {
						
						try {
							if (users.get(cnt).getReservDate().equals(null)) {
								JOptionPane.showMessageDialog(null, "예약된 정보가 존재하지 않습니다.");
							} else {
								String tmp = "==" + users.get(cnt).getName() + "님의 시승예약 정보==\n"
										+ users.get(cnt).getReservYear() + "년 " + users.get(cnt).getReservMonth() + "월 "
										+ users.get(cnt).getReservDate() + "일 " + users.get(cnt).getReservTime()
										+ "시로 예약되었습니다.";
								JOptionPane.showMessageDialog(null, tmp);
							}
						} catch (Exception ee) {
							JOptionPane.showMessageDialog(null, "예약된 정보가 존재하지 않습니다.");
						}
					} else if (e.getSource().equals(button[6])) {
						frame.dispose();
						new MyinfoView().myInfo();

					} else if (e.getSource().equals(button[7])) {
						if (flag) {
							client.gui.frame.setVisible(true);
						} else {
							client.start();
							flag = true;
						}

					} else if (e.getSource().equals(button[8])) {
						new TodayIssueView().showIssue();
					}

				}
			});
		}

	}

}
