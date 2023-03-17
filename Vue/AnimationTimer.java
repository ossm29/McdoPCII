package Vue;

import java.awt.*;

public class AnimationTimer extends Thread {

    private int timerValue; // durée du timer en ms
    private int timerPosition; // position actuelle du timer en ms
    private int circleDiameter; // diamètre du cercle

    private int sleeptime = 25; //intervalle entre chaque rafraichissement
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
            timerPosition = timerPosition+sleeptime;
            try {
                Thread.sleep(sleeptime); // attendre une seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } //1 seconde après la fin du timer on tue le thread
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.interrupt(); //1 seconde après la fin du timer on tue le thread
    }


    public void dessineTimer(Graphics g) {
        int angle = (int) (360.0 * timerPosition / timerValue); // calcul de l'angle en degrés
        g.setColor(Color.WHITE);
        //affiche un cercle de fond pour le timer
        //g.fillOval(x, y, circleDiameter, circleDiameter);
        //g.setColor(Color.BLACK);
        g.setColor(new Color(120,120,120,155));
        g.fillArc(x, y, circleDiameter, circleDiameter, 0, angle);
    }

}