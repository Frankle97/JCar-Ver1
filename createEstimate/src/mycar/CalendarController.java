package mycar;

import java.util.Calendar;

class CalendarController {
	Calendar cal;
	String[] weeks;
	int year;
	int month;
	int days;
	int cnt;
	int one, two, three, four;
	static boolean chk = false;
	int[] mon;
	static boolean once;

	CalendarController() {
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = (cal.get(Calendar.MONTH) + 1);
		
		once = false;
		mon = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		weeks = new String[] { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
		one = 0;
		two = 100;
		three = 70;
		four = 30;
	}

	void days() {
		for (int i = 1; i < year; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				days += 366;
			} else {
				days += 365;
			}
		}
		for (int i = 0; i < month; i++) {
			mon[2] = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
			days += mon[i];
		}
	}

	String tdy() {
		String tmp = "";
		switch (cal.get(Calendar.DAY_OF_WEEK) - 1) {
		case 0:
			tmp = "일요일";
			break;
		case 1:
			tmp = "월요일";
			break;
		case 2:
			tmp = "화요일";
			break;
		case 3:
			tmp = "수요일";
			break;
		case 4:
			tmp = "목요일";
			break;
		case 5:
			tmp = "금요일";
			break;
		case 6:
			tmp = "토요일";
			break;
		}
		return tmp;
	}

}
