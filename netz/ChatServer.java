package netz;

import java.util.ArrayList;
import java.util.Collections;

public class ChatServer extends Server {

	public ChatServer(int pPort) {
		super(pPort);
		// TODO Auto-generated constructor stub
		System.out.println("server is gestartet");
	}

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		
		ArrayList<String> msgPart = new ArrayList<String>();
		String[] m = pMessage.split(":");
		Collections.addAll(msgPart, m);
		
		switch(msgPart.get(0).toUpperCase()) {
		case "QUIT":
			this.send(pClientIP, pClientPort, "keine lust mehr auf dich...der server beendet sich");
			this.closeConnection(pClientIP, pClientPort);
			break;
			
		case "SEND":
			this.send(pClientIP, pClientPort, msgPart.get(1));
		}
		

	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		ChatServer cs = new ChatServer(4242);
	}

}
