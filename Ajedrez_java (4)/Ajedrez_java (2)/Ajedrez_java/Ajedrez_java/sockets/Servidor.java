package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public Servidor(){
        try {
            ServerSocket serverSocket = new ServerSocket(49356);
            


            while (true) {
                System.out.println("antes de que se aceptara la conexion");
                Socket clientSocket = serverSocket.accept();
                System.out.println("se aceptó la conexion");
                new Thread(new ClientHandler(clientSocket)).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
