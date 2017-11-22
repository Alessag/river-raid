/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Probando;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Alessandra
 */
public class Puntos extends JLabel{
    /**
     * Puntos del jugador
     */
    private int puntos=0;
    /**
     * Metodoe getter
     * @return Retorna los puntos del jugador
     */
    public int getPuntos() {
        return puntos;
    }
    /**
     * Metodo setter
     * @param puntos setea los puntos del jugador 
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    /**
     * Constructor que inicializa los valores de los puntos del jugador
     */
    public Puntos() {
        super("0");
        setFont(new Font(getFont().getName(), Font.PLAIN, 25));
        setBounds(530, 70, 150, 50);
    }
    /**
     * Metodo que resta puntos al jugador cuando destruye un tanque de gasolina
     */
    public void restarPuntos(){
        if(puntos>0)
            puntos-=10;
        actualizar();
    }
    /**
     * Metodo que le suma puntos al jugador al destruir un enemigo
     */
    public void sumarPuntos(){
        puntos+=30;
        actualizar();
    }
    /**
     * Metodo que actualiza la etiqueta con el puntaje actual
     */
    public void actualizar(){
        this.setText(String.valueOf(puntos));
    }
}
