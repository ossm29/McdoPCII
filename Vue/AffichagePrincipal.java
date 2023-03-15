package Vue;

import Modele.Etat;

import javax.swing.*;
import java.awt.*;

public class AffichagePrincipal extends JPanel {

    private AffichageGauche affichageGauche;
    private AffichageDroite affichageDroite;

    public AffichagePrincipal(AffichageGauche affichageGauche, AffichageDroite affichageDroite){
        this.affichageGauche = affichageGauche;
        this.affichageDroite = affichageDroite;
        this.setPreferredSize(new Dimension(1420, 810));
        this.add(this.affichageGauche, BorderLayout.EAST);
        this.add(this.affichageDroite, BorderLayout.WEST);
    }

    public AffichageGauche getAffichageGauche(){
        return this.affichageGauche;
    }
    public AffichageDroite getAffichageDroite(){ return this.affichageDroite;  }

    @Override
    public void paintComponent(Graphics g) {
        setBackground(Color.WHITE);
        super.paintComponent(g);
    }
}
