package Modele;

import Vue.AffichageClient;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class ListeClients extends Thread{

    /* Attributs */
    ArrayList<Client>listeClients;
    AffichageClient affichageClient;

    /* Constructeur */
    public ListeClients(AffichageClient affichageClient){
        this.setAffichageClient(affichageClient);
    }

    /* Getters */
    public ArrayList<Client>getListeClients(){
        return this.listeClients;
    }
    public AffichageClient getAffichageClient(){
        return this.affichageClient;
    }

    /* Setters */
    public void setAffichageClient(AffichageClient affichageClient){
        this.affichageClient = affichageClient;
    }
    public void setListeClients(){
        this.listeClients = new ArrayList<Client>();
    }

    /* Méthode */

    /* Méthode addClient qui rajoute le client a notre liste de client */
    public void addClient(Client client){
        this.listeClients.add(client);

    }

    /* Méthode genereClients qui génère des clients */
    public void removeClient(Client client){
        this.listeClients.remove(client);
    }

    public void dessiner(Graphics g) throws IOException {
        for(Client client : listeClients) {
            /* Si l'un des oiseau n'est plus visible */
            if (client.getTraitementCommande() == true) {
                /* Je le supprime*/
                this.removeClient(client);
            }
            /*Sinon je l'affiche selon son état : 0,1,2,3,4,5,6 ou 7*/
            if ( client.getEtat() % 8 == 0) {
                File file = new File("vue/client0.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);

            }
            else if ( client.getEtat() % 8 == 1) {
                File file = new File("vue/client1.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else if ( client.getEtat() % 8 == 2) {
                File file = new File("vue/client2.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else if ( client.getEtat() % 8 == 3) {
                File file = new File("vue/client3.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else if ( client.getEtat() % 8 == 4) {
                File file = new File("vue/client4.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else if ( client.getEtat() % 8 == 5) {
                File file = new File("vue/client5.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else if ( client.getEtat() % 8 == 6) {
                File file = new File("vue/client6.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
            else  {
                File file = new File("vue/client7.png");
                Image image = ImageIO.read(file);
                g.drawImage(image, 0, 0, null);
            }
        }
    }
}
