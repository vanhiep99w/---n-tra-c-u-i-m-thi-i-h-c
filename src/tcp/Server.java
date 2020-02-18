package tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import connection.Config;

public class Server {

	
	private ServerSocket ss = null;
	private final int port = Integer.parseInt(Config.PORT.getvalue());
	private ExecutorService poolThread = Executors.newFixedThreadPool(4);
	private List<Socket> sockets = null;
	
	
	
	public Server() {
		sockets = new ArrayList<Socket>();
		
		try {
			System.out.println("[ Server ]: Server: "+InetAddress.getLocalHost().getHostAddress()+", Port: "+Config.PORT.getvalue());
			ss = new ServerSocket(port);
			System.out.println("[ Server ]: Server already for connect .....");
			while (true) {
				Socket s = ss.accept();
				sockets.add(s);
				System.out.println("[ Server ]: Server connect succesfully to Client");
				ClientHandler clientHandler = new ClientHandler(s);
				poolThread.execute(clientHandler);
				
				System.out.println("[ Server ]: Count of Client :" + sockets.size());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		
	}
}
