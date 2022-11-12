/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotriki;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author JhosmanM
 */
public class Modelo {
    private String turno;
    private boolean fin;
    private boolean empate;
    private JLabel cont1;
    private JLabel cont2;
    private final String[][] tablero;
    private int numTurnos;
    private int contador1;
    private int contador2;
    private JLabel turno1;
    private JLabel turno2;
    
    public Modelo(){
        turno = "X";
        fin = false;
        empate = false;
        tablero = new String[3][3];
        numTurnos = 0;
        contador1 = 0;
        contador2 = 0;
    }
    
    public void marcarCasilla(int i, int j, JLabel[][] posiciones){
        if (!fin) {
            if (tablero[i][j] == null) {
                tablero[i][j] = turno;
                posiciones[i][j].setText(turno);
                numTurnos++;
                verificarEstado();
                if (!fin) {
                    if (turno.equals("X")) {
                        turno = "O";
                    } else {
                        turno = "X";
                    }
                }else{
                    terminarJuego();
                }
            }
        }
    }
    
    private void verificarEstado() {
        verificarFilas();
        if (!fin) {
            verificarColumnas();
            if (!fin) {
                verificarDiagonalP();
                if (!fin) {
                    verificarDiagonalS();
                    if (!fin) {
                        if (numTurnos == 9) {
                            empate = true;
                            fin = true;
                        }
                    }
                }
            }
        }
    }
    
    private void verificarFilas() {
        for (int i = 0; i < 3 && !fin; i++) {
            boolean ganador = true;
            for (int j = 0; j < 3 && ganador; j++) {
                if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                    ganador = false;
                }
            }
            if (ganador) {
                fin = true;
            }
        }
    }
    
    private void verificarColumnas() {
        for (int j = 0; j < 3 && !fin; j++) {
            boolean ganador = true;
            for (int i = 0; i < 3 && ganador; i++) {
                if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                    ganador = false;
                }
            }
            if (ganador) {
                fin = true;
            }
        }
    }

    private void verificarDiagonalP() {

        boolean ganador = true;
        for (int i = 0; i < 3 && ganador; i++) {
            if (tablero[i][i] == null || !tablero[i][i].equals(turno)) {
                ganador = false;
            }
        }
        if (ganador) {
            fin = true;
        }
    }
    
    private void verificarDiagonalS() {

        boolean ganador = true;
        int j = 2;
        for (int i = 0; i < 3 && ganador; i++, j--) {
            if (tablero[i][j] == null || !tablero[i][j].equals(turno)) {
                ganador = false;
            }
        }
        if (ganador) {
            fin = true;
        }
    }
    
    private void terminarJuego() {
        if(empate){
            JOptionPane.showMessageDialog(null, "Empate");
        }else{
            if(turno.equals("X")){
                contador1++;
                cont1.setText(String.valueOf(contador1));
                JOptionPane.showMessageDialog(null, "Victoria del jugador 1");  
            }else{
                contador2++;
                cont2.setText(String.valueOf(contador2));
                JOptionPane.showMessageDialog(null, "Victoria del jugador 2");
            }
        }
    }

    void reiniciarJuego(JLabel[][] posiciones) {
        turno = "X";
        fin = false;
        empate = false;
        numTurnos = 0;
        for (int i = 0; i < 3; i++) {        
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = null;
                posiciones[i][j].setText("");
                turno1.setVisible(true);
                turno2.setVisible(false);
            }
        }
    }

    void setJugadores(JLabel j1, JLabel j2) {
        cont1 = j1;
        cont2 = j2;
    }

    void turnoActual(JLabel t1, JLabel t2) {
        if(numTurnos%2 == 0){
            t1.setVisible(true);
            t2.setVisible(false);
            turno1 = t1;
            turno2 = t2;
        }else{
            t1.setVisible(false);
            t2.setVisible(true);
            turno1 = t1;
            turno2 = t2;
        }
    }

    void reiniciarContador() {
        contador1 = 0;
        contador2 = 0;
        cont1.setText(String.valueOf(contador1));
        cont2.setText(String.valueOf(contador2));
    }

}
