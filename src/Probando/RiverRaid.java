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
