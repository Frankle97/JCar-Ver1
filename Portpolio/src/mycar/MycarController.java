package mycar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

class MycarController {
	Calendar cal = Calendar.getInstance();
	static ArrayList<UserDto> users = new ArrayList<>();
	String id, pw, name, number, when;
	static int cnt;
	public final static int SMART = 37777000;
	public final static int MODERN = 43870000;
	public final static int SPORTS = 53320000;
	public static int price;
	SimpleDateFormat format;
	static boolean once;

	MycarController() {
		format = new SimpleDateFormat("가입날짜 : yyyy년 MM월 dd일 HH시 mm분");
		when = format.format(Calendar.getInstance().getTime());

	}

	void add(String id, String pw, String name, String number, String when) {
		users.add(new UserDto(id, pw, name, number, when));
	}

	static boolean userAuth(String id, String pw) {
		if (id.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
			return false;
		}
		if (pw.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
			return false;
		}

		if (users.size() != 0) {
			for (int i = 0; i < users.size(); i++) {
				if (id.equals(users.get(i).getId()) && pw.equals(users.get(i).getPw())) {
					MenuView.cnt = i;

					return true;
				} else if (i == users.size() - 1) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인해주세요.", "로그인 실패", JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}
}
