package tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import connection.Config;
import view.DialogDisconnect;
import view.UIClient;

public class Client {


	private UIClient uiClient ;
	private Socket s= null;
	private final String ipAddress = "";
	private final int port = Integer.parseInt(Config.PORT.getvalue());
	
	private ServerConnection serverConn = null;
	
	public Client() {
		try {
			
			s = new Socket(InetAddress.getLocalHost().getHostAddress(), port);
			serverConn = new ServerConnection(s);
			showLayout();
		} catch (Exception e) {
			new DialogDisconnect("Disconnected");
		} 
		
	}
	
	public void showLayout() {
		uiClient = new UIClient(serverConn);
		
	}
	public void getData() {
		
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		
		
	}
	
}
