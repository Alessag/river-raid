
package Probando;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/* @author Alessandra*/
public class RiverRaid extends JFrame {

    // private JFrame ventana;
    private JPanel panelJuego;
    private Menu panelMenu;
    private PersonajePrincipal avion_pprincipal;
    private ArrayList<Enemigo> enemigos;
   // private Enemigo enemigo1;
  //  private Enemigo enemigo2;
  //  private Enemigo enemigo3;
    private Gasolina nivelGasolina;
    private GasolinaTanque tanqueGasolina;
    private Vidas vidas;
    private Timer tiempo;
    private Graphics g;
    private ArrayList<Disparos> balas;
    public static int ALTO = 750;
    public static int ANCHO = 700;
    private JLabel segundos;
    private  Timer tiempoPartida;
    int seg = 0;
    int min = 1;
    private ImageIcon icono;
    private String nombre;
    private JLabel labelNombre;
    private Puntos puntaje;
    /**
     * Constructore de la clase RiverRaid, clase principal del juego
     * Inicializa todos sus atributos ya agrega el panel de juego
     * @param nombre El nombre del jugador 
     */
    public RiverRaid(String nombre) {
        //Para que se vea bien la ventana principal
        super("RiverRaid!");
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.nombre=nombre;
        
        icono = new ImageIcon(this.getClass().getResource("/Imagenes/imagen_2.png"));
        this.setIconImage(icono.getImage());
        agregarPanelJuego();
        //agregarPanelMenu();
         this.setVisible(true);
    }
    /**
     * Metodo que baja todos los objetos del juego
     * 
     */
    public void bajarObjetos(){
        for (int i = 0; i < enemigos.size(); i++) {
        enemigos.get(i).bajar();
        }
        //enemigo1.bajar();
        //enemigo2.bajar();
        //.bajar();
        tanqueGasolina.bajar();
    }
    /**
     * Metodo que hace subir todos los objetos del juego
     */
    public void subirOjetos() {
        for (int i = 0; i < enemigos.size(); i++) {
            if(enemigos.get(i).getY() > ALTO){
            enemigos.get(i).subir();
            enemigos.get(i).setVisible(true);
            }
        
        }
        /*if (enemigo1.getY() > ALTO) {
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
        */

        if (tanqueGasolina.getY() > ALTO) {
            tanqueGasolina.subir();
            tanqueGasolina.setVisible(true);
            //System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        }

    }
    /**
     * Metodo que cierra la ventana
     */
    public void cerrarVentana() {
        this.dispose();
        System.exit(0);
    }
    /**
     * Metodo que agrega todos los componentes al panel y lo agrega a la ventana
     */
    public void agregarPanelJuego(){
        panelJuego = new JPanel(null);
       

        avion_pprincipal = new PersonajePrincipal();
       // enemigo1 = new Enemigo(10, 50);
       // enemigo2 = new Enemigo(30, 200);
       // enemigo3 = new Enemigo(40, 500);
        nivelGasolina = new Gasolina();
        segundos = new JLabel("01:30");
        // Random r = new Random();
        //int alex = r.nextInt(ANCHO);
        tanqueGasolina = new GasolinaTanque(100, 200);

        vidas = new Vidas();
        balas = new ArrayList<>();
        enemigos = new ArrayList();
        enemigos.add(new Enemigo(10, 50));
        enemigos.add(new Enemigo(30, 200));
        enemigos.add(new Enemigo(40, 500));
        
        labelNombre = new JLabel(nombre);
        labelNombre.setFont(new Font(segundos.getFont().getName(), Font.PLAIN, 25));
        labelNombre.setBounds(530, 10, 150, 50);
        
        this.puntaje = new Puntos();
        /* cronometro = new JLabel();
         cronometro.setText("Tiempo ");
         cronometro.setBounds(0, 0, 60, 60);*/
        panelJuego.add(avion_pprincipal);
        
        for (int i = 0; i < enemigos.size(); i++) {
            panelJuego.add(enemigos.get(i));
        }
        
       // panelJuego.add(enemigo1);
        //panelJuego.add(enemigo2);
        //panelJuego.add(enemigo3);
        panelJuego.add(nivelGasolina);
        panelJuego.add(tanqueGasolina);
        panelJuego.add(vidas);
        panelJuego.add(segundos);
        panelJuego.add(labelNombre);
        panelJuego.add(puntaje);
        // panel.add(minutos);
        //panel.add(cronometro);
        //segundos.setLayout(null);
        segundos.setBounds(25, 10, 50, 50);
        segundos.setFont(new Font(segundos.getFont().getName(), Font.PLAIN, 20));
//segundos.setText("Hola");
        segundos.setForeground(Color.black);
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
                for (int i = 0; i < enemigos.size(); i++) {
                enemigos.get(i).MoveAlone();
                }
                /*
                enemigo1.MoveAlone();
                enemigo2.MoveAlone();
                enemigo3.MoveAlone();
*/
                if (avion_pprincipal.getBounds().intersects(tanqueGasolina.getBounds()) && tanqueGasolina.isVisible()) {

                    avion_pprincipal.TanqueandoGasolina(1);

                } else {

                    avion_pprincipal.TanqueandoGasolina(-1);

                    if (avion_pprincipal.getGasolina() == 0) {
                        vidas.quitarVida();
                        avion_pprincipal.setGasolina(200);
                        avion_pprincipal.setBounds(ALTO / 2, ALTO / 2, avion_pprincipal.anchoC, avion_pprincipal.altoC);

                    }

                }
                for (int i = 0; i < enemigos.size(); i++) {
                    if( avion_pprincipal.getBounds().intersects(enemigos.get(i).getBounds()) && enemigos.get(i).isVisible()){
                    vidas.quitarVida();
                    avion_pprincipal.setGasolina(200);
                    avion_pprincipal.setLocation(ALTO / 2, ALTO / 2);
                    
                        for (int k = 0; k < enemigos.size(); k++) {
                            enemigos.get(k).subir();
                        }
                    }
                }
                /*if (enemigo1.getBounds().intersects(avion_pprincipal.getBounds()) || enemigo2.getBounds().intersects(avion_pprincipal.getBounds()) || enemigo3.getBounds().intersects(avion_pprincipal.getBounds())) {
                    vidas.quitarVida();
                    avion_pprincipal.setGasolina(200);
                    avion_pprincipal.setLocation(ALTO / 2, ALTO / 2);
                }*/

                for (int i = 0; i < balas.size(); i++) {

                    balas.get(i).mover();

                    //Cuando una bala choque con un enemigo va a ser eliminado el enemigo :c 
                    for (int k = 0; k < enemigos.size(); k++) {
                        if(balas.get(i).getBounds().intersects( enemigos.get(k).getBounds() ) && enemigos.get(k).isVisible() && balas.get(i).isValida()){
                            //enemigos.get(k).setVisible(false);
                            if(enemigos.get(k).quitarHP())
                            puntaje.sumarPuntos();
                            balas.get(i).setValida(false);
                        }
                        
                    }
                   /* if (balas.get(i).getBounds().intersects(enemigo1.getBounds())) {
                        //System.out.println("Deberia eliminarse el personaje xd ");
                        //panel.remove(enemigo1);
                        enemigo1.setVisible(false);
                        

                    }

                    if (balas.get(i).getBounds().intersects(enemigo2.getBounds())) {
                       // System.out.println("Deberia eliminarse el personaje xd ");
                        //panel.remove(enemigo2);
                        enemigo2.setVisible(false);
                    }

                    if (balas.get(i).getBounds().intersects(enemigo3.getBounds())) {
                        //System.out.println("Deberia eliminarse el personaje xd ");
                        // panel.remove(enemigo3);
                        enemigo3.setVisible(false);

                    }
                    */
                    if (balas.get(i).getBounds().intersects(tanqueGasolina.getBounds()) && tanqueGasolina.isVisible() && balas.get(i).isValida()) {
                        tanqueGasolina.setVisible(false);
                        puntaje.restarPuntos();
                        balas.get(i).setValida(false);
                        
                    }

                }

                //Eliminando las balas que ya subieron
                for (int i = 0; i < balas.size(); i++) {
                    if (balas.get(i).getY() < 0 || !balas.get(i).isValida()) {
                        panelJuego.remove(balas.get(i));
                        balas.remove(i);
                    }
                }

                nivelGasolina.setGasolinaNivel(avion_pprincipal.getGasolina());

                //Pa cuando ya las vidas se acaben salga un cuadrito que perdiste que si quieres volver a jugar o no se
                if (vidas.getCont() == 0) {
                    //System.out.println("hola");
                    tiempoPartida.stop();
                     JOptionPane.showMessageDialog(null,"Has perdido, Mejor suerte la proxima!");
                    cerrarVentana();

                }
            }
        });
        tiempo.start();
        
        this.tiempoPartida = new Timer(1000, new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                String time = segundos.getText();
                String time2[] = time.split(":");
                int min=Integer.valueOf(time2[0]),segunditos=Integer.valueOf(time2[1]);
                    if(min >= 0 &&  segunditos > 0){
                        segunditos--;
                        if(segunditos == 0){
                            if(min >= 1){
                                min--;
                                segunditos=59;
                            }else{
                            tiempoPartida.stop();
                            JOptionPane.showMessageDialog(null, "Has llegado a tu destino, enhorabuena, felicidades por haber ganado!");
                            agregarTop10();
                            panelJuego.setBackground(Color.blue);
                            cerrarVentana();
                            }
                        }
                        
                    }else{
                        tiempoPartida.stop();
                        JOptionPane.showMessageDialog(null, "Has llegado a tu destino, enhorabuena, felicidades por haber ganado!");
                        //System.out.println("Has llegado a tu destino, enhorabuena, felicidades por haber ganado!");
                        agregarTop10();
                        panelJuego.setBackground(Color.blue);
                        cerrarVentana();
                    }
                   time = "0"+String.valueOf(min)+":";
                   if(segunditos<9)
                       time+="0"+String.valueOf(segunditos);
                   else
                       time+=String.valueOf(segunditos);
                    segundos.setText(time);
                   /*(seg <= 90){
                       
                       seg-=1;
                       segundos.setText(Integer.toString(seg) + " s");
                       //panelJuego.setBackground(Color.blue);
                       
                        
                   }
                   if(seg == 0 ){
                       tiempoPartida.stop();
                       System.out.println("Has llegado a tu destino, enhorabuena, felicidades por haber ganado!");
                       panelJuego.setBackground(Color.blue);
                      
                   }*/
              
            
            }
        });
        tiempoPartida.start();
        
        
        this.setContentPane(panelJuego);
    }
    /*
    public void agregarPanelMenu(){
        
        panelMenu = new Menu();
        
        this.add(panelMenu);
        //panelDeFondo.setBackground(Color.yellow);
        //panelDeFondo.add(backgroundMenu);
    }*/
    
    public void paintComponent(Graphics g) {
        tanqueGasolina.paintComponents(g);
    }
    /**
     * Metodo que agrega al top 10 al jugador de haber cumplido con los requerimientos dados
     */
    public void agregarTop10(){
        try {
            boolean bandera = false;// Entra en el top 10
            Scanner in = new Scanner(new File("top10.txt"));
            String linea;
            ArrayList<String> names = new ArrayList();
            ArrayList<Integer> points = new ArrayList();
            while(in.hasNextLine()){
                linea = in.nextLine();
                String palabras[] = linea.split("-");
                names.add(palabras[0]);
                points.add(Integer.valueOf(palabras[1]));
            }
            in.close();
            String aux = null;
            int aux2 = 0;
            int i;
            for ( i = points.size()-1; i >= 0; i--) {
                if(puntaje.getPuntos() >= points.get(i) ){
                    bandera=true;
                    if(i< points.size()-1){
                    names.set(i+1,names.get(i));
                    points.set(i+1, points.get(i));
                    }
                    names.set(i, nombre);
                    points.set(i, puntaje.getPuntos());
                } else{
                    break;
                }
            }
            if(bandera){
                JOptionPane.showMessageDialog(null, "Felicidades, tu puntaje ha entrado al top 10! En hora buena!");
            }
            
            File file = new File("top10.txt");
            //file.createNewFile();
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            for (int k = 0; k < points.size(); k++) {
                //bw.flush();
                System.err.println(names.get(k)+"-"+String.valueOf(points.get(k)));
            pw.print(names.get(k)+"-"+String.valueOf(points.get(k)));
            pw.println();
            }
            pw.close();
            bw.close();
            fw.close();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lo sentimos, ocurrio un error al intentar guardar tu puntuacion, por favor intentalo mas tarde."+ex.getMessage());
        }
    }
}
