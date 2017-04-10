import java.io.*;
import java.net.*;

public class Server {
	private final static int port = 6565;

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ServerSocket ss = new ServerSocket(port);
			Socket s = ss.accept();
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
