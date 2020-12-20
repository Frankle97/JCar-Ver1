package mycar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

class Test extends Thread {
	ServerSocket serverSocket = null;
	Socket socket = null;
	ChatTimer timer = new ChatTimer();
	ChatGui gui = new ChatGui();
	GuiSender sender;
	GuiReceiver receiver;
	
	public Test() {}
	@Override
	public void run() {

		new Thread(timer).start();

		GuiReceiver.name = MycarController.users.get(MycarController.cnt).getName();
		gui.frame.setTitle("[FOR CLIENT]");
		gui.createGui();
		gui.frame.setBounds(0, 0, 400, 400);

		gui.text.requestFocus();
		try {
			socket = new Socket("127.0.0.1", 523);
			gui.show.append("※채팅을 시작합니다.※ \n");
			gui.show.append(GuiReceiver.name + "님 어서오세요.\n");

			new GuiSender(socket, gui).start();
			new GuiReceiver(socket, gui).start();

		} catch (UnknownHostException ee) {

		} catch (IOException e) {
		}

		while (true) {
			gui.label.setText(timer.getNow());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				return;
			}
		}

	}
}
