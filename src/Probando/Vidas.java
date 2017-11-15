package Probando;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author alessandra.girardi
 */
public class Vidas extends JPanel{
    
    private int ALTO = 50;
    private int ANCHO = 200;
    private JPanel vidas[];
    private int cont = 3; 

    public Vidas() {
        this.setBackground(Color.ORANGE);
        this.setBounds(0, 0, ANCHO, ALTO);
        this.setLayout(new GridLayout(1, 3));
        
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
    
    public void quitarVida(){
        cont-=1;
        if(cont < 3){
            vidas[cont].setBackground(Color.white);
        }
    }
    
    
    
}
