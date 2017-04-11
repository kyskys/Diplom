import java.io.*;
import java.net.*;
import java.util.Properties;

class StreamReader extends Thread {
	DataOutputStream dos = null;

	public StreamReader(DataOutputStream dis) {
		this.dos = dis;
	}

	@Override
	public void run() {
		String line = null;
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(
				System.in));
		while (line != "exit") {
			try {
				line = keyboard.readLine();
				dos.writeUTF(line);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Client {
	private static int port;
	private static InetAddress ip;

	private static void getConfig() {
		try {
			Properties p = new Properties();
			FileInputStream fis = new FileInputStream("src/config.cfg");
			p.load(fis);
			port = Integer.parseInt(p.getProperty("port"));
			ip = InetAddress.getByName(p.getProperty("ip"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			getConfig();
			@SuppressWarnings("resource")
			Socket s = new Socket(ip, port);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			StreamReader sr = new StreamReader(out);
			sr.start();
			while (true) {
				System.out.println(in.readUTF());
			}
			// TODO через класс Message обработать msg, внутри сотворить
			// махинации, вернуть новый msg
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
