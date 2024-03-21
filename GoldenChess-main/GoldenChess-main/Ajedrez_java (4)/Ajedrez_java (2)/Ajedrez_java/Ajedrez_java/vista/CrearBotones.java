package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class CrearBotones {
    Vista vista;
    public CrearBotones (Vista vista){
    this.vista = vista;
    }
    public void crear_botones(){

        boolean par = true;
        vista.botones = new JButton[64];
        int contador = 0;
        //botones = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {

            for (int j = 1; j <= 8; j++) {

                JButton button = new JButton("Botón " + (i * j));
                button.setName("" + (contador));
                button.setText("");
                button.setPreferredSize(new Dimension(80, 80));
                vista.botones[contador] = button;
                contador++;
                vista.panel.add(button);

                if (par == true) {
                    if((i == 1) && (j == 1)){
                        button.setIcon(vista.iconoTorreN);
                    }
                    if((i == 1)&&(j==7)){
                        button.setIcon(vista.iconoCaballoN);
                    }
                    if((i == 1)&&(j==3)){
                        button.setIcon(vista.iconoAlfilN);
                    }
                    if((i == 1)&&(j==5)){
                        button.setIcon(vista.iconoDamaN);
                    }
                    if(i == 2){
                        button.setIcon(vista.iconoPeonN);
                    }
                    if((i == 8)&&(j==8)){
                        button.setIcon(vista.iconoTorre);
                    }
                    if((i == 8)&&(j==2)){
                        button.setIcon(vista.iconoCaballo);
                    }
                    if((i == 8)&&(j==6)){
                        button.setIcon(vista.iconoAlfil);
                    }
                    if((i == 8)&&(j==4)){
                        button.setIcon(vista.iconoDama);
                    }
                    if(i == 7){
                        button.setIcon(vista.iconoPeon);
                    }
                    //botones.add(button);
                    button.setBackground(Color.WHITE);
                    par = false;
                } else {

                    if(i == 7){
                        button.setIcon(vista.iconoPeon);
                    }

                    if((i == 8)&&(j==5)){
                        button.setIcon(vista.iconoRey);
                    }

                    if((i == 8)&&(j==3)){
                        button.setIcon(vista.iconoAlfil);
                    }

                    if((i == 8)&&(j==7)){
                        button.setIcon(vista.iconoCaballo);
                    }

                    if((i == 8)&&(j==1)){
                        button.setIcon(vista.iconoTorre);
                    }
                    if((i == 1)&&(j==2)){
                        button.setIcon(vista.iconoCaballoN);
                    }
                    if((i == 1) && (j == 8)){
                        button.setIcon(vista.iconoTorreN);
                    }
                    if((i == 1)&&(j==6)){
                        button.setIcon(vista.iconoAlfilN);
                    }
                    if((i == 1)&&(j==4)){
                        button.setIcon(vista.iconoReyN);
                    }
                    if(i == 2){
                        button.setIcon(vista.iconoPeonN);
                    }
                    //botones.add(button);
                    button.setBackground(Color.BLACK);
                    par = true;
                }
            }

            if(par == true){
                par = false;
            }
            else{
                par = true;
            }
        }
        vista.getContentPane().add(vista.panel);
        vista.pack();
        vista.setVisible(true);
        }
}
