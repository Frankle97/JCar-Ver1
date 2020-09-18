
package MyCar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyCar_View_ChoiceModel extends MyCar_Controller {
	JFrame frame;
	JButton[] button;
	JButton[] color;
	ImageIcon[] icon;

	
	MyCar_View_ChoiceModel() {

		frame = new JFrame("모델선택 페이지");
		icon = new ImageIcon[] {
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("2.0T.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("2.2D.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("3.3T.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("genesis.png"))),
				new ImageIcon(
						Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("back.png"))) };

		button = new JButton[] { new JButton(icon[0]), new JButton(icon[1]), new JButton(icon[2]), new JButton(icon[4]),
				new JButton(icon[3]) };
	}

	void choiceModel() {
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		frame.setSize(500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(null);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
		}

		button[4].setBounds(150, 10, 190, 40);
		button[4].setBorderPainted(false);
		button[0].setBounds(110, 70, 270, 80);
		button[1].setBounds(110, 170, 270, 80);
		button[2].setBounds(110, 270, 270, 80);
		button[3].setBounds(370, 10, 120, 40);
		button[3].setBorderPainted(false);
		frame.setBackground(Color.WHITE);
		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						price += SMART;
						users.get(cnt).setModel("2.0T 어드밴스드");
						frame.dispose();
						new MyCar_View_SetMyCar().model_Ver1();
					} else if (e.getSource().equals(button[1])) {
						price += MODERN;
						users.get(cnt).setModel("2.2D 엘리트");
						frame.dispose();
						new MyCar_View_SetMyCar().model_Ver1();
					} else if (e.getSource().equals(button[2])) {
						price += SPORTS;
						users.get(cnt).setModel("3.3T 스포츠 프레스티지");
						frame.dispose();
						new MyCar_View_SetMyCar().model_Ver1();
					} else if (e.getSource().equals(button[3])) {
						frame.dispose();
						new MyCar_View_Menu().login_to_menu();
					} else if (e.getSource().equals(button[4])) {
						frame.dispose();
						new MyCar_View_().start();
					}

				}
			});
		}

	}
}
