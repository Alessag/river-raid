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
