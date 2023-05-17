package vista;

import javax.swing.*;

import modelo.Multijugador;
import modelo.HiloTablero;
import modelo.Pelota;
import modelo.Tablero;

public class VistaTablero extends JFrame {

    Tablero canvas;
    //Pelota p = new Pelota();

    public VistaTablero() {
        setTitle("Ping pong ");
        setSize(810, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        canvas = new Tablero();
        add(canvas);

        addKeyListener(new Multijugador());
        new HiloTablero(canvas).start();
    }
}