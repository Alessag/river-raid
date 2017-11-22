package Probando;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    int hp;
    //JLabel img;
    /**
     * Constructor de la clase Enemigo
     * Inicializa todos sus atributos principales
     * @param posx Posicion en equis en la que comienza
     * @param posy Posicion en y donde comienza
     */
    public Enemigo(int posx, int posy) {
        
        ALTO = 50;
        ANCHO = 50;
        this.posx = posx;
        this.posy = posy; 
        direccion = true; 
        hp = 2;
       // this.setLayout(null);
        this.setBackground(new Color(236, 64, 122));
        this.setBounds(posx, posy, ANCHO, ALTO);
      //  ImageIcon im = new ImageIcon(this.getClass().getResource("/Imagenes/enemigo_1.png"));
       // img = new JLabel(im);
       // img.setBounds(0, 0, 50, 50);
       // this.add(img);
        this.setVisible(true);

    }

    /**
     *
     * Metodo para mover  a un enemigo en la pantalla
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
    
    /**
     * Metodo getter
     * @return Pos en equis del enemigo
     */
    public int getPosx() {
        return posx;
    }
    /**
     * Metodo getter
     * @return Pos en y del enemigo
     */
    public int getPosy() {
        return posy;
    }
    /**
     * Metodo setter
     * @param posx Nuevo valor de la pos en equis
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }
    /**
     * Metodo setter
     * @param posy Nuevo valor para la pox en y
     */
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
    /**
     * Metodo para subir al tope a los enemigos una vez hayan llegado al final
     */
    public void subir(){
        //posx = aleax;
        posx = aleax /*(int) (Math.random() * maxx) +1*/;
        //System.out.println("ALEA EN QUE EN SUBIR ENEMIGO: " +posx);
        posy = aleay /*(int) (Math.random() * 4) +1*/;
        this.setBounds(posx, posy, ANCHO, ALTO);
    }
        /**
         * Metodo que le resta una vida al enemigo cuando colisiona con una bala del avion
         * @return Un valor verdadero para cuando es destruido el enemigo, de lo contrario verdadero
         * 
         */
    public Boolean quitarHP(){
        hp--;
        if(hp<=0){
            morir();
            return true;
        }
        return false;
//            morir();
    }
    /**
     * Metodo que hace invisible al objeto cuando es destruido y lo vuelve a inicializar para llevarlo al tope
     */
    public void morir(){
        hp=3;
        this.setVisible(false);
    }

}
