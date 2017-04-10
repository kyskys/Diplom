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
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
			while (line!="exit") {
				line = keyboard.readLine();
				out.writeUTF(line);
				out.flush();
				line = in.readUTF();
				System.out.println(line);
			}
			// TODO через класс Message обработать msg, внутри сотворить
			// махинации, вернуть новый msg
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
