import java.io.*;
import java.net.*;
import java.util.Properties;

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
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			Object msg = in.readObject();
			// TODO через класс Message обработать msg, внутри сотворить
			// махинации, вернуть новый msg
			out.writeObject(msg);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
