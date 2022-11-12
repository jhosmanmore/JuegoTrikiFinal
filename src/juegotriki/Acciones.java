/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotriki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author JhosmanM
 */
public class Acciones {
    private Ventana vista;
    private Modelo model;
    private JLabel[][] posiciones;
    public Acciones(Ventana vista, Modelo model){
        this.vista = vista;
        this.model = model;
        posiciones = vista.getPosiciones();
        agregarListeners();
        crearJugadores();
    }
 
    private void agregarListeners() {
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                agregarEventoMouse(i,j);
            }
        }
        JButton reiniciarJuego = vista.getBotonReiniciar();
        reiniciarJuego.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               model.reiniciarJuego(posiciones);
           }
        });
        JButton salirJuego = vista.getBotonSalir();
        salirJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        JButton reiniciarContador = vista.getReiniciarContador();
        reiniciarContador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.reiniciarContador();
            }
        });
    }

    private void agregarEventoMouse(int i, int j) {
        JLabel posicionActual = posiciones[i][j];
        posicionActual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.marcarCasilla(i,j,posiciones);
            }
        });
        JLabel t1 = vista.getTurnoJugador();
        JLabel t2 = vista.getTurnoJugador1();
        posicionActual.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                model.turnoActual(t1,t2);
            }
        });
    }
    
    private void crearJugadores() {
        JLabel j1 = vista.getContador1();
        JLabel j2 = vista.getContador2();
        model.setJugadores(j1,j2);
    }
    
}