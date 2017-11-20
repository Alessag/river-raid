<<<<<<< HEAD
package Probando;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/* @author Alessandra*/
public class RiverRaid extends JFrame {

    // private JFrame ventana;
    private JPanel panelJuego;
    private Menu panelMenu;
    private PersonajePrincipal avion_pprincipal;
    private Enemigo enemigo1;
    private Enemigo enemigo2;
    private Enemigo enemigo3;
    private Gasolina nivelGasolina;
    private GasolinaTanque tanqueGasolina;
    private Vidas vidas;
    private Timer tiempo;
    private Graphics g;
    private ArrayList<Disparos> balas;
    public static int ALTO = 750;
    public static int ANCHO = 700;
    private JLabel minutos;
    private JLabel cronometro;

    public RiverRaid() {
        //Para que se vea bien la ventana principal
        super("Ventanita");
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
          agregarPanelJuego();
        //agregarPanelMenu();
         this.setVisible(true);
    }

    public void bajarObjetos() {
        enemigo1.bajar();
        enemigo2.bajar();
        enemigo3.bajar();
        tanqueGasolina.bajar();
    }

    public void subirOjetos() {
        if (enemigo1.getY() > ALTO) {
            enemigo1.subir();
            enemigo1.setVisible(true);
        }

        if (enemigo2.getY() > ALTO) {
            enemigo2.subir();
            enemigo2.setVisible(true);
        }
        if (enemigo3.getY() > ALTO) {
            enemigo3.subir();
            enemigo3.setVisible(true);
        }

        if (tanqueGasolina.getY() > ALTO) {
            tanqueGasolina.subir();
            tanqueGasolina.setVisible(true);
            //System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }

    }

    public void cerrarVentana() {
        this.dispose();
        System.exit(0);
    }

    public void agregarPanelJuego(){
        panelJuego = new JPanel(null);

        avion_pprincipal = new PersonajePrincipal();
        enemigo1 = new Enemigo(10, 50);
        enemigo2 = new Enemigo(30, 200);
        enemigo3 = new Enemigo(40, 500);
        nivelGasolina = new Gasolina();
        // Random r = new Random();
        //int alex = r.nextInt(ANCHO);
        tanqueGasolina = new GasolinaTanque(100, 200);

        vidas = new Vidas();
        balas = new ArrayList<>();

        /* cronometro = new JLabel();
         cronometro.setText("Tiempo ");
         cronometro.setBounds(0, 0, 60, 60);*/
        panelJuego.add(avion_pprincipal);
        panelJuego.add(enemigo1);
        panelJuego.add(enemigo2);
        panelJuego.add(enemigo3);
        panelJuego.add(nivelGasolina);
        panelJuego.add(tanqueGasolina);
        panelJuego.add(vidas);
        // panel.add(minutos);
        //panel.add(cronometro);

        //Manejo de Eventos, para que haga las cositas 
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                avion_pprincipal.move(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Disparos disparito = new Disparos(avion_pprincipal.getX() + avion_pprincipal.getWidth() / 2, avion_pprincipal.getY());
                    balas.add(disparito);
                    panelJuego.add(disparito);
                }
            }

        });

        avion_pprincipal.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                avion_pprincipal.setBackground(Color.CYAN);
                panelJuego.setBackground(Color.BLACK);
            }

        });

        this.tiempo = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajarObjetos();
                subirOjetos();
                enemigo1.MoveAlone();
                enemigo2.MoveAlone();
                enemigo3.MoveAlone();

                if (avion_pprincipal.getBounds().intersects(tanqueGasolina.getBounds())) {

                    avion_pprincipal.TanqueandoGasolina(1);

                } else {

                    avion_pprincipal.TanqueandoGasolina(-1);

                    if (avion_pprincipal.getGasolina() == 0) {
                        vidas.quitarVida();
                        avion_pprincipal.setGasolina(200);
                        avion_pprincipal.setBounds(ALTO / 2, ALTO / 2, avion_pprincipal.anchoC, avion_pprincipal.altoC);

                    }

                }

                if (enemigo1.getBounds().intersects(avion_pprincipal.getBounds()) || enemigo2.getBounds().intersects(avion_pprincipal.getBounds()) || enemigo3.getBounds().intersects(avion_pprincipal.getBounds())) {
                    vidas.quitarVida();
                    avion_pprincipal.setGasolina(200);
                    avion_pprincipal.setBounds(ALTO / 2, ALTO / 2, avion_pprincipal.anchoC, avion_pprincipal.altoC);
                }

                for (int i = 0; i < balas.size(); i++) {

                    balas.get(i).mover();

                    //Cuando una bala choque con un enemigo va a ser eliminado el enemigo :c 
                    if (balas.get(i).getBounds().intersects(enemigo1.getBounds())) {
                        System.out.println("Deberia eliminarse el personaje xd ");
                        //panel.remove(enemigo1);
                        enemigo1.setVisible(false);

                    }

                    if (balas.get(i).getBounds().intersects(enemigo2.getBounds())) {
                        System.out.println("Deberia eliminarse el personaje xd ");
                        //panel.remove(enemigo2);
                        enemigo2.setVisible(false);
                    }

                    if (balas.get(i).getBounds().intersects(enemigo3.getBounds())) {
                        System.out.println("Deberia eliminarse el personaje xd ");
                        // panel.remove(enemigo3);
                        enemigo3.setVisible(false);

                    }

                    if (balas.get(i).getBounds().intersects(tanqueGasolina.getBounds())) {
                        tanqueGasolina.setVisible(false);
                    }

                }

                //Eliminando las balas que ya subieron
                for (int i = 0; i < balas.size(); i++) {
                    if (balas.get(i).getY() < 0) {
                        panelJuego.remove(balas.get(i));
                        balas.remove(i);
                    }
                }

                nivelGasolina.setGasolinaNivel(avion_pprincipal.getGasolina());

                //Pa cuando ya las vidas se acaben salga un cuadrito que perdiste que si quieres volver a jugar o no se
                if (vidas.getCont() == 0) {
                    System.out.println("hola");
                     JOptionPane.showConfirmDialog(null, "Has perdido, desea salir? ");
                    cerrarVentana();

                }
            }
        });
        tiempo.start();

        this.setContentPane(panelJuego);
    }
    
    public void agregarPanelMenu(){
        
        panelMenu = new Menu();
        
        this.add(panelMenu);
        //panelDeFondo.setBackground(Color.yellow);
        //panelDeFondo.add(backgroundMenu);
    }
}
=======
package Probando;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/* @author Alessandra*/
public class RiverRaid extends JFrame {

    // private JFrame ventana;
    private JPanel panel;
    private Cuadradito avion_pprincipal;
    private Enemigo enemigo1;
    private Enemigo enemigo2;
    private Gasolina nivelGasolina; 
    private Vidas vidas; 
    private Timer tiempo;
    private Graphics g;
    private ArrayList<Disparos> balas;
    public static int ALTO = 500;
    public static int ANCHO = 700;
    
    

    public RiverRaid() {
        //Para que se vea bien la ventana principal
        super("Ventanita");
        /*ALTO = 650;
        ANCHO = 1000;*/
       /* ALTO = 500;
        ANCHO = 700;*/
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        panel = new JPanel(null);

        avion_pprincipal = new Cuadradito();
        enemigo1 = new Enemigo(10, 50);
        enemigo2 = new Enemigo(30, 200);
        nivelGasolina = new Gasolina();
        vidas = new Vidas();
        balas = new ArrayList<>();

        /*
         JButton texto = new JButton("HEHE");
         texto.setBounds(0, 0, 50, 50);
         texto.setFocusable(false);
         panel.add(texto);
         */
        panel.add(avion_pprincipal);
        panel.add(enemigo1);
        panel.add(enemigo2);
        panel.add(nivelGasolina);
        panel.add(vidas);
        
        
        //Manejo de Eventos, para que haga las cositas 
        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {

                avion_pprincipal.move(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    Disparos disparito = new Disparos(avion_pprincipal.getX() + avion_pprincipal.getWidth()/2, avion_pprincipal.getY());
                    balas.add(disparito);
                    panel.add(disparito);
                }
            }
            

        });

        avion_pprincipal.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                avion_pprincipal.setBackground(Color.CYAN);
                panel.setBackground(Color.BLACK);
            }

        });

        this.tiempo = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajarEntidades();
                enemigo1.MoveAlone();
                enemigo2.MoveAlone();
                if(avion_pprincipal.getBounds().intersects(enemigo1.getBounds()) || avion_pprincipal.getBounds().intersects(enemigo2.getBounds()) ){
                   // JOptionPane.showMessageDialog(null, "perdiste una vida");
                    //System.out.println("ganando gasolina");
                    avion_pprincipal.TanqueandoGasolina(1);
                   
                    
                   
                  // cerrarVentana();
                }
                else{ 
                   // System.out.println("perdiendo gasolina"); 
                    
                    avion_pprincipal.TanqueandoGasolina(-1);
                    //avion_pprincipal.TanqueandoGasolina(0);
                        vidas.quitarVida();
                    
                }
               
                
                /*if(avion_pprincipal.getBounds().intersects(enemigo2.getBounds())){
                          // JOptionPane.showMessageDialog(null, "perdiste una vida");
                    //System.out.println("ganando gasolina");
                    avion_pprincipal.TanqueandoGasolina(1);
                   
                  // cerrarVentana();
                }
                else{ 
                    
                   // System.out.println("perdiendo gasolina"); 
                    
                    avion_pprincipal.TanqueandoGasolina(-1);
                    //avion_pprincipal.TanqueandoGasolina(0);
                }*/
                
                for (int i = 0; i < balas.size(); i++) {
                    //balas.get(i).setBounds(balas.get(i).getX(), balas.get(i).getY()-10, Disparos.ANCHO, Disparos.ALTO);
                    balas.get(i).mover();
                    
                }
                
                for (int i = 0; i < balas.size(); i++) {
                    if (balas.get(i).getY() < 0) {
                        panel.remove(balas.get(i));
                        balas.remove(i);
                    }
                }
                
                nivelGasolina.setGasolinaNivel(avion_pprincipal.getGasolina());
            }
        });
        tiempo.start();

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void bajarEntidades() {
        //bm.bajar();
        //bm2.bajar();
    }
    
    public void cerrarVentana(){
        this.dispose();
        System.exit(0);
    }
    
    /* public void Gasolineando(int gasolina){
        if(gasolina==1){
            gasolina--;
        }
        if(gasolina==2){
            gasolina++;
        }
        if(gasolina<=0){
            System.out.println("perdio");
        }
        //gasolina.setText(String.valueOf(nivelGasolina));
    }*/
    

}
>>>>>>> 1da305c70804e0813f6ef2053fbeb701e65eec9b
