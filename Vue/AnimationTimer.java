package Vue;

import java.awt.*;

public class AnimationTimer extends Thread {

    private int timerValue; // durée du timer en secondes
    private int timerPosition; // position actuelle du timer en secondes
    private int circleDiameter; // diamètre du cercle
    private int x; // coordonnée x du cercle
    private int y; // coordonnée y du cercle

    public AnimationTimer(int timerValue, int circleDiameter, int x, int y) {
        this.timerValue = timerValue;
        this.timerPosition = 0;
        this.circleDiameter = circleDiameter;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (timerPosition < timerValue) {
            timerPosition++;
            try {
                Thread.sleep(1000); // attendre une seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void dessineTimer(Graphics g) {
        int angle = (int) (360.0 * timerPosition / timerValue); // calcul de l'angle en degrés
        g.setColor(Color.WHITE);
        g.fillOval(x, y, circleDiameter, circleDiameter);
        g.setColor(Color.BLACK);
        g.fillArc(x, y, circleDiameter, circleDiameter, 0, angle);
    }

}