package Vue;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.Border;

import Modele.Etat;
import Vue.VueServeur;

import java.awt.* ;


/* Ma classe Affichage qui définira la vue, dans notre cas elle traduire les données de la Classe Etat en affichage pour l'utilisateur  */
public class AffichageServeur extends JPanel {

    /* Constantes Fenetre*/
    public static final int LARGEUR = (int) (0.7*Etat.WIDTH);                              	/* Largeur Fenetre */
    public static final int HAUTEUR = (int) (0.75*Etat.HEIGHT);                              	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */
    private VueServeur vueServeur;

    /* Constructeurs */
    public AffichageServeur(Etat etat){
        /* On définit les dimensions de notre JPanel */
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));

        /* Les attributs */
        this.setEtat(etat);
        this.vueServeur = new VueServeur();


    }

    /** fonction de dessin du score et des clients insatisfaits
     * @param g objet graphique
     */
    public void drawStats(Graphics g) {
        /* on dessine un carré blanc à l'endroit où on écrira le score*/
        g.clearRect(LARGEUR/2-90/2,0,290,30);
        /* on affiche le score (converti en chaîne de caractères) */

        g.drawString("SCORE : "+Integer.toString(this.etat.getScore()),LARGEUR/2-20,15);
        g.setColor(Color.red);
        g.drawString(" | Clients insatisfaits : "+Integer.toString(this.etat.getClients_insatisfaits()),LARGEUR/2+40,15);

    }
    
    /*Getter Etat*/
	public Etat getEtat() {
		return etat;
	}
	
	/*Setter etat*/
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        /* Arrière Plan et Bordures */
        setBackground((new Color(48, 78, 56)));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);

        /* Score*/
        this.drawStats(g);
        /* Affichage Serveur */
        //this.vueServeur.dessiner(g);
    }
}