package modelo;

import java.awt.geom.Rectangle2D;

public class Pelota {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double x = 0;
    private static double y = 0;
    private double dx = 1;
    private double dy = 1;

    private int puntaje1 = 0, puntaje2 = 0;
    public static boolean finJuego = false;


    //retorna la pelota
    public Rectangle2D getShape() {
        return new Rectangle2D.Double(x, y, TAMX, TAMY);
    }

    public void moverPelota(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        x += dx;
        y += dy;

        if (colisionR1) {
            dx = -dx;
            x = 20;
        }

        if (colisionR2) {
            dx = -dx;
            x = 755;

        }

        if (x < limites.getMinX()) {
            puntaje2++;
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;

        }

        if (x + TAMX >= limites.getMaxX()) {
            puntaje1++;
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = limites.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {
            y = limites.getMaxY() - TAMY;
            dy = -dy;
        }

    }


    public int getPuntaje1() {
        return puntaje1;
    }

    public int getPuntaje2() {
        return puntaje2;
    }
}
