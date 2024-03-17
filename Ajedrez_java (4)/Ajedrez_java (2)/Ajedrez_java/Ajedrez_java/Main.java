import controlador.Controlador;
import sockets.Cliente;
import sockets.Servidor;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        Cliente cliente = new Cliente();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, cliente);
    }
}
