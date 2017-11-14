package Probando;
//@author Alessandra

import static Probando.RiverRaid.ANCHO;
import static Probando.RiverRaid.ALTO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cuadradito extends JPanel{
    
    static int anchoC = 50;
    static int altoC = 50;
    
    public Cuadradito() {
        super();
        this.setBounds(ANCHO/2, ALTO/2, anchoC, altoC);
        this.setBackground(new Color(24,255,255));
        this.setVisible(true);
    }
    
    public void move(int dir){
        int posx=getX(); 
        int posy=getY();
        
        switch(dir){
            case KeyEvent.VK_UP:
                if(posy>0)
                posy-=10;
                break;
            case KeyEvent.VK_DOWN:
                if(posy<ALTO-altoC){
                posy+=5;
                //System.out.println("posicion en y pa abajo : " +posy);
                }
                break;
            case KeyEvent.VK_LEFT:
                if(posx>0)
               // System.out.println("posicion en x : " +posx);
                posx-=10;
                break;
            case KeyEvent.VK_RIGHT:
                if(posx<ANCHO-anchoC)
                    //System.out.println("posicion en x : " +posx);
                    posx+=10;
                    break;
            default:
                System.out.println("Tecla incorrecta presionada");
                break;
        }
        this.setLocation(posx, posy);
        
    }
    
    
}
