package Probando;
//@author Alessandra

import static Probando.RiverRaid.ANCHO;
import static Probando.RiverRaid.ALTO;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cuadradito extends JPanel {

    static int anchoC = 50;
    static int altoC = 50;
    private  int gasolina = 200; 
    public static int maxGasolina = 200;
    Vidas vidas;

    public Cuadradito() {
        super();
        this.setBounds(ANCHO / 2, ALTO / 2, anchoC, altoC);
        this.setBackground(new Color(24, 255, 255));
        this.setVisible(true);
    }

    public void move(int dir) {
        int posx = getX();
        int posy = getY();

        switch (dir) {
            case KeyEvent.VK_UP:
                if (posy > 0) {
                    posy -= 10;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (posy < ALTO - altoC) {
                    posy += 5;
                    //System.out.println("posicion en y pa abajo : " +posy);
                }
                break;
            case KeyEvent.VK_LEFT:
                if (posx > 0) {
                    posx -= 10;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (posx < ANCHO - anchoC) {
                    posx += 10;
                }
                break;
            default:
                System.out.println("Tecla incorrecta presionada");
                break;
        }
        this.setLocation(posx, posy);

    }

    public int getGasolina() {
        return gasolina;
    }

    public void setGasolina(int gasolina) {
        this.gasolina = gasolina;
    }
    
    
    public void TanqueandoGasolina(int g){
        //System.out.println("Nivel de gasolina inicial: "+gasolina);
        if(g > 0){
            if(gasolina < maxGasolina){
             gasolina+=5;
            System.out.println("Aumentando: " +gasolina);
            }
           
        }
        if(g < 0){
            if(gasolina >0){
                gasolina-=1;
                System.out.println("Disminuyendo: " +gasolina);
            }
                
        }
        if(gasolina == 0){
           // gasolina =0; 
       
            System.out.println("PERDISTE");
            
        }   
        
    }
    

}