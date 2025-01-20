package netz;

import java.util.Random;

public class User {

    private String name;
    private String pw;
    private String ip;
    private int port;
    private int zustand;
    private boolean admin;
    public User(String name, String pw, String ip, int port, boolean admin) {
        this.name = name;
        this.pw = pw;
        this.ip = ip;
        this.port = port;
   
        this.admin = admin;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", pw=" + pw + ", ip=" + ip + ", port=" + port + ", zustand=" + zustand
                + ", admin=" + admin + ", getName()=" + getName() + ", getPw()=" + getPw() + ", getIp()=" + getIp()
                + ", getPort()=" + getPort() + ", getZustand()=" + getZustand() + ", isAdmin()=" + isAdmin()
                + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
                + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public int getZustand() {
        return zustand;
    }
    public void setZustand(int zustand) {
        this.zustand = zustand;
    }
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }



}
