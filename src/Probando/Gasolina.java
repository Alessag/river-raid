package Probando;

import java.awt.Color;
import javax.swing.JPanel;
import static Probando.RiverRaid.ALTO;
import static Probando.RiverRaid.ANCHO;
import java.awt.BorderLayout;
import javax.swing.JLabel;

/**
 *
 * @author alessandra.girardi
 */
public class Gasolina extends JPanel{
        
    private  int ALTURA = 50;
    private int ANCHURA = 100;
    private int anchoBarrita = 100; 
    JPanel barritaDeGasolina;
    
    public Gasolina() {
        this.setBounds(0, 500-ALTURA*2, ANCHURA,ALTURA);
        this.setBackground(Color.GRAY);
        this.setLayout(null);
       
        barritaDeGasolina = new JPanel();
        barritaDeGasolina.setBounds(0, 0, anchoBarrita, ALTURA);
        barritaDeGasolina.setBackground(Color.red);
        barritaDeGasolina.setVisible(true);
        this.add(barritaDeGasolina);
        this.setVisible(true);
    }

    public int getALTURA() {
        return ALTURA;
    }

    public void setALTURA(int ALTURA) {
        this.ALTURA = ALTURA;
    }

    public int getANCHURA() {
        return ANCHURA;
    }

    public void setANCHURA(int ANCHURA) {
        this.ANCHURA = ANCHURA;
    }
    public void setGasolinaNivel(int ancho){
        barritaDeGasolina.setBounds(0, 0, ancho/2, ALTURA);
    }
    
    
    
}
