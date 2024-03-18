package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Servidor servidor;

    public ClientHandler(Socket socket, Servidor servidor) {
        this.clientSocket = socket;
        this.servidor = servidor;
        try {
            this.out = new ObjectOutputStream(socket.getOutputStream());
            this.in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Esperar un nuevo mensaje del cliente
                Object obj = in.readObject();
                if (obj instanceof String) {
                    String mensajeCliente = (String) obj;
                    System.out.println("Mensaje recibido del cliente: " + mensajeCliente);
                    
                    // Aquí puedes procesar el mensaje recibido según tus necesidades

                    // Ejemplo de envío de un mensaje de vuelta al cliente
                    servidor.reenviarMensaje(mensajeCliente, this);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Cerrar conexiones al finalizar
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    public void enviarMensajeAlCliente(String mensaje){

        try {           
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
