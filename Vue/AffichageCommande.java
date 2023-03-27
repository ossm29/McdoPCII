package Vue;

import Modele.Client;
import Modele.Commande;
import Modele.Etat;
import Modele.Produit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/** Classe qui gère l'affichage des commandes en bas à droite de l'écran*/

public class AffichageCommande extends JPanel {
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);       	/* Largeur Fenetre 426 */
    public static final int HAUTEUR = (int) (0.55*Etat.HEIGHT);       	/* Hauteur Fenetre 440*/

    /* Variables */
    private Etat etat;                                                  	/* Variable Etat que notre classe retranscrira en affichage */

    /* Constructeurs */
    public AffichageCommande(Etat etat){
        this.setEtat(etat);
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));               	/* On définit les dimensions de notre JPanel */
    }

    /* Affichage */
    @Override
    public void paint(Graphics g) {
        super.paint(g);                                                     /* Effacer les précédents "dessin" */

        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground(Color.white);



        //Police d'affichage ticket
        Font receiptFont = null;
        try {
            //creation de la police d'affichage, taille 25
            receiptFont = Font.createFont(Font.TRUETYPE_FONT, new File("ressources/fonts/receipt.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(receiptFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.setFont(receiptFont);

        //Si il y a des clients, on affiche leur commande sur un ticket
        if(this.etat.getClients().getListeClients().size() != 0) {
            this.drawDecor(g);
            g.drawString("TICKET "+this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getIdentifiant(),170,80);
            g.drawLine(87,90,350,90);
            this.afficheCommande(this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getCommande(), g);
            g.drawLine(87,310,350,310);

        } //sinon on affiche un écran d'attente
        else {
            g.drawString("PAS DE COMMANDE...",125,200);
        }
    }

    public void drawDecor(Graphics g) {
        File backgroundimage = new File("ressources/ticket.png");
        // On aura 1 image pour l'arriere-plan
        BufferedImage image = null;
        // On récupère l'image
        try {
            image = ImageIO.read(backgroundimage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // On affiche l'image
        g.drawImage(image, 0, 0, 436, 436,null);
    }

    /** Méthode qui affiche la commande sur le ticket */
    public void afficheCommande(Commande C,Graphics g) {
        //On récupère les produits de la commande
        ArrayList<Produit> liste = C.getProduits();
        //On récupère les prix des produits
        HashMap<String,Integer> listePrix = etat.getPrixProduits();
        //Boucle foreach pour chaque produit de la commande
        Integer prix;
        Integer total = 0;
        for(int i = 0; i < liste.size(); i++) {
            //On affiche sa quantité
            g.drawString(String.valueOf(liste.get(i).getQuantite())+" X",110,150+35*i);
            //On affiche son nom
            g.drawString(liste.get(i).getNom(),170,150+35*i);
            //On affiche son prix
            prix = listePrix.get(liste.get(i).getNom()) * liste.get(i).getQuantite();
            total += prix;
            g.drawString(String.valueOf(prix),300,150+35*i);

        }
        //On affiche le total
        g.drawString("TOTAL : "+ String.valueOf(total),170,350);
    }

    /*Getter Etat*/
    public Etat getEtat() {
        return etat;
    }

    /*Setter etat*/
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


}
