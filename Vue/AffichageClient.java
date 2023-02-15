package Vue;

import Controleur.Control;
import Controleur.ControlClientClicDroit;
import Controleur.ControlClientClicGauche;
import Modele.Etat;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicProgressBarUI;
import javax.swing.plaf.synth.SynthProgressBarUI;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AffichageClient extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);                              	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.45*Etat.HEIGHT);                              	/* Hauteur Fenetre */

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private miniAffichageClient miniAffichageClient;
    private AffichageBarreDeProgression jauge;

    /* Constructeurs */
    public AffichageClient(Etat etat){
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */

        this.setEtat(etat);
        this.miniAffichageClient = new miniAffichageClient(this.etat);


        /* Boutton Gauche et Droit*/
        JButton boutongauche = new JButton("<");
        JButton boutondroit = new JButton(">");
        /* Dimensions Boutons */
        boutongauche.setPreferredSize(new Dimension(40, 230));
        boutondroit.setPreferredSize(new Dimension(40,230));
        /* Decoration boutons */
        Font police = boutongauche.getFont(); // récupère la police actuelle
        Font nouvellePolice = new Font(police.getName(), police.getStyle(), police.getSize()-2);
        boutongauche.setFont(nouvellePolice);
        boutondroit.setFont(nouvellePolice);

        boutongauche.setBackground(Color.white);
        boutondroit.setBackground(Color.white);

        /* On ajoute les controleurs */
        boutongauche.addMouseListener(new ControlClientClicGauche(this.etat, this.miniAffichageClient));
        boutondroit.addMouseListener((new ControlClientClicDroit(this.etat, this.miniAffichageClient)));

        /* Barre de progression */
        this.jauge = new AffichageBarreDeProgression();

        /* On organise nos sections */
        this.add(jauge, BorderLayout.NORTH);
        this.add(boutongauche, BorderLayout.WEST);
        this.add(miniAffichageClient, BorderLayout.CENTER);
        this.add(boutondroit, BorderLayout.EAST);


    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    /* Affichage */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        // Bordure
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        // Arrière plan
        this.setBackground(Color.yellow);
        // Mettre a jour la barre de progression
        this.updateProgressBar();
        System.out.println("joueurencours"+this.etat.getClient_en_cours());
        System.out.println("joueursuivant"+(this.etat.getClient_en_cours()+1));
    }

    public void updateProgressBar() {
        //écris le numéro du client sur la barre
        //this.jauge.setFont();
        this.jauge.setString("CLIENT N°"+this.etat.getClient_en_cours());
        // La valeur de la barre de progression reflètera le timer du client
        if (!this.etat.fileVide()) {
            this.jauge.setValue((int) this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getTimer());
            // Si il timer est supèrieur à 25 secondes
            if (this.jauge.getValue() > 25) {
                // Colorier en vert
                this.jauge.setForeground(Color.GREEN);
            }
            // Sinon si il est supèrieur à 10
            else if (this.jauge.getValue() > 10) {
                // Colorier en jaune
                this.jauge.setForeground(Color.yellow);
            }
            // Sinon
            else {
                // Colorier en rouge car il reste moins de 10 secondes
                this.jauge.setForeground(Color.RED);
            }
        }
    }
}
