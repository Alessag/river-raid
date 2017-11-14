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
import javax.swing.JPanel;
import javax.swing.Timer;

/* @author Alessandra*/
public class RiverRaid extends JFrame {

    // private JFrame ventana;
    private Cuadradito c1;
    private BichitoMove bm;
    private BichitoMove bm2;
    private JPanel panel;
    public static int ALTO = 500;
    public static int ANCHO = 700;
    private Timer tiempo;

    public RiverRaid() {
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

        c1 = new Cuadradito();

        bm = new BichitoMove(10, 50);
        bm2 = new BichitoMove(30, 200);

        /*
         JButton texto = new JButton("HEHE");
         texto.setBounds(0, 0, 50, 50);
         texto.setFocusable(false);
         panel.add(texto);
         */
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

}
