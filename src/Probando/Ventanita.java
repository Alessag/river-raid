
package Probando;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/* @author Alessandra*/
public class Ventanita extends JFrame {

    // private JFrame ventana;
    private PersonajePrincipal c1;
    private Enemigo bm;
    private Enemigo bm2;
    private JPanel panel;
    //private JPanel gasolina;
    private int nivelGasolina;
    public static int ALTO;
    public static int ANCHO;
    private Timer tiempo;

    public Ventanita() {
        super("Ventanita");
        /*ALTO = 650;
        ANCHO = 1000;*/
        ALTO = 300;
        ANCHO = 300;
        this.setSize(ANCHO, ALTO);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setResizable(false);

      
        panel = new JPanel(null);
        /*nivelGasolina=100;
        gasolina = new JPanel(null);
        gasolina.setBounds(100, 100, 100, 100);
        gasolina.setBackground(Color.red);
        gasolina.setForeground(Color.BLUE);
        gasolina.setVisible(true);*/
        c1 = new PersonajePrincipal();

        bm = new Enemigo(10, 50);
        bm2 = new Enemigo(30, 200);

        /*
         JButton texto = new JButton("HEHE");
         texto.setBounds(0, 0, 50, 50);
         texto.setFocusable(false);
         panel.add(texto);
         */
        //panel.add(gasolina);
        panel.add(c1);
        panel.add(bm);
        panel.add(bm2);
        

        this.addKeyListener(new KeyAdapter() {
            

            @Override
            public void keyPressed(KeyEvent e) {

                c1.move(e.getKeyCode());

            }

        });

        c1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                c1.setBackground(Color.CYAN);
                panel.setBackground(Color.BLACK);
            }

        });

        this.tiempo = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajarEntidades();
                bm.MoveAlone();
                bm2.MoveAlone();
                llevarGasolinaACucuta(1);
            }
        });

        tiempo.start();

        this.setContentPane(panel);

        this.setVisible(true);
    }

    public void bajarEntidades() {
        bm.bajar();
        bm2.bajar();
    }
    
    public void llevarGasolinaACucuta(int paralelepipero){
        if(paralelepipero==1){
            nivelGasolina--;
        }
        if(paralelepipero==2){
            nivelGasolina++;
        }
        if(nivelGasolina<=0){
            System.out.println("perdio");
        }
        //gasolina.setText(String.valueOf(nivelGasolina));
    }
}
