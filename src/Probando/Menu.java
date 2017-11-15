/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Probando;

import javax.swing.JFrame;
import static Probando.RiverRaid.ALTO;
import static Probando.RiverRaid.ANCHO;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alessandra
 */
public class Menu extends JFrame{
    
    //JLabel panelDelFondo; 
    JPanel panelDeFondo;
    public Menu() {
        this.setTitle("Hola");
        this.setSize( ANCHO, ALTO);
        ImageIcon backgroundMenu; 
       // backgroundMenu = new ImageIcon(this.getClass().getResource("/Imagenes/fondo_menu.jpg"));
       // panelDelFondo = new JLabel(backgroundMenu);
       // this.add(panelDelFondo);
        panelDeFondo = new JPanel();
        panelDeFondo.setBackground(Color.yellow);
        this.setContentPane(panelDeFondo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    
}
