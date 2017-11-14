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
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alessandra
 */
public class Menu extends JFrame{
    
    JLabel panelDelFondo; 

    public Menu() {
        this.setTitle("Hola");
        this.setSize( ANCHO, ALTO);
        ImageIcon backgroundMenu; 
        backgroundMenu = new ImageIcon(this.getClass().getResource("/Imagenes/fondo_0.png"));
        panelDelFondo = new JLabel(backgroundMenu);
        this.add(panelDelFondo);
     
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    
    
    
}
