package Vue;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import Modele.Etat;
import java.awt.* ;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;


/* Ma classe Affichage qui définira la vue, dans notre cas elle traduire les données de la Classe Etat en affichage pour l'utilisateur  */
public class AffichageServeur extends JPanel implements observer{

    /* Constantes Fenetre*/
    public static final int LARGEUR = 1000;                              	/* Largeur Fenetre */
    public static final int HAUTEUR = 600;                              	/* Hauteur Fenetre */
    
    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageServeur(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
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
        setBackground((new Color(255, 110, 65)));
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);



    }
}