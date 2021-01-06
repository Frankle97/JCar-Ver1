package mycar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

class ChatTimer implements Runnable {
	SimpleDateFormat format;
	String now;
	ChatGui gui;

	public ChatTimer() {
		format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		now = "";
		gui = new ChatGui();
	}

	@Override
	public void run() {
		while (true) {
			now = format.format(Calendar.getInstance().getTime());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
	}

}
