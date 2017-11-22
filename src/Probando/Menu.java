
package Probando;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author Alessandra
 */
public class Menu extends JFrame {

    //JLabel panelDelFondo; 
    //JButton panelDeFondo;
    /**
     * Fuente estandar de la clase
     */
    Font fuente;
    /**
     * Panel principal del frame
     */
    JPanel fondo;/**
     * Imagen de fondo de la ventana
     */
    JLabel imagenFondo;
    /**
     * Boton para iniciar el juego
     */
    JButton iniciar;
   // JButton jugar;
    /**
     * Boton para acceder a las instrucciones del juego
     */
    JButton instrucciones;
    /**
     * Boton para acceder al top 10 de puntuaciones del juego
     */
    JButton top10;
    /**
     * Boton para acceder a los creditos del juego
     */
    JButton creditos;
    /**
     * Boton para salir del juego
     */
    JButton salir;
    /**
     * Ventanta auxiliar para mostrar las opciones del menu
     */
    JFrame panel;
    /**
     * Imagen de fondo de la ventana
     */
    ImageIcon backgroundMenu;
    /**
     * Boton para cerrar las ventanas auxiliares
     */
    JButton cerrar;
    /**
     * Icono del las ventnas
     */
    ImageIcon icono;
    /**
     * Clase que contiene el juego entero
     */
    RiverRaid ventanita;

