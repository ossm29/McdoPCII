package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AffichageIndicateurs extends JPanel{

    Etat etat;
    AffichageColere affichageColere;
    AffichageBarreDeProgression affichageBarreDeProgression;



    public AffichageIndicateurs(Etat etat){

        this.setPreferredSize(new Dimension(390, 45));

        this.etat = etat;
        this.affichageBarreDeProgression = new AffichageBarreDeProgression();
        this.affichageColere = new AffichageColere(this.etat) ;

        this.add(affichageBarreDeProgression, BorderLayout.EAST);
        this.add(affichageColere,BorderLayout.WEST);

    }

    public void paint(Graphics g){
        this.setBackground(new Color(119, 181, 254));
        super.paint(g);
        this.updateProgressBar();
    }

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
    }
}
