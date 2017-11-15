package Probando;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/*@author alessandra.girardi*/
public class Enemigo extends JPanel {

    int ANCHO;
    int ALTO; 
    int posx;
    int posy;
    boolean direccion; 

    public Enemigo(int posx, int posy) {
        
        ALTO = 50;
        ANCHO = 50;
        this.posx = posx;
        this.posy = posy; 
        direccion = true; 
        
        this.setBackground(new Color(236, 64, 122));
        this.setBounds(posx, posy, ANCHO, ALTO);
        this.setVisible(true);

    }

    public void MoveAlone() {
 
        if(posx > RiverRaid.ANCHO-ANCHO){
            direccion = false; 
        }
        if (posx < 0) {
            direccion = true; 
        }
        if(direccion){
            setPosx(posx+=10);
        }else{
            setPosx(posx-=10);
        }
        setBounds(posx, posy, ANCHO, ALTO);
        
    }
    
    // Gett 
    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
    
    //Sett
    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    
    /**
     * Metodo para que cada enemigo baje solo y se actualice en la RiverRaid 
     */
    public void bajar(){
        this.posy+=1;
        this.setBounds(posx, posy, ANCHO,ALTO);
    }

}
