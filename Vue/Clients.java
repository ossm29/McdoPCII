package Vue;

import Modele.Client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Clients {

    /** Attributs **/
    ArrayList<Client>listeClients;
    miniAffichageClient miniAffichageClient;

    /** Constructeur **/
    public Clients(miniAffichageClient miniAffichageClient){

        this.miniAffichageClient = miniAffichageClient;

        /* On initialise l'affichage et la liste des clients vide */
        this.listeClients = new ArrayList<Client>();
        this.addClient(new Client());
        this.addClient(new Client ());

        /* On lance les threads */
        /*for (Client client : listeClients){
            client.start();
        }*/
    }

    /** Getters **/
    public ArrayList<Client>getListeClients(){
        return this.listeClients;
    }
    public miniAffichageClient getMiniAffichageClient(){
        return this.miniAffichageClient;
    }

    public void setListeClients(){
        this.listeClients = new ArrayList<Client>();
    }

    /** METHODES **/

    /* Méthode addClient qui rajoute le client a notre liste de client */
    public void addClient(Client client){
        this.listeClients.add(client);

    }

    /* Méthode genereClients qui génère des clients */
    public void removeClient(Client client){
        this.listeClients.remove(client);
    }

    public void dessiner(Graphics g) throws IOException {
            /* Si la file n'est pas vide */
            if (!this.miniAffichageClient.getEtat().fileVide()) {

                // On définit le client à afficher
                Client client = this.miniAffichageClient.getEtat().getClients().getListeClients().get(this.miniAffichageClient.getEtat().getClient_en_cours());

                // TODO IL FAUDRA SUPPRIMER LES CLIENTS AVEC UN TIMER < 0
                /*if (client.getTimer() < 0) {
                    this.miniAffichageClient.getEtat().getClients().removeClient(client);
                }*/

                /* Affichage ecurueil */
                if (client.getIdentifiant() == 0) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/client" + (client.getEtat() % 12 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 12 images pour 12 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 0, 0, 300, 300, null);
                }

                // Affichage angrybird
                else {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/angrybirds" + (client.getEtat() % 12 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 12 images pour 12 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 0, 0, 300, 300, null);
                }
            }
    }
}

