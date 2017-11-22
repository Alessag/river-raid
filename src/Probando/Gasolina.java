
package Probando;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author alessandra.girardi
 */
public class Gasolina extends JPanel{
        
    private  int ALTURA = 50;
    private int ANCHURA = 100;
    private int anchoBarrita = 100; 
    JPanel barritaDeGasolina;
    
    /**
     * Constructor de la clase Gasoilna
     * Inicializa todos sus atributos
     */
    
    public Gasolina() {
        this.setBounds(450, 600, ANCHURA,ALTURA);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
       
        barritaDeGasolina = new JPanel();
        barritaDeGasolina.setBounds(0, 0, anchoBarrita, ALTURA);
        barritaDeGasolina.setBackground(Color.red);
        barritaDeGasolina.setVisible(true);
        this.add(barritaDeGasolina);
        this.setVisible(true);
    }
    /**
     * Metodo getter
     * @return Altura del panel de la gasolina
     */
    public int getALTURA() {
        return ALTURA;
    }
    /**
     * Metodo setter
     * @param ALTURA Valor para poner en altura 
     */
    public void setALTURA(int ALTURA) {
        this.ALTURA = ALTURA;
    }
    /**
     * Metodo getter
     * @return El valor de la anchura
     */
    public int getANCHURA() {
        return ANCHURA;
    }
    /**
     * Metodo setter
     * @param ANCHURA El nuevo valor de la anchura
     */
    public void setANCHURA(int ANCHURA) {
        this.ANCHURA = ANCHURA;
    }
    /**
     * Metodo setter
     * @param ancho el nuevo valor del ancho de la gasolina
     */
    public void setGasolinaNivel(int ancho){
        barritaDeGasolina.setBounds(0, 0, ancho/2, ALTURA);
    }
    
    
    
}
