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

class SetView extends MycarController {
	JFrame frame;
	JButton[] button, colors, colorsouts, option;
	JLabel[] label, car;
	String incolor, outcolor, opt = "";
	ImageIcon[] icon;
	ImageIcon[] cars;
	ImageIcon[] color;
	ImageIcon[] options;
	Font font, font2;

	SetView() {
		color = new ImageIcon[] {
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("Color_White.jpg"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("Color_Silver.jpg"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("Color_Blue.jpg"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Color_Red.jpg"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("Color_Black.jpg"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("inColor1.jpg"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("inColor2.jpg"))) };

		icon = new ImageIcon[] { new ImageIcon(
				Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis.png"))) };
		cars = new ImageIcon[] {
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("CAR_WHITE.PNG"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("CAR_SILVER.PNG"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("CAR_BLUE.PNG"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("CAR_RED.PNG"))),
				new ImageIcon(Toolkit.getDefaultToolkit()
						.getImage(getClass().getClassLoader().getResource("CAR_BLACK.PNG"))) };

		options = new ImageIcon[] {
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("option1.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("option2.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("option3.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("option4.png"))) };

		frame = new JFrame("내 차 만들기 페이지");
		button = new JButton[] { new JButton("돌아가기"), new JButton("견적 저장하기") };
		colors = new JButton[] { new JButton(color[0]), new JButton(color[1]), new JButton(color[2]),
				new JButton(color[3]), new JButton(color[4]) };
		colorsouts = new JButton[] { new JButton(color[5]), new JButton(color[6]) };
		option = new JButton[] { new JButton(options[0]), new JButton(options[1]), new JButton(options[2]),
				new JButton(options[3]) };
		String tmp = Integer.toString(price);
		label = new JLabel[] { new JLabel(icon[0]), new JLabel("외장색상 선택"), new JLabel("내장색상 선택"), new JLabel("옵션 선택"),
				new JLabel(tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원"),
				new JLabel("견적가격") };
		car = new JLabel[] { new JLabel(cars[0]), new JLabel(cars[1]), new JLabel(cars[2]), new JLabel(cars[3]),
				new JLabel(cars[4]) };
		options = new ImageIcon[] { new ImageIcon("src\\MyCar_Ver3\\option1.png") };
		font = new Font("맑은 고딕", Font.BOLD, 18);
		font2 = new Font("한컴 소망 B 보통", Font.BOLD, 28);
	}

	void model_Ver1() {
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setSize(1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setBackground(Color.BLACK);
			button[i].setForeground(Color.WHITE);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		for (int i = 0; i < label.length; i++) {
			frame.add(label[i]);
			if (i != 4) {
				label[i].setFont(font);
			}
			if (i == 4) {
				label[4].setFont(font2);
			}
		}
		for (int i = 0, j = 170; i < colors.length; i++, j += 60) {
			frame.add(colors[i]);
			colors[i].setBounds(j, 80, 40, 40);
		}
		for (int i = 0, j = 140; i < colorsouts.length; i++, j += 45) {
			frame.add(colorsouts[i]);
			colorsouts[i].setBackground(Color.WHITE);
			colorsouts[i].setBorderPainted(false);
			colorsouts[i].setBounds(170, j, 280, 40);
		}
		for (int i = 0, j = 250; i < option.length; i++, j += 105) {
			frame.add(option[i]);
			option[i].setBounds(170, j, 590, 100);
		}
		for (int i = 0; i < car.length; i++) {
			frame.add(car[i]);
			car[i].setBounds(850, 300, 550, 250);
		}
		button[0].setBounds(635, 680, 120, 40);
		button[1].setBounds(500, 680, 130, 40);
		label[0].setBounds(160, 10, 300, 50);
		label[1].setBounds(40, 50, 300, 100);
		label[2].setBounds(40, 135, 300, 100);
		label[3].setBounds(50, 235, 300, 100);
		label[4].setForeground(new Color(163, 107, 79));
		label[4].setBounds(130, 650, 300, 100);
		label[5].setBounds(50, 650, 300, 100);

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						price = 0;
						users.get(cnt).setPrice(0);
						frame.dispose();
						new ChoiceModelView().choiceModel();
					} else if (e.getSource().equals(button[1])) {
						if (incolor == null) {
							JOptionPane.showMessageDialog(null, "외장색상을 선택해주세요.");
							return;
						}
						if (outcolor == null) {
							JOptionPane.showMessageDialog(null, "내장색상을 선택해주세요.");
							return;
						}

						users.get(cnt).setPrice(price);
						users.get(cnt).setIncolor(incolor);
						users.get(cnt).setOutcolor(outcolor);
						users.get(cnt).setOption(opt);
						price = 0;
						TEST2.gui.show.append("※" + users.get(cnt).getName() + "님이 견적을 생성하였습니다.\n");
						JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.\n메인으로 돌아갑니다.");
						frame.dispose();
						new MenuView().login_to_menu();
					}
				}
			});
		}
		for (int i = 0; i < colors.length; i++) {
			colors[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(colors[0])) {
						incolor = "WHITE";
						car[0].setVisible(true);
						for (int i = 0; i < car.length; i++) {
							if (i != 0)
								car[i].setVisible(false);
						}
					} else if (e.getSource().equals(colors[1])) {
						incolor = "SILVER";
						car[1].setVisible(true);
						for (int i = 0; i < car.length; i++) {
							if (i != 1)
								car[i].setVisible(false);
						}
					} else if (e.getSource().equals(colors[2])) {
						incolor = "BLUE";
						car[2].setVisible(true);
						for (int i = 0; i < car.length; i++) {
							if (i != 2)
								car[i].setVisible(false);
						}
					} else if (e.getSource().equals(colors[3])) {
						incolor = "RED";
						car[3].setVisible(true);
						for (int i = 0; i < car.length; i++) {
							if (i != 3)
								car[i].setVisible(false);
						}
					} else if (e.getSource().equals(colors[4])) {
						incolor = "BLACK";
						car[4].setVisible(true);
						for (int i = 0; i < car.length; i++) {
							if (i != 4)
								car[i].setVisible(false);
						}

					}
				}
			});
		}
		colorsouts[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				colorsouts[0].setBounds(170, 160, 280, 40);
				colorsouts[1].setVisible(false);
				outcolor = "블랙/블랙";
			}
		});
		colorsouts[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				colorsouts[1].setBounds(170, 160, 280, 40);
				colorsouts[0].setVisible(false);
				outcolor = "블랙/샌드";
			}
		});

		for (int i = 0; i < option.length; i++) {
			option[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(option[0])) {
						option[0].setEnabled(false);
						price += 2500000;
						String tmp = Integer.toString(price);
						label[4].setText(
								tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원");
						opt += "HTRAC (전자식AWD)\n";
					} else if (e.getSource().equals(option[1])) {
						option[1].setEnabled(false);
						price += 700000;
						String tmp = Integer.toString(price);
						label[4].setText(
								tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원");
						opt += "시트 패키지\n";
					} else if (e.getSource().equals(option[2])) {
						option[2].setEnabled(false);
						price += 800000;
						String tmp = Integer.toString(price);
						label[4].setText(
								tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원");
						opt += "와이드 선루프\n";
					} else if (e.getSource().equals(option[3])) {
						option[3].setEnabled(false);
						price += 400000;
						String tmp = Integer.toString(price);
						label[4].setText(
								tmp.substring(0, 2) + "," + tmp.substring(2, 5) + "," + tmp.substring(5) + "원");
						opt += "후측방 충돌&후방 교차 충돌 경고\n";
					}

				}
			});
		}
	}

}
