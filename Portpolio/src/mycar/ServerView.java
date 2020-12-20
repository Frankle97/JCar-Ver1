package mycar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class TEST2 extends Thread {
	ServerSocket serverSocket = null;
	Socket socket = null;
	static ChatGui gui = new ChatGui();
	ChatTimer timer = new ChatTimer();
	public GuiSender sender;
	public GuiReceiver receiver;

	public TEST2() {}
	@Override
	public void run() {
		gui.createGui();
		while (true) {
			
			gui.frame.setTitle("[FOR ADMIN]");

			try {
				serverSocket = new ServerSocket(523);
				gui.show.append("※ONLINE※\n");
			} catch (Exception e1) {

			}

			try {
				socket = serverSocket.accept();
				gui.show.append("※" + GuiReceiver.name + "님이 채팅방에 입장하셨습니다.\n");

				sender = new GuiSender(socket, gui);
				receiver = new GuiReceiver(socket, gui);
				sender.start();
				receiver.start();

			} catch (Exception e) {

			}
		}
	}
}

class TT extends TEST2 implements Runnable {

	@Override
	public void run() {
		new Thread(timer).start();
		while (true) {
			gui.label.setText(timer.getNow());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ee) {
			}
		}

	}
}

class GuiSender extends Thread implements ActionListener {
	DataOutputStream out;
	Socket socket;
	ChatGui gui;

	public GuiSender() {
	}

	public GuiSender(Socket socket, ChatGui gui) {
		this.gui = gui;
		this.socket = socket;
		try {

			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {

			return;

		}
		gui.buttons[0].addActionListener(this);
		gui.text.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		String now = format.format(Calendar.getInstance().getTime());

		if (!gui.text.getText().equals("")) {
			gui.show.append("[ 나 : " + now + " ] " + gui.text.getText() + "\n");
		}

		try {
			out.writeUTF(gui.text.getText());
		} catch (IOException e1) {
			System.out.println("SENDER2");
			return;
		}

		gui.text.setText("");
		gui.text.requestFocus();

	}
}

class GuiReceiver extends Thread {
	DataInputStream in;
	Socket socket;
	public static String name;
	ChatGui gui;

	public GuiReceiver() {
	}

	public GuiReceiver(Socket socket, ChatGui gui) {
		this.socket = socket;
		this.gui = gui;
		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			System.out.println("RECEIVER1");
			return;
		}
	}

	@Override
	public void run() {
		while (in != null) {
			SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
			String now = format.format(Calendar.getInstance().getTime());
			try {
				if (socket.getPort() != 523) {
					gui.show.append("[ " + GuiReceiver.name + " : " + now + " ] " + in.readUTF() + "\n");
				} else {
					gui.show.append("[ 관리자 : " + now + " ] " + in.readUTF() + "\n");
				}

			} catch (Exception e) {

				return;
			}

		}
	}
}
