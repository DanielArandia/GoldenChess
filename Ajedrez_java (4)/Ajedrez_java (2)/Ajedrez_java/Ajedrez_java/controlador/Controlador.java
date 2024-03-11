package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Verificar_movimiento;
import vista.Vista;

public class Controlador implements ActionListener {

Vista vista;
Verificar_movimiento verificar;

    public Controlador(Vista vista){
        this.vista = vista;
        verificar = new Verificar_movimiento(this);

        JButton[] botones = vista.getListaDeBotones();
        for (JButton boton : botones) {
            boton.addActionListener(this);
        }

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton botonPresionado = (JButton) e.getSource();

        System.out.println(botonPresionado.getName());

        verificar.verificarMovimientos(botonPresionado.getName());
        
    }

    public void cambiarVista(String casillaOrigen, String casillaDestino){
        vista.moverFicha(casillaOrigen, casillaDestino);
    }
  

}
