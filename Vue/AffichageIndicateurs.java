package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Classe AfficheIndicateurs hérite de la classe 'JPanel' de Swing.
 * Elle affiche les indicateurs du jeu :
 * - la barre de progression qui correspond au taux d’énervement du client en cours
 * - l’affichage de colère qui affiche le client selon son taux d’énervement.
 *
 * @version 1.0
 * */
public class AffichageIndicateurs extends JPanel{

    /** Attributs */

    /* Variable Etat que notre classe retranscrira en affichage */
    Etat etat;
    /* L'affichage du client selon son taux d'énervement */
    AffichageColere affichageColere;
    /* L'affichage de la barre de progression du taux d'énervement du client */
    AffichageBarreDeProgression affichageBarreDeProgression;


    /**
     * Constructeur
     * Initialise les affichages nécessaires et les ajoute
     * à la vue.
     * Gère les dimensions du JPanel.
     *
     *
     * @param etat  l'état actuel de l'application de type 'Etat'
     * */
    public AffichageIndicateurs(Etat etat){

        // Définit les dimensions du JPanel
        this.setPreferredSize(new Dimension(390, 45));

        // Définition de l'état choisi
        this.etat = etat;
        // Initialisation des affichages
        this.affichageBarreDeProgression = new AffichageBarreDeProgression();
        this.affichageColere = new AffichageColere(this.etat) ;

        // Ajout de l'affichage de la barre de progression à droite du JPanel
        this.add(affichageBarreDeProgression, BorderLayout.EAST);
        // Ajout de l'affichage de la colère à gauche du JPanel
        this.add(affichageColere,BorderLayout.WEST);

    }

    /**
     * Méthode qui met à jour la barre de progression avec la méthode
     * "updateProgressBar" et choisi la couleur de l'arrière-plan
     * lors de l'affichage.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * */
    public void paint(Graphics g){
        this.setBackground(new Color(119, 181, 254));
        super.paint(g);
        this.updateProgressBar();
    }

    /**
     * Méthode qui met à jour la barre de progression en fonction
     * du temps d'attente maximal associé au client concerné.
     *
     * */
    public void updateProgressBar() {
        // écrit le numéro du client sur la barre
        //this.affichageBarreDeProgression.setFont(angryFont);
        //écrit l'index (et non pas l'id du client en cours
        //this.affichageBarreDeProgression.setString("CLIENT N°"+ this.etat.getClient_en_cours());
        //this.affichageBarreDeProgression.setString("CLIENT N°"+ this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getIdentifiant());

        // La valeur de la barre de progression reflètera le timer du client
        if (!this.etat.fileVide()) {
            this.affichageBarreDeProgression.setString("CLIENT N°"+ this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getIdentifiant());
            this.affichageBarreDeProgression.setValue((int) this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getTimer());
            // Si il timer est supèrieur à 25 secondes
            if (this.affichageBarreDeProgression.getValue() > 25) {
                // Colorier en vert
                this.affichageBarreDeProgression.setForeground(Color.GREEN);
            }
            // Sinon si il est supèrieur à 10
            else if (this.affichageBarreDeProgression.getValue() > 10) {
                // Colorier en jaune
                this.affichageBarreDeProgression.setForeground(Color.yellow);
            }
            // Sinon
            else {
                // Colorier en rouge car il reste moins de 10 secondes
                this.affichageBarreDeProgression.setForeground(Color.RED);
            }
        }
        else { this.affichageBarreDeProgression.setString("EN ATTENTE DE CLIENTS");}
    }
}
