
package Probando;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alessandra
 */
public class Menu extends JPanel {

    //JLabel panelDelFondo; 
    JPanel panelDeFondo;
    JPanel iniciar;
    JPanel jugar;
    JPanel instrucciones;
    JPanel top10;
    JPanel creditos;
    JPanel salir;

    ImageIcon backgroundMenu;

    public Menu() {
        
        this.setPreferredSize(new Dimension(RiverRaid.ANCHO, RiverRaid.ALTO));
        backgroundMenu = new ImageIcon(this.getClass().getResource("/Imagenes/fondo_menu.jpg"));
        this.setLayout(null);
        
        iniciar = new JPanel();
        jugar = new JPanel();
        instrucciones = new JPanel();
        top10 = new JPanel();
        creditos = new JPanel();
        salir = new JPanel();
        
        iniciar.setBounds(200, 100, 200, 50);
        iniciar.setBackground(Color.green);
        
        jugar.setBounds(200, 200, 200, 50);
        jugar.setBackground(Color.GRAY);
        
        instrucciones.setBounds(200, 300, 200, 50);
        instrucciones.setBackground(Color.YELLOW);
        
        top10.setBounds(200, 400, 200, 50);
        top10.setBackground(Color.WHITE);
        
        creditos.setBounds(200, 500, 200, 50);
        creditos.setBackground(Color.magenta);
        
        salir.setBounds(200, 600, 200, 50);
        salir.setBackground(Color.BLACK);
        
        this.add(iniciar);
        this.add(jugar);
        this.add(instrucciones);
        this.add(top10);
        this.add(creditos);
        this.add(salir);
    
    
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        
        g.drawString("hola", 50, 50);
        g.drawImage(backgroundMenu.getImage(),0,0, getWidth(), getHeight(), this);
    }

}
