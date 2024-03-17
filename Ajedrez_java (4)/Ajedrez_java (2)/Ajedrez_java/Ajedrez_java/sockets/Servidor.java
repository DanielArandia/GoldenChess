package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            try {
                // Crear un ServerSocket que escuche en el puerto 49356
                ServerSocket serverSocket = new ServerSocket(49356);

                System.out.println("Esperando conexiones entrantes...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Conexión aceptada desde: " + clientSocket.getInetAddress());

                    // Crear un nuevo hilo para manejar la conexión del cliente
                    Thread clientThread = new Thread(new ClientHandler(clientSocket));
                    clientThread.start();
                }
                // Esperar y aceptar una conexión entrante

                // Cerrar el ServerSocket
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Iniciar el hilo del servidor
        serverThread.start();

        // Continuar ejecutando otras líneas de código en el hilo principal
        System.out.println("El servidor sigue ejecutando otras tareas mientras espera conexiones...");
    }
    public Servidor(){
        Thread serverThread = new Thread(() -> {
            try {
                // Crear un ServerSocket que escuche en el puerto 12345
                ServerSocket serverSocket = new ServerSocket(49356);

                System.out.println("Esperando conexiones entrantes...");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Conexión aceptada desde: " + clientSocket.getInetAddress());

                    // Crear un nuevo hilo para manejar la conexión del cliente
                    Thread clientThread = new Thread(new ClientHandler(clientSocket));
                    clientThread.start();
                }
                // Esperar y aceptar una conexión entrante

                // Cerrar el ServerSocket
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Iniciar el hilo del servidor
        serverThread.start();

        // Continuar ejecutando otras líneas de código en el hilo principal
        System.out.println("El servidor sigue ejecutando otras tareas mientras espera conexiones...");

        // Por ejemplo, puedes agregar más código aquí que se ejecutará mientras el servidor espera conexiones

        // También puedes esperar a que el hilo del servidor termine si es necesario
        /*try {

            serverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
     
    }
}
