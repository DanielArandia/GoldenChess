package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    private List<ClientHandler> clientes = new ArrayList<>();

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
                    ClientHandler cliente = new ClientHandler(clientSocket, this);
                    Thread clientThread = new Thread(cliente);

                    clientes.add(cliente);
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
    public void reenviarMensaje(String mensaje, ClientHandler clienteOrigen) {

        for (ClientHandler cliente : clientes) {
            if (cliente != clienteOrigen) {
                cliente.enviarMensajeAlCliente(mensaje);
            }
        }
    }
}
