package view;

import tcp.ServerConnection;

public class UIClient {

	private DialogDisconnect dialogDis;
	private StartingFrame startingFrame;
	private ServerConnection serverConn = null;
	
	
	public UIClient(ServerConnection serverConn) {
		this.serverConn = serverConn;
		
		if (serverConn.hasConnect()) {
			startingFrame = new StartingFrame("TRA CỨU ĐIỂM THI",serverConn);
			
		} else {
			dialogDis = new DialogDisconnect("Không Thể Kết Nối");
		}
		
	}
}
