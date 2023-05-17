package modelo;

public class HiloTablero extends Thread{
    private final Tablero tablero;

    public HiloTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            tablero.repaint();
            try {
                //Velocidad de la pelota (retraso)
                Thread.sleep(13);
            } catch (Exception e) {
                System.out.println("Error en ejecutar la accion " + e.getMessage());
            }
        }
    }
}