    /**
     * Constructor de la clase menu
     * Inicializa todos los botones y la ventana del menu
     */
    public Menu() {
        super("Menu");
        this.setSize(RiverRaid.ANCHO, RiverRaid.ALTO);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fondo = new JPanel();
        fondo.setPreferredSize(new Dimension(RiverRaid.ANCHO, RiverRaid.ALTO));
        backgroundMenu = new ImageIcon(this.getClass().getResource("/Imagenes/fondo_0.png"));
        imagenFondo = new JLabel(backgroundMenu);
        imagenFondo.setBounds(0,0,backgroundMenu.getIconWidth(),backgroundMenu.getIconHeight());
        
        fondo.setLayout(null);
        icono = new ImageIcon(this.getClass().getResource("/Imagenes/imagen_2.png"));
        
        this.setIconImage(icono.getImage());
        
        iniciar = new JButton("Iniciar.");
        
        fuente = new Font(iniciar.getFont().getName(), Font.PLAIN, 20);
        //jugar = new JButton("");
        instrucciones = new JButton("Instrucciones.");
        top10 = new JButton("TOP 10!");
        creditos = new JButton("Creditos.");
        salir = new JButton("Salir.");
        accion acciones = new accion();
        
        cerrar = new JButton("Cerrar.");
        cerrar.setBackground(Color.white);
        cerrar.setForeground(Color.black);
        cerrar.addActionListener(acciones);
        cerrar.setFont(fuente);
                
        panel = new JFrame();
        panel.setVisible(false);
        
        iniciar.setBounds(250, 100, 200, 50);
        iniciar.setBackground(Color.green);
        iniciar.addActionListener(acciones);
        iniciar.setFont(fuente);
        
       // jugar.setBounds(200, 200, 200, 50);
        //jugar.setBackground(Color.GRAY);
        
        instrucciones.setBounds(250, 200, 200, 50);
        instrucciones.setBackground(Color.YELLOW);
        instrucciones.addActionListener(acciones);
        instrucciones.setFont(fuente);
        
        top10.setBounds(250, 300, 200, 50);
        top10.setBackground(Color.WHITE);
        top10.addActionListener(acciones);
        top10.setFont(fuente);
        
        creditos.setBounds(250, 400, 200, 50);
        creditos.setBackground(Color.magenta);
        creditos.addActionListener(acciones);
        creditos.setFont(fuente);
        
        salir.setBounds(250, 500, 200, 50);
        salir.setBackground(Color.GRAY);
        salir.setForeground(Color.BLUE);
        salir.addActionListener(acciones);
        salir.setFont(fuente);
        
        fondo.add(iniciar);
       // this.add(jugar);
        fondo.add(instrucciones);
        fondo.add(top10);
        fondo.add(creditos);
        fondo.add(salir);
        fondo.add(imagenFondo);
        this.setContentPane(fondo);
        this.setVisible(true);
    }
    /**
     * Metodo que crea una ventana auxiliar y muestra en ella las instrucciones
     */
    public void mostrarInstrucciones(){
        panel = new JFrame("Instrucciones.");
        panel.setIconImage(icono.getImage());
        ImageIcon i = new ImageIcon(this.getClass().getResource("/Imagenes/instrucciones.jpg"));
        JLabel imagen = new JLabel(i);
        imagen.setBounds(0, 0,i.getIconWidth(), i.getIconHeight());
        
        cerrar.setBounds(300,700,200,50);
        
        panel.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setAlwaysOnTop(true);
        panel.setLayout(null);
        panel.setResizable(false);
        panel.setSize(i.getIconWidth(),i.getIconHeight());
        panel.setLocationRelativeTo(this);
        panel.add(cerrar);
        panel.add(imagen);
        panel.setVisible(true);
    }
    /**
     * Metodo que crea una ventana auxiliar y muestra los creditos del juego
     */
    public void mostrarCreditos(){
        panel = new JFrame("Creditos.");
        panel.setIconImage(icono.getImage());
        ImageIcon i = new ImageIcon(this.getClass().getResource("/Imagenes/creditos.jpg"));
        JLabel imagen = new JLabel(i);
        imagen.setBounds(0, 0,800,800);
        
        cerrar.setBounds(450,730,200,50);
        
        panel.setDefaultCloseOperation(HIDE_ON_CLOSE);
        panel.setAlwaysOnTop(true);
        panel.setLayout(null);
        panel.setResizable(false);
        panel.setSize(800,840);
        panel.setLocationRelativeTo(this);
        panel.add(cerrar);
        panel.add(imagen);
        panel.setVisible(true);
    }
    /**
     * Metodo que crea una ventana auxiliar y muestra alli el top 10
     */
    public void mostrarTop10(){
        try {
            panel = new JFrame("Mejores Puntuaciones.");
            panel.setIconImage(icono.getImage());
            
            Scanner in = new Scanner(new File("top10.txt"));
            String line;
            ArrayList<JLabel> labelsNombre = new ArrayList();
            ArrayList<JLabel> labelsPuntaje = new ArrayList();
            
            ImageIcon im = new ImageIcon(this.getClass().getResource("/Imagenes/fondo_1.jpg"));
            JLabel fondo = new JLabel(im);
            fondo.setBounds(0, 0, 800, 840);
            
            JLabel titulo = new JLabel("Mejores puntuaciones de todos los tiempos!");
                titulo.setBounds(200,40 , 500, 50);
                titulo.setFont(fuente);
                titulo.setForeground(Color.white);
                panel.add(titulo);
            int y=50,x=250,w=100,h=50;
            JLabel aux = new JLabel("Jugador!");
               aux.setBounds(x, y+=50, w, h);
               aux.setFont(fuente);
               aux.setForeground(Color.white);
               
               JLabel aux2 = new JLabel("Puntaje!");
               aux2.setBounds(x+200,y,w,h);
               aux2.setFont(fuente);
               aux2.setForeground(Color.white);
               
                labelsNombre.add(aux);
                labelsPuntaje.add(aux2);
                
            while(in.hasNextLine()){
                line=in.nextLine();
                String palabras[] = line.split("-");// Posicion 0 jugador -- posicion 1 puntaje
                aux = new JLabel(palabras[0]);
               aux.setBounds(x, y+=50, w, h);
               aux.setFont(fuente);
               aux.setForeground(Color.white);
               
                aux2 = new JLabel(palabras[1]);
               aux2.setBounds(x+200,y,w,h);
               aux2.setFont(fuente);
               aux2.setForeground(Color.white);
                labelsNombre.add(aux);
                labelsPuntaje.add(aux2);
            }
            for (int i = 0; i < labelsPuntaje.size(); i++) {
                panel.add(labelsNombre.get(i));
                panel.add(labelsPuntaje.get(i));
            }
            
            
            cerrar.setBounds(300,700,200,50);
            
            panel.setDefaultCloseOperation(HIDE_ON_CLOSE);
            panel.setAlwaysOnTop(true);
            panel.setLayout(null);
            panel.setResizable(false);
            panel.setSize(800,840);
            panel.setLocationRelativeTo(this);
            // panel.add(imagen);
            panel.add(cerrar);
            panel.add(fondo);
            panel.setVisible(true);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Lo sentimos, ha ocurrido un error cargando las mejores puntuaciones, intentalo de nuevo mas tarde!");
        }
    }

   // @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.red);
        
        //g.drawString("hola", 50, 50);
        g.drawImage(backgroundMenu.getImage(),0,0, getWidth(), getHeight(), this);
    }
    
        /**
         * Clase auxiliar para escuchar las acciones de los botones
         */
    class accion implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==salir){
                System.exit(0);
            }
            if(e.getSource()==creditos){
                //if(panel!=null)
                if(!panel.isVisible())
                mostrarCreditos();
            }
            if(e.getSource()==top10){
                if(!panel.isVisible())
                 mostrarTop10();
            }
            if(e.getSource()==instrucciones){
                //if(panel!=null)
                if(!panel.isVisible())
                mostrarInstrucciones();
            }
            if(e.getSource()==iniciar){
                setVisible(false);
                String nombre=JOptionPane.showInputDialog("Ingresa tu nombre: ");
                while(nombre.length()>8 || nombre.length()==0){
                    nombre=JOptionPane.showInputDialog("Por favor ingresa un nombre valido, max 8 caracteres: ");
                }
                ventanita = new RiverRaid(nombre);
            }
            if(e.getSource()==cerrar){
                panel.setVisible(false);
            }
        }
        
    }
}
