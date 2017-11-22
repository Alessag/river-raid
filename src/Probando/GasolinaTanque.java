package Probando;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
    Image tanquesito;
    /**
     * Constructor que inicializa los valores que tendra un tanque de gasolina
     * @param x Pos en x donde estara
     * @param y Pos en y donde estara
     */
    public GasolinaTanque(int x, int y) {
        tanquesito = new ImageIcon(this.getClass().getResource("/Imagenes/vida_0.png")).getImage();
        this.posx = x;
        this.posy = y;
        
        this.setBounds(posx, posy, ANCHO, ALTO);
        this.setBackground(Color.blue);
        this.setVisible(true);
    }
    /**
     * Metodo que hace bajar el tanque en la pantalla
     */
    public void bajar() {

        this.posy += 20;
       /* if (posy > RiverRaid.ALTO) {
            this.posx = 
            this.posy = 0;
        }*/
        this.setBounds(posx, posy, ANCHO, ALTO);
    }
    /**
     * Metodo que hace subir el tanque al tope de la pantalla una vez ha llegado al final
     */
    public void subir() {
        Random r = new Random();
        posx= r.nextInt(RiverRaid.ANCHO);
        posy = 0;
        System.out.println("NUMERO ALEATOREO EN X : " +posx);
        this.setBounds(posx, posy, ANCHO, ALTO);

    }

    @Override
    public void paintComponents(Graphics g) {
        g.drawImage(tanquesito, posx, posy, 50,50, this);
        g.setColor(Color.red);
        g.drawRect(posx, posy, 50, 50);
        
    }
    
    

}
