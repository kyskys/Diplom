import java.io.*;
import java.net.*;

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
			String line = null;
			while (true) {
				line = in.readUTF();
				System.out.println("Message arrived:"+line+", recending it back");
				out.writeUTF(line + " by server");
			}
			
			// TODO через класс Message обработать msg, внутри сотворить
			// махинации, вернуть новый msg
			//out.writeObject(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
