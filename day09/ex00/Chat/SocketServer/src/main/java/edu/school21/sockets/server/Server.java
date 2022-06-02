package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;


public class Server {

    private Socket clientSocket = null;
    private ServerSocket server = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;
 //   UsersService usersService;

    public Server() { }

    public void start(Integer port) {

        try {
            server = new ServerSocket(port);
            clientSocket = server.accept();

            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            out.write("Hello from server\n");
            out.flush();
            String signUp = in.readLine();
            System.out.println(signUp);
            if (!signUp.equals("signUp")) {
                out.write("exit");
                out.flush();
                System.err.println("Wrong command!");
                return;
            }
            out.write("Enter username:\n");
            out.flush();
            String username = in.readLine();
            out.write("Enter password:\n");
            out.flush();


       ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
       UsersService usersService = context.getBean(UsersService.class);

            String password = in.readLine();
            if (usersService.signUp(username, password)) {
                out.write("Successful!\n");
                out.flush();
            } else {
                out.write("User already exists!\n");
                out.flush();
            }


        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                clientSocket.close();
                server.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}


//    // constructors
//    BCryptPasswordEncoder()
//    BCryptPasswordEncoder(int strength)
//    BCryptPasswordEncoder(int strength, java.security.SecureRandom random)
//
//    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
//    String encodedPassword = encoder.encode("UserPassword");
