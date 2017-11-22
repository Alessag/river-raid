package Probando;
//@author Alessandra

import static Probando.RiverRaid.ANCHO;
import static Probando.RiverRaid.ALTO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class PersonajePrincipal extends JPanel {
    /**
     * Ancho del panel del jugador
     */
    static int anchoC = 50;
    /**
     * Alto del panel del jugador
     */
    static int altoC = 50;
    /**
     * Gasolina del jugador
     */
    private int gasolina = 200;
    /**
     * Maxima cantidad de gasolina que el jugador puede tener
     */
    public static int maxGasolina = 200;

    /**
     * Constructor de la clase PersonajePrincipal donde se inicializan los valores de la clase
     */
    public PersonajePrincipal() {
        super();
        this.setBounds(ANCHO / 2, ALTO / 2, anchoC, altoC);
        this.setBackground(new Color(24, 255, 255));
        this.setVisible(true);
    }

    /**
     * Metodo para mover al personaje principal
     *
     * @param dir dirección en la que se va a mover
     */
    public void move(int dir) {
        int posx = getX();
        int posy = getY();

        switch (dir) {
           /* case KeyEvent.VK_UP:
                if (posy > 0) {
                    posy -= 25;
                }
                break;*/
            /*case KeyEvent.VK_DOWN:
                if (posy < ALTO - altoC) {
                    posy += 25;
                    //System.out.println("posicion en y pa abajo : " +posy);
                }
                break;*/
            case KeyEvent.VK_LEFT:
                if (posx > 0) {
                    posx -= 25;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (posx < ANCHO - anchoC) {
                    posx += 25;
                }
                break;
            default:
                System.out.println("Tecla incorrecta presionada");
                break;
        }
        this.setLocation(posx, posy);

    }
    /**
     * Metodo getter
     * @return Gasolina del jugador
     */
    public int getGasolina() {
        return gasolina;
    }
    /**
     * Metodo setter
     * @param Valor a poner en la gasolina del jugador
     */
    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }

    /**
     * Metodo para saber si se esta llenando el tanque de la gasolina o si se está
     * vaciando
     *
     * @param g Indicador de si se encuentra en contacto con los tanques de gasolina  o no
     */
    public void TanqueandoGasolina(int g) {
        //System.out.println("Nivel de gasolina inicial: "+gasolina);
        if (g > 0) {
            if (gasolina < maxGasolina) {
                gasolina += 5;
                //System.out.println("Aumentando: " + gasolina);
            }

        }
        if (g < 0) {
            if (gasolina > 0) {
                gasolina -= 1;
                //System.out.println("Disminuyendo: " + gasolina);
            }

        }
        if (gasolina == 0) {
            System.out.println("PERDISTE");

        }

    }

}
