
package Probando;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

/**
 *
 * @author alessandra.girardi
 * Clase que representa las vidas del avion
 */
public class Vidas extends JPanel{
    /**
     * Alto del panel de las vidas
     */
    private int ALTO = 50;
    /**
     * Ancho del panel de las vidas
     */
    private int ANCHO = 200;
    /**
     * Vector con la representacion grafica de las vidas
     */
    private JPanel vidas[];
    /**
     * Contador de las vidas restantes
     */
    private int cont = 3; 
    //ImageIcon vida; 
    /**
     * Constructor de la clase, inicializa los valores de los atributos
     */
    public Vidas() {
       // this.setBackground(Color.ORANGE);
        this.setBounds(0, 600, ANCHO, ALTO);
        this.setLayout(new GridLayout(1, 3));
       // vida = new ImageIcon("/Imagenes/vida_1.png");
        vidas = new JPanel[3];
        
            
        for (int i = 0; i < vidas.length; i++) {
             vidas[i] = new JPanel();
        }
         vidas[0].setBackground(Color.BLACK);
         vidas[1].setBackground(Color.pink);
         vidas[2].setBackground(Color.blue);
         for (int i = 0; i < vidas.length; i++) {
               this.add(vidas[i]);
        }
              
        this.setVisible(true);
    }
    /**
     * Metodo que le se ejecuta cuando se le quita una vida al avion
     */
    public void quitarVida(){
        cont-=1;
        if(cont < 3 && cont >=0){
            vidas[cont].setBackground(Color.white);
        }
    }
    /**
     * Metodo getter
     * @return La cantidad de vidas restantes
     */
    public int getCont() {
        return cont;
    }
/*
    @Override
    public void paint(Graphics g) {
        
        g.drawImage(vida.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    */
    

    
    
    
    
    
    
}
