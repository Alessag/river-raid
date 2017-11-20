<<<<<<< HEAD
package Probando;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author alessandra.girardi
 */
public class Disparos extends JPanel{
    
    static int ALTO = 9;  
    static int ANCHO = 5; 
    private Rectangle area; 

    
    /**
     * Constructor de la clase Disparos, donde se posiciona la bala 
     */
    public Disparos(int balaX, int balaY) {
        
        this.setBounds(balaX, balaY, ANCHO, ALTO);
        this.setBackground(Color.BLACK);
        
        area = new Rectangle(balaX, balaY, ANCHO, ALTO);
        
        this.setVisible(true);
    }
    
    
    /**
     * Metodo para que suban las balas, actualizando la posicion de ellas
     */
    public void mover(){
        area.setBounds(getX(), getY()-10, ANCHO, ALTO);
        this.setBounds(getX(), getY()-10, ANCHO, ALTO);
    }
    
}
=======
package Probando;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author alessandra.girardi
 */
public class Disparos extends JPanel{
    
    static int ALTO = 9;  
    static int ANCHO = 5; 
    private Rectangle area; 

    
    public Disparos(int balaX, int balaY) {
        
        this.setBounds(balaX, balaY, ANCHO, ALTO);
        this.setBackground(Color.BLACK);
        
        area = new Rectangle(balaX, balaY, ANCHO, ALTO);
        
        this.setVisible(true);
    }
    /**
     * Este ews un metodo pro :3
     */
    public void mover(){
        area.setBounds(getX(), getY()-10, ANCHO, ALTO);
        this.setBounds(getX(), getY()-10, ANCHO, ALTO);
    }
    
}
>>>>>>> 1da305c70804e0813f6ef2053fbeb701e65eec9b
