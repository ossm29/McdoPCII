package Vue;

import Modele.Client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/** TODO : interrompre le thread client lorsqu'on le remove et pas seulement le supprimer de la liste */

/**
 * Classe Clients représente la liste de clients qui peut être affichée
 * dans l'application.
 *
 * @version 1.0
 * */
public class Clients {

    /** Attributs **/

    /* Liste de clients */
    ArrayList<Client>listeClients;
    /* L'affichage des clients */
    miniAffichageClient miniAffichageClient;

    /**
     * Constructeur
     * Définit l'affichage des clients et initialise la liste des clients.
     *
     * @param miniAffichageClient  l'affichage à utiliser pour afficher les clients
     *                             de type 'miniAffichageClient'
     * **/
    public Clients(miniAffichageClient miniAffichageClient){
        // Définition de l'affichage des clients
        this.miniAffichageClient = miniAffichageClient;

        // Initialisation dela liste des clients a vide
        this.listeClients = new ArrayList<Client>();
    }

    /** Getters **/

    /**
     * Retourne la liste des clients.
     *
     * @return la liste des clients de type 'ArrayList<Client>'
     * */
    public ArrayList<Client>getListeClients(){
        return this.listeClients;
    }

    /**
     * Retourne l'affichage associé aux clients.
     *
     * @return l'affichage pour les clients de type 'miniAffichageClient'
     * */
    public miniAffichageClient getMiniAffichageClient(){
        return this.miniAffichageClient;
    }

    /**
     * Setter
     * Initialise la liste des clients à vide.
     *
     * */
    public void setListeClients(){
        this.listeClients = new ArrayList<Client>();
    }

    /** METHODES **/

    /**
     * Méthode qui rajoute un client précis à notre liste de client.
     *
     * @param client  le client à ajouter à la liste de clients
     *                de type 'Client'
     * */
    public void addClient(Client client){
        this.listeClients.add(client);
    }

    /**
     * Méthode qui supprime un client précis de la liste de clients
     * et interrompt son thread.
     *
     * @param client  le client a supprimer de la liste de clients
     *                de type 'Client'
     * */
    public void removeClient(Client client){
        this.listeClients.remove(client);
        client.interrupt();
    }

    /**
     * Méthode qui supprime un client de la liste de clients pas son identifiant.
     *
     * @param id  l'identifiant du client à supprimer de la liste de clients
     *            de type 'int'
     * */
    public void removeClientById(int id) {
        ArrayList<Client>liste = listeClients;
        for (Client client: liste){
            if (client.getIdImage() == id){
                this.listeClients.remove(client);
            }
        }
    }

    /**
     * Méthode qui dessine les clients dans une interface graphique.
     *
     * @param g  l'objet graphique de l'interface de type 'Graphics'
     * @throws IOException si une erreur survient lors de la lecture d'une image.
     * */
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

