package Vue;

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
/**
 * Classe AffichageCommande hérite de la classe 'JPanel' de Swing.
 * Elle est responsable de l'affichage des commandes au bas à droite
 * de l'écran de l'utilisateur.
 *
 * */
public class AffichageCommande extends JPanel {

    /** Constantes Fenêtre */

    /* Largeur Fenetre 426 */
    public static final int LARGEUR = (int) (0.3* Etat.WIDTH);
    /* Hauteur Fenetre 440*/
    public static final int HAUTEUR = (int) (0.55*Etat.HEIGHT);

    /** Variable */

    /* Variable Etat que notre classe retranscrira en affichage */
    private Etat etat;

    /**
     * Constructeur
     * Définit les dimensions de notre JPanel et gère l'état de notre application.
     *
     * @param etat  l'état de notre application de type 'Etat'
     * */
    public AffichageCommande(Etat etat){
        this.setEtat(etat);
        // On définit les dimensions de notre JPanel
        setPreferredSize(new Dimension(LARGEUR,HAUTEUR));
    }

    /** Affichage */

    /**
     * Méthode qui permet de dessiner l'affichage des commandes sur un ticket
     * en effaçant le ticket précédent.
     *
     * @param g  l'objet Graphics utilisé pour dessiner de type 'Graphics'
     * */
    @Override
    public void paint(Graphics g) {
        // Effacer les "dessins" précédents
        super.paint(g);

        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        this.setBorder(blackline);
        this.setBackground(Color.white);

        // Création de la police d'affichage du ticket
        Font receiptFont = null;
        try {
            //creation de la police d'affichage, taille 25
            receiptFont = Font.createFont(Font.TRUETYPE_FONT, new File("ressources/fonts/receipt.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Enregistrement de la police de caractères
            ge.registerFont(receiptFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        this.setFont(receiptFont);

        // Affichage de la commande sur le ticket si des clients existent
        if(this.etat.getClients().getListeClients().size() != 0) {
            this.drawDecor(g);
            g.drawString("TICKET "+this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getIdentifiant(),170,80);
            g.drawLine(87,90,350,90);
            this.afficheCommande(this.etat.getClients().getListeClients().get(this.etat.getClient_en_cours()).getCommande(), g);
            g.drawLine(87,310,350,310);

        } // Sinon on affiche un écran d'attente
        else {
            g.drawString("PAS DE COMMANDE...",125,200);
        }
    }

    /**
     * Méthode qui dessine l'arrière-plan du ticket
     *
     * @param g  l'objet Graphics utilisé pour dessiner de type 'Graphics'
     * */
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

    /**
     * Méthode qui affiche la commande sur le ticket en récupérant les produits
     * et les prix associés à la commande du client
     *
     * @param C  la commande à afficher de type 'Commande'
     * @param g  l'objet graphique sur lequel dessiner de type 'Graphics'
     * */
    public void afficheCommande(Commande C,Graphics g) {
        // On récupère les produits de la commande
        ArrayList<Produit> liste = C.getProduits();
        // On récupère les prix des produits
        HashMap<String,Integer> listePrix = etat.getPrixProduits();
        // Boucle foreach pour chaque produit de la commande
        Integer prix;
        for(int i = 0; i < liste.size(); i++) {
            // On affiche sa quantité
            g.drawString(String.valueOf(liste.get(i).getQuantite())+" X",110,150+35*i);
            // On affiche son nom
            g.drawString(liste.get(i).getNom(),170,150+35*i);
            // On affiche son prix
            prix = listePrix.get(liste.get(i).getNom()) * liste.get(i).getQuantite();
            g.drawString(String.valueOf(prix),300,150+35*i);

        }
        // On affiche le total
        g.drawString("TOTAL : "+ String.valueOf(C.getPrix()),170,350);
    }

    /**
     * Getter
     * Renvoie l'état actuel de l'application
     *
     * @return etat l'état actuel de type 'Etat'
     * */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter
     * Définit l'état de l'application.
     *
     * @param etat l'état à définir de type 'Etat'
     * */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }


}
