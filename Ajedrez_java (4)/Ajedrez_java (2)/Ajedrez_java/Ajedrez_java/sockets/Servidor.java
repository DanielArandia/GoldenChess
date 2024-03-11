package sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Manejar la conexión con el cliente en un hilo separado
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
