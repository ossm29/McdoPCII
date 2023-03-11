package Vue;

import Vue.AffichageClient;
import Vue.AffichageCommande;
import Vue.AffichageProduits;

import javax.swing.*;
import java.awt.*;

public class AffichageDroite extends JPanel {

    private AffichageClient affichageClient;
    private AffichageCommande affichageCommandes;

    public AffichageDroite(AffichageClient affichageClient, AffichageCommande affichageCommandes) {
        this.affichageClient = affichageClient;
        this.affichageCommandes = affichageCommandes;
        this.setPreferredSize(new Dimension(400, 800));
        this.add(this.affichageClient, BorderLayout.NORTH);
        this.add(this.affichageCommandes, BorderLayout.SOUTH);
    }

    public AffichageClient getAffichgeClient(){
        return this.affichageClient;
    }
}
