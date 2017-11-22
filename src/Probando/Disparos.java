
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
    private boolean valida=true;
    /**
     * Metodo getter
     * @return True si el disparo es valido y no ha colisionado con ningun otro obstaculo hasta el momento
     */
    public boolean isValida() {
        return valida;
    }
    /**
     * Metodo setter
     * @param valida El nuevo valor de Valida  
     */
    public void setValida(boolean valida) {
        this.valida = valida;
    }
    
    /**
     * Constructor de la clase disparo
     * Inicializa todos los atributos principales de la clase
     * @param balaX Posicion en equis de la bala
     * @param balaY Posicion en Y de la bala 
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
