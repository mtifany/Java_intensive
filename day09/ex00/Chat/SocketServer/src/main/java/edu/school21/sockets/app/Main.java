package edu.school21.sockets.app;


import edu.school21.sockets.server.Server;


public class Main {

    public static void main(String[] args) {
        Server server = new Server();

      server.start(Integer.parseInt(args[1].substring(5)));
    }
}
