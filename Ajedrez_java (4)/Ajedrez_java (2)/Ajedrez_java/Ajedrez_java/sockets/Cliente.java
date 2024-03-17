package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

ObjectOutputStream out;
ObjectInputStream in;
    public Cliente(){
        try {
            Socket socket = new Socket("localhost", 49356);
            Thread streamThread = new Thread(() -> {
                try {
                    out = new ObjectOutputStream(socket.getOutputStream());
                    in = new ObjectInputStream(socket.getInputStream());
                    recibirMensajesDelServidor();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            streamThread.start();
            // Esperar a que los flujos se inicialicen completamente
            System.out.println("hola");

            // Lógica de comunicación con el servidor
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void enviarMensajeAlServidor(String mensaje){
        try {
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }
    public void recibirMensajesDelServidor() {
        try {
            while (true) {
                System.out.println("El mensaje es recibido al cliente");
                // Recibir el mensaje enviado por el servidor
                Object mensaje = in.readObject();
                if (mensaje instanceof String) {
                    String mensajeString = (String) mensaje;
                    // Imprimir el mensaje recibido en la consola del cliente
                    System.out.println("Mensaje recibido del servidor: " + mensajeString);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
