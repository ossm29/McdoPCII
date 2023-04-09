package Vue;

import Controleur.ControlClientClicDroit;
import Controleur.ControlClientClicGauche;
import Modele.Etat;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;


/**
 * Classe AffichageClient hérite de la classe 'JPanel' de Swing.
 * Elle représente l'affichage de la liste des différents clients et de son état dans notre application.
 *
 * @version 1.0
 * */
public class AffichageClient extends JPanel {

    /** Constantes Fenêtre */
    /* Largeur Fenetre */
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);
    /* Hauteur Fenetre */
    public static final int HAUTEUR = 360;

    /** Attributs */
    /* Variable Etat que notre classe retranscrira en affichage */
    private Etat etat;
    /* Variable qui gère l'affichage des clients */
    private miniAffichageClient miniAffichageClient;
    /* Affichage des indicateurs d'énervement du client */
    private AffichageIndicateurs indicateurs;



    /**
     * Constructeur
     * Gère l'affichage des clients ainsi que leurs états (indicateur d'énervement).
     * Gère le changement d'affichage sur la fenêtre entre les clients différents.
     *
     * @param etat  l'état actuel de type 'Etat'
     * */
    public AffichageClient(Etat etat){
        // Définition des dimensions de notre JPanel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        this.setEtat(etat);
        this.miniAffichageClient = new miniAffichageClient(this.etat);


        // Boutton Gauche et Droit
        JButton boutongauche = new JButton("<");
        JButton boutondroit = new JButton(">");
        // Dimensions Boutons
        boutongauche.setPreferredSize(new Dimension(40, 230));
        boutondroit.setPreferredSize(new Dimension(40,230));
        // Decoration boutons
        Font police = boutongauche.getFont(); // récupère la police actuelle
        Font nouvellePolice = new Font(police.getName(), police.getStyle(), police.getSize()-2);
        boutongauche.setFont(nouvellePolice);
        boutondroit.setFont(nouvellePolice);

        boutongauche.setBackground(Color.white);
        boutondroit.setBackground(Color.white);

        // Ajout des controleurs afin de pouvoir voir différents clients
        boutongauche.addMouseListener(new ControlClientClicGauche(this.etat, this.miniAffichageClient));
        boutondroit.addMouseListener((new ControlClientClicDroit(this.etat, this.miniAffichageClient)));

        // Barre de progression
        this.indicateurs = new AffichageIndicateurs(this.etat);

        // Organisation des sections
        this.add(this.indicateurs, BorderLayout.NORTH);
        this.add(boutongauche, BorderLayout.WEST);
        this.add(miniAffichageClient, BorderLayout.CENTER);
        this.add(boutondroit, BorderLayout.EAST);

    }

    /** Getters */

    /**
     * Renvoie l'affichage du client.
     *
     * @return l'affichage du client de type 'miniAffichageClient'
     * */
    public miniAffichageClient getMiniAffichageClient(){
        return this.miniAffichageClient;
    }

    /**
     * Renvoie l'état actuel de l'application
     *
     * @return etat l'état actuel de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /** Setter */

    /**
     * Définit l'état de l'application.
     *
     * @param etat l'état à définir de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /** Affichage */

    /**
     * Méthode utilisée pour afficher la liste des différents clients en dessinant
     * un bord noir sur un fond bleu clair.
     *
     * @param g  l'objet Graphics utilisé pour dessiner de type 'Graphics'
     * */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Création de la bordure noire de 1 pixel d'épaisseur
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        // Application de la bordure à notre JPanel
        this.setBorder(blackline);
        // Définition de la couleur de fond à bleu clair
        this.setBackground(new Color(119, 181, 254));
    }
}

