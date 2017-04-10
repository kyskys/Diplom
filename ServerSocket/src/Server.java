import java.io.*;
import java.net.*;

class StreamReader extends Thread {
	DataOutputStream dis = null;

	public StreamReader(DataOutputStream dis) {
		this.dis = dis;
	}

	@Override
	public void run() {
		String line = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		while (line != "exit") {
			try {
				line = keyboard.readLine();
				dis.writeUTF(line);
				dis.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Server {
	private final static int port = 52325;
	private final static String SERVER_INITIALIZATION = "Server started, waiting for a client...";
	private final static String SERVER_CONNECTION_SUCCESS = "Client connected";

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			System.out.println(SERVER_INITIALIZATION);
			Socket s = ss.accept();
			System.out.println(SERVER_CONNECTION_SUCCESS);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			StreamReader sr = new StreamReader(out);
			sr.start();
			while (true) {
				System.out.println(in.readUTF());
			}
			// TODO через класс Message обработать msg, внутри сотворить
			// махинации, вернуть новый msg
			// out.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
