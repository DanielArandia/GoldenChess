package vista;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista extends JFrame {

    JPanel panel;
    ImageIcon iconoPeonN;
    ImageIcon iconoAlfilN;
    ImageIcon iconoTorreN;
    ImageIcon iconoDamaN;
    ImageIcon iconoReyN;
    ImageIcon iconoCaballoN;
    ImageIcon iconoPeon;
    ImageIcon iconoAlfil;
    ImageIcon iconoTorre;
    ImageIcon iconoDama;
    ImageIcon iconoRey;
    ImageIcon iconoCaballo;
    //ArrayList<JButton> botones;
    public JButton[] botones;
    CrearBotones crearBotones;

    public Vista(){
        super("Ajedrez");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        crearIcons();
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        crearBotones = new CrearBotones(this);
        crear_botones();
        //moverFicha("7", "12");
    }

    public void crear_botones(){

        crearBotones.crear_botones();
    }

        public static boolean isNull(Object objeto) {
            return objeto == null;
        }
        public void crearIcons(){

            iconoPeonN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Ficha PeonNegra.png");
            iconoAlfilN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\AlfilNegro.png");
            iconoTorreN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\TorreNegra.png");
            iconoDamaN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\ReyNegro.png");
            iconoReyN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\ReinaNegra.png");
            iconoCaballoN = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\CaballoNegro.png");
            iconoPeon = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Ficha Peon.png");
            iconoAlfil = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Alfil.png");
            iconoTorre = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Torre.png");
            iconoDama = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Reina.png");
            iconoRey = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Rey.png");
            iconoCaballo = new ImageIcon("Ajedrez_java (4)\\Ajedrez_java (2)\\Ajedrez_java\\Ajedrez_java\\Imagenes\\Caballo.png");
        }
        public void posicionarFichas(){
        }
        public void moverFicha(String casillaOrigen, String casillaDestino){

            ImageIcon icono = null;

            for (int i = 0; i < botones.length; i++) {
                if(botones[i].getName().equals(casillaOrigen)){
                    icono = (ImageIcon) botones[i].getIcon();
                    botones[i].setIcon(null);
                }
            }
            for (int i = 0; i < botones.length; i++) {
                if (botones[i].getName().equals(casillaDestino)){
                   botones[i].setIcon(icono);
                }
            }

        }

        public JButton[] getListaDeBotones() {
            return botones;
        }

    }


