package Vue;

import Modele.Client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/** TODO : interrompre le thread client lorsqu'on le remove et pas seulement le supprimer de la liste */
public class Clients {

    /** Attributs **/
    ArrayList<Client>listeClients;
    miniAffichageClient miniAffichageClient;

    /** Constructeur **/
    public Clients(miniAffichageClient miniAffichageClient){

        this.miniAffichageClient = miniAffichageClient;

        /* On initialise l'affichage et la liste des clients vide */
        this.listeClients = new ArrayList<Client>();
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
        client.interrupt();
    }

    public void removeClientById(int id) {
        ArrayList<Client>liste = listeClients;
        for (Client client: liste){
            if (client.getIdImage() == id){
                this.listeClients.remove(client);
            }
        }
    }

    public void dessiner(Graphics g) throws IOException {
        /* Si la file n'est pas vide */
        if (!this.miniAffichageClient.getEtat().fileVide()) {

            // On définit le client à afficher
            if (this.miniAffichageClient.getEtat().getClient_en_cours()<this.miniAffichageClient.getEtat().getClients().getListeClients().size()) {


                Client client = this.miniAffichageClient.getEtat().getClients().getListeClients().get(this.miniAffichageClient.getEtat().getClient_en_cours());

                // Si le timer < 0 on supprime le client
                if (client.getTimer() < 0) {
                    this.miniAffichageClient.getEtat().getClients().removeClient(client);
                }

                /* Affichage ecurueil */
                if (client.getIdImage() == 0) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/client" + (client.getEtatclient() % 12 + 1) + ".png";
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
                else if (client.getIdImage() == 1) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/angrybirds" + (client.getEtatclient() % 12 + 1) + ".png";
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

                // Affichage humain
                else if (client.getIdImage() == 2) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/humain" + (client.getEtatclient() % 14 + 1) + ".png";
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
}

