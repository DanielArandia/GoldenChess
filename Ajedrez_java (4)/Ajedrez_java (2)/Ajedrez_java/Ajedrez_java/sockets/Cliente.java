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
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

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
}
