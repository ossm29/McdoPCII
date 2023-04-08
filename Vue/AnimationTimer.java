package Vue;

import java.awt.*;

/**
 * Classe AnimationTimer hérite de la class 'Thread'.
 * Elle représente le timer d'animation et l'affiche avec la méthode run()
 * de la classe 'Thread'.
 *
 * @vesion 1.0
 * */
public class AnimationTimer extends Thread {

    /** Attributs */

    /* durée du timer en ms */
    private int timerValue;
    /* position actuelle du timer */
    private int timerPosition;
    /* diamètre du cercle pour l'affichage du timer */
    private int circleDiameter;
    /* Initialisation de l'intervalle entre chaque rafraichissement d'affichage */
    private int sleeptime = 30;

    /** Coordonnées du cercle */
    /* coordonnée x du cercle */
    private int x;
    /* coordonnée y du cercle */
    private int y;

    /**
     * Constructeur
     * Définit et initialise les instances nécessaires pour le timer et de son animation.
     *
     * @param timerValue      Durée du timer en ms de type 'int'
     * @param circleDiameter  Diamètre du cercle de type 'int'
     * @param x               Coordonnée x du cercle de type 'int
     * @param y               Coordonnée y du cercle de type 'int''
     * */
    public AnimationTimer(int timerValue, int circleDiameter, int x, int y) {
        this.timerValue = timerValue;
        // Initialisation de la position du timer à 0
        this.timerPosition = 0;
        this.circleDiameter = circleDiameter;
        this.x = x;
        this.y = y;
    }


    /**
     * Méthode de la classe 'Thread' appelée lorsqu'on appelle la méthode "start()"
     * du Thread.
     * Elle calcule la position actuelle du timer et met à jour l'affichage toutes les
     * quelques millisecondes (durée déterminée par la variable "sleeptime").
     * Elle tue le thread 4 seconde après la fin du timer.
     *
     * */
    @Override
    public void run() {
        while (timerPosition < timerValue) {
            timerPosition = timerPosition+sleeptime;
            try {
                Thread.sleep(sleeptime); // attendre une seconde
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 4 seconde après la fin du timer, on tue le thread
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.interrupt();
    }


    /**
     * Méthode qui dessine l'animation circulaire du timer.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * */
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