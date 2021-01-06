package mycar;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TodayIssueView {
	JFrame frame;
	JLabel label;
	JButton[] button;
	JButton back;
	String[] title;
	String[] content;
	JTextArea area;
	DocumentBuilderFactory factory;
	DocumentBuilder builder;

	public TodayIssueView() {
		factory = DocumentBuilderFactory.newInstance();
		frame = new JFrame("오늘의 뉴스");
		title = new String[10];
		content = new String[10];

		inputTitle();
		inputContent();

		area = new JTextArea();
		button = new JButton[] { new JButton(title[0]), new JButton(title[1]), new JButton(title[2]),
				new JButton(title[3]), new JButton(title[4]), new JButton(title[5]), new JButton(title[6]),
				new JButton(title[7]), new JButton(title[8]), new JButton(title[9]) };
		back = new JButton("돌아가기");

	}

	public void showIssue() {
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.BLACK);
		for (int i = 0; i < button.length; i++) {
			frame.add(button[i]);
			button[i].setForeground(Color.WHITE);
			button[i].setBackground(Color.BLACK);
			button[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			button[i].setFont(new Font("맑은 고딕", Font.BOLD, 25));
			button[i].setBorderPainted(false);
		}
		frame.add(back);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		for (int i = 0, j = 20; i < 10; i++, j += 50) {
			button[i].setBounds(0, j, 1200, 50);
		}
		back.setBounds(520, 700, 150, 50);
		frame.add(area);
		area.setEditable(false);
		area.setBounds(300, 540, 600, 130);

		for (int i = 0; i < button.length; i++) {

			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource().equals(button[0])) {
						area.setText(content[0]);
					} else if (e.getSource().equals(button[1])) {
						area.setText(content[1]);
					} else if (e.getSource().equals(button[2])) {
						area.setText(content[2]);
					} else if (e.getSource().equals(button[3])) {
						area.setText(content[3]);
					} else if (e.getSource().equals(button[4])) {
						area.setText(content[4]);
					} else if (e.getSource().equals(button[5])) {
						area.setText(content[5]);
					} else if (e.getSource().equals(button[6])) {
						area.setText(content[6]);
					} else if (e.getSource().equals(button[7])) {
						area.setText(content[7]);
					} else if (e.getSource().equals(button[8])) {
						area.setText(content[8]);
					} else if (e.getSource().equals(button[9])) {
						area.setText(content[9]);
					}
				}
			});

			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
		}

	}

	void inputTitle() {
		try {

			InputStream in = getClass().getClassLoader().getResourceAsStream("hyundai.xml");
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);
			NodeList dataList = doc.getElementsByTagName("title");

			for (int i = 0; i < dataList.getLength(); i++) {
				Node data = dataList.item(i);

				if (data.getNodeType() == Element.ELEMENT_NODE) {
					NodeList subdataList = data.getChildNodes();
					for (int sub = 0; sub < subdataList.getLength(); sub++) {
						Node son = subdataList.item(sub);

						String nodeValue = son.getTextContent();
						if (i != 0 && i <= 10) {
							title[i - 1] = nodeValue;
						}

					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void inputContent() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("hyundai.xml");
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(in);

			NodeList dataList = doc.getElementsByTagName("description");
			for (int i = 0; i < dataList.getLength(); i++) {
				Node data = dataList.item(i);
				if (data.getNodeType() == Element.ELEMENT_NODE) {
					NodeList subdataList = data.getChildNodes();
					for (int sub = 0; sub < subdataList.getLength(); sub++) {
						Node son = subdataList.item(sub);

						String nodeValue = son.getTextContent();
						if (!nodeValue.contains("!CDATA") && nodeValue.contains("-")) {
							content[i - 1] = nodeValue;
						}

					}
				}
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
