package modelo;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    Raqueta r1 = new Raqueta(10, 200);
    Raqueta r2 = new Raqueta(794 - 10 - Raqueta.ANCHO, 200);
    Pelota p = new Pelota();
    Pelota t = new Pelota();


    public Tablero() {
        this.setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.blue);
        dibujarPuntaje(g2);
        dibujar(g2);

    }

    private void dibujar(Graphics2D g) {
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());

        g.draw(linea);

        g.fill(r1.getRaqueta());
        update();

        g.fill(r2.getRaqueta());
        update();

        g.fill(p.getShape());
        update();

        g.fill(t.getShape());
        update();
    }

    //actualiza el estado (posicion) de las raquetas y pelota
    private void update() {

        p.moverPelota(getBounds(), colision(r1.getRaqueta()), colision(r2.getRaqueta()));
        t.moverPelota(getBounds(), colision1(r1.getRaqueta()), colision1(r2.getRaqueta()));


        r1.moverR1(getBounds());
        r2.moverR2(getBounds());
    }

    //detecta si existe una colision entre la raqueta y la pelota
    private boolean colision(Rectangle2D r) {
        return p.getShape().intersects(r);
    }

    private boolean colision1(Rectangle2D r) {
        return t.getShape().intersects(r);
    }

    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("TW Cent", Font.BOLD, 30);
        g.setFont(score);

        g1.drawString(Integer.toString(p.getPuntaje1()+t.getPuntaje1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(p.getPuntaje2()+t.getPuntaje2()), (float) getBounds().getCenterX() + 25, 30);
        if (p.getPuntaje1() ==10) {
            g.drawString("El jugador 1 ha ganado", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
        if (p.getPuntaje2() == 10) {
            g.drawString("El jugador 2 ha ganado", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
        }
    }

}
