package Probando;

import java.awt.Color;
import javax.swing.JPanel;

/*@author alessandra.girardi*/
public class Enemigo extends JPanel {

    int ANCHO;
    int ALTO; 
    int posx;
    int posy;
    int maxx = Probando.RiverRaid.ANCHO; // Posición aleatorea en x 
    int maxy = Probando.RiverRaid.ALTO; // Posición aleatorea en y 
    int aleax = (int) (Math.random() * maxx) +1; 
    int aleay = (int) (Math.random() * 4) +1; 
    boolean direccion; 
    
    /**
     *
     * Constructor de la clase Enemigo
     */
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

    /**
     *
     * Metodo para mover  a un enemigo
     */
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
     * Metodo para que cada enemigo baje solo y se actualice en la pantalla RiverRaid 
     */
    public void bajar(){
        this.posy+=15;
        this.setBounds(posx, posy, ANCHO,ALTO);
    }
    
    public void subir(){
        posx = aleax;
        System.out.println("ALEA EN QUE EN SUBIR ENEMIGO: " +posx);
        posy = aleay;
        this.setBounds(posx, posy, ANCHO, ALTO);
    }

}
