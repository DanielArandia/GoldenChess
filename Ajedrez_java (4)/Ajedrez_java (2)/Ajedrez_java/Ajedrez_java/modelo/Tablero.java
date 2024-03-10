package modelo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Tablero {


    public void dibujarTablero(JPanel panel, Graphics g){

        for(int fila = 0; fila < 8; fila++){
            for(int columna = 0; columna < 8; columna ++){
                
                Color colorCasilla = (fila + columna) % 2 == 0 ? Color.WHITE : Color.BLACK;
                dibujarCasilla(fila, columna, colorCasilla, g, panel);
            }
        }
    }

    public void dibujarCasilla(int fila, int columna, Color color, Graphics g, JPanel panel){
        int ladoCasilla = panel.getWidth() / 8; 
        g.setColor(color);
        g.fillRect(columna * ladoCasilla, fila * ladoCasilla, ladoCasilla, ladoCasilla);
    }
    
}
