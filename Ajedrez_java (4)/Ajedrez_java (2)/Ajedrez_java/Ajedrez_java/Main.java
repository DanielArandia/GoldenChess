import controlador.Controlador;
import sockets.Cliente;
import sockets.Servidor;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        
        Servidor servidor = new Servidor();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista);
    }
}
