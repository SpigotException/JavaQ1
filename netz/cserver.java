package netz;

import java.util.ArrayList;
import java.util.Collections;

import linear.Stack;

public class cserver extends Server {
    private ArrayList<User> uList;
    Stack<String>  verlauf = new Stack<String>();
    public cserver(int pPort) {
        super(pPort);
        System.out.println("server startet..");
        uList = new ArrayList<>();
        initUserList();
    }

    private void initUserList() {
        User u1 = new User("Jonass", "123", "none", -1, false);
        uList.add(u1);
        User u2 = new User("jakpie", "1234", "none", -1, false);
        uList.add(u2);
    }

    public User getConnectedUser(String pClientIP, int pClientPort) {
        for (User u : uList) {
            if (u.getIp().equals(pClientIP) && u.getPort() == pClientPort) {
                return u;

            }
        }

        return null;
    }

    

    private void loginUser(User user, String pClientIP, int pClientPort) {
        user.setIp(pClientIP);
        user.setPort(pClientPort);
        user.setZustand(1);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {

        ArrayList<String> msgPart = new ArrayList<String>();
        String[] m = pMessage.split(":");
        Collections.addAll(msgPart, m);

        switch (msgPart.get(0).toUpperCase()) {
            case "CONNECT":
                String eingabePassword = msgPart.get(2);
                String eingabeName = msgPart.get(1);
                boolean userGefunden = false;
        
                for(User user: uList) {
                    if (user.getName().equalsIgnoreCase(eingabeName)) {
                        userGefunden = true;
                        if(user.getPw().equals(eingabePassword)) {  
                            
                            loginUser(user, pClientIP, pClientPort);
                            this.send(pClientIP, pClientPort, "Du bist angemeldet");
                            System.out.println(pClientIP+pClientPort);
                        } else {
                            this.send(pClientIP, pClientPort, "Falsches Passwort");
                        }
                        break; 
                    }
                }
                
                if (!userGefunden) {
                    this.send(pClientIP, pClientPort, "User gibt es nicht");
                }
                break;
                case "LOGOUT":
                User u = getConnectedUser(pClientIP, pClientPort);
                u.setIp("null");
                u.setPort(-1);
                this.send(pClientIP, pClientPort, "Du hast dich abgemeldet");
                break;
                
                case "MSG":
                User u1 = getConnectedUser(pClientIP, pClientPort);
                String msg = msgPart.get(1);
               this.sendToAll(u1.getName()+": "+msg);
           
                verlauf.push(u1.getName()+": "+ msg);
              
                break;
                case "VERLAUF":
                   String top= verlauf.top();
                   this.send(pClientIP, pClientPort, top);

                break;
                default: 
                this.send(pClientIP, pClientPort, "Den befehl gibt es nicht");
                break;
        }
        

     
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processClosingConnection'");
    }

    public static void main(String[] args) {
        cserver cs = new cserver(1939);
    }
}
