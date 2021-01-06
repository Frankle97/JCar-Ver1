package mycar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminView extends MycarController {
	JFrame frame;
	JTable table, table2;
	DefaultTableModel model, model2;
	String[] column, column2;
	Object[][] data, data2;
	JScrollPane scrollpane, scrollpane2;
	JLabel[] label;
	JButton button;

	
	AdminView() {
		frame = new JFrame("관리자전용 페이지");
		label = new JLabel[] { new JLabel("전체회원정보"), new JLabel("시승예약현황") };
		column = new String[] { "NAME", "ID", "PW", "CONTACT" };
		column2 = new String[] { "NAME", "YEAR", "MONTH", "DATE", "HOUR" };
		data = new Object[][] {};
		data2 = new Object[][] {};
		model = new DefaultTableModel(data, column);
		model2 = new DefaultTableModel(data2, column2);
		table = new JTable(model);
		table2 = new JTable(model2);
		scrollpane = new JScrollPane(table);
		scrollpane2 = new JScrollPane(table2);
		button = new JButton("돌아가기");
		for (int i = 0; i < users.size(); i++) {
			try {
				if (users.get(cnt).getReservYear().equals(null)) {
					return;
				} else {
					Object[] tmp = { users.get(i).getName(), users.get(i).getReservYear(),
							users.get(i).getReservMonth(), users.get(i).getReservDate(), users.get(i).getReservTime() };
					model2.addRow(tmp);
				}
			} catch (Exception ee) {

			}
		}
		for (int i = 0; i < users.size(); i++) {
			Object[] tmp = { users.get(i).getName(), users.get(i).getId(), users.get(i).getPw(),
					users.get(i).getPhonenumber() };
			model.addRow(tmp);
		}
	}

	void adminPage() {
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.add(scrollpane);
		frame.add(scrollpane2);
		frame.add(button);
		for (int i = 0; i < label.length; i++) {
			frame.add(label[i]);
			label[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			label[i].setForeground(Color.WHITE);
		}
		

		scrollpane.setBounds(0, 50, 500, 150);
		label[0].setBounds(180, 0, 200, 50);
		label[1].setBounds(180, 200, 200, 50);
		scrollpane2.setBounds(0, 250, 500, 150);
		button.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setBounds(180, 410, 150, 50);
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new MyCar_View_().start();
			}
		});

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				
				if (JOptionPane.showConfirmDialog(null, "정말 회원정보를 삭제하시겠습니까?") == 0) {
					TEST2.gui.show.append("※" + users.get(row).getName() + "님의 데이터가 삭제되었습니다.\n");
					users.remove(row);
					model.removeRow(row);
					
					try {
						model2.removeRow(row);
					} catch (Exception ee) {

					}

					JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다.");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		table2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table2.getSelectedRow();
				if (JOptionPane.showConfirmDialog(null, "시승예약을 취소하시겠습니까?") == 0) {
					TEST2.gui.show.append("[INFO-ADMIN] " + users.get(row).getName() + "님의 시승예약이 취소되었습니다..\n");
					users.get(row).setReservYear(null);
					users.get(row).setReservMonth(null);
					users.get(row).setReservTime(null);
					users.get(row).setReservDate(null);
					model2.removeRow(row);
					JOptionPane.showMessageDialog(null, "취소가 완료되었습니다.");
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
	}
}
