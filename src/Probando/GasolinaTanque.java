package Probando;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants;

/**
 *
 * @author tiziana.amicarella
 */
public class GasolinaTanque extends JPanel {

    int ANCHO = 50;
    int ALTO = 70;
    int posx;
    int posy;
    //Random r = new Random();
    int maxx = Probando.RiverRaid.ANCHO; // Posición aleatorea en x 
    int aleax = (int) (Math.random() * maxx) +1; 

    public GasolinaTanque(int x, int y) {
        this.posx = x;
        this.posy = y;
        this.setBounds(posx, posy, ANCHO, ALTO);
        this.setBackground(Color.blue);
        this.setVisible(true);
    }

    public void bajar() {

        this.posy += 30;
       /* if (posy > RiverRaid.ALTO) {
            this.posx = 
            this.posy = 0;
        }*/
        this.setBounds(posx, posy, ANCHO, ALTO);
    }

    public void subir() {
        Random r = new Random();
        posx= r.nextInt(RiverRaid.ANCHO);
        posy = 0;
        System.out.println("NUMERO ALEATOREO EN X : " +posx);
        this.setBounds(posx, posy, ANCHO, ALTO);

    }

}
