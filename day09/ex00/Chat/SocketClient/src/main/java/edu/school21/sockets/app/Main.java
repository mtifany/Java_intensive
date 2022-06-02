package  edu.school21.sockets.app;
import java.io.*;
import java.net.Socket;

public class Main {

    private static Socket clientSocket = null;
    private static BufferedReader reader = null;
    private static BufferedReader in = null;
    private static BufferedWriter out = null;

    public static void main(String[] args) {
        try {

            clientSocket = new Socket("localhost", Integer.parseInt(args[1].substring(12)));

            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String serverMsg = in.readLine();
            System.out.println(serverMsg);
            String signupcmd = reader.readLine();
            out.write(signupcmd + "\n");
            out.flush();
            String server1 = in.readLine();
            System.out.println(server1);
            String userName = reader.readLine();
            out.write(userName + "\n");
            out.flush();
            String server2 = in.readLine();
            System.out.println(server2);
            String password = reader.readLine();
            out.write(password + "\n");
            out.flush();
            String server3= in.readLine();
            System.out.println(server3);
        } catch (IOException e) {
                  System.err.println(e);
        }
       finally {
         try {
               clientSocket.close();
               in.close();
               out.close();
           } catch (IOException e) {
              e.printStackTrace();
           }
        }
    }
}