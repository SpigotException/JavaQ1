package netz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ChatServer extends Server {
	private User mu;
	private ArrayList<User> uList;
	private ArrayList<User> aktiveUser = new ArrayList<>();

	public ChatServer(int pPort) {
		super(pPort);

		System.out.println("server is gestartet");
		uList = new ArrayList<>();
		initUserList();
		mu = null;
	}

	private void initUserList() {
		User u1 = new User("Jonass", "123", "11", 1, false);
		uList.add(u1);
		User u2 = new User("jakpie", "1234", "12", 2, false);
		uList.add(u2);
	}

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}

	private int zustand;

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {

		ArrayList<String> msgPart = new ArrayList<String>();
		String[] m = pMessage.split(":");
		Collections.addAll(msgPart, m);

		switch (msgPart.get(0).toUpperCase()) {
			case "QUIT":
				this.send(pClientIP, pClientPort, "keine lust mehr auf dich...der server beendet sich");
				this.closeConnection(pClientIP, pClientPort);
				break;

			case "CONNECT":
				if (zustand == 0) {
					String eingabenname = msgPart.get(1);
					String password = msgPart.get(2);
					// ist der user in der Liste?
					User mainUser = null;

					for (User obj : uList) {
						if (obj.getName().equals(eingabenname)) {
							// Objekt gefunden
							mainUser = obj;
							mu = mainUser;
						}
					}
					if (mainUser == null) {
						this.send(pClientIP, pClientPort, "Der eingegebne name ist nicht registriert");
					} else if (mainUser.getPw().equalsIgnoreCase(password)) {
						this.send(pClientIP, pClientPort, "du bist jezt als " + mainUser.getName() + " angemeldet");
						zustand = 1;

						aktiveUser.add(mainUser);

					} else {
						this.send(pClientIP, pClientPort, "password leider falsch du hund");

					}

				} else
					this.send(pClientIP, pClientPort, "du bist schon angemeldet. ");

				break;
			case "MSG":

				User toUser = null;

				for (User obj : aktiveUser) {
					if (obj.getName().equals(msgPart.get(1))) {
						// Objekt gefunden
						toUser = obj;
					}
					if (toUser == null) {
						this.send(pClientIP, pClientPort, "den affen gibt es nicht...");
					} else
						this.send(toUser.getIp(), toUser.getPort(), msgPart.get(2));
				}

				break;

			case "TEST":
				String msg = msgPart.get(1);
				try {
					this.send(pClientIP, pClientPort, msg);
				} catch (Exception e) {
					System.out.println("array nicht lang genug");
				}

				break;
			case "LOGOUT":

				for (User obj : aktiveUser) {
					if (obj.equals(mu)) {
						// Objekt gefunden
						aktiveUser.remove(obj);
					}
				}
				mu = null;
				zustand = 0;
				send(pClientIP, pClientPort, "du hast dich abgemeldet");
				break;
			default:
				switch (zustand) {
					case 0:
						this.send(pClientIP, pClientPort, "Du musst dich anmelden um den server zu verwenden");
						break;
					case 1:
						this.send(pClientIP, pClientPort, "es stehen dir nur die folgenden befehle zur verfügung!");
					default:
						break;
				}

		}

	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		ChatServer cs = new ChatServer(4242);
	}

	public static String generateRandomIP() {
		Random random = new Random();
		return random.nextInt(256) + "." +
				random.nextInt(256) + "." +
				random.nextInt(256) + "." +
				random.nextInt(256);
	}

}
