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


                // Affichage Among us Violet
                if (client.getIdImage() == 0) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/amongus/violet" + (client.getEtatclient() % 4 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 4 images pour 4 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 10, 10, 280, 280, null);
                }

                // Affichage Among us Rouge
                else if (client.getIdImage() == 1) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/amongus/red" + (client.getEtatclient() % 9 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 9 images pour 9 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 20, 0, 290, 290, null);
                }

                // Affichage Among us Vert
                else if (client.getIdImage() == 2) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/amongus/green" + (client.getEtatclient() % 4 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 4 images pour 4 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 10, 20, 250, 250, null);
                }

                // Affichage Among us Jaune
                else if (client.getIdImage() == 3) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/amongus/yellow" + (client.getEtatclient() % 6 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 6 images pour 6 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 20, 20, 260, 260, null);
                }

                // Affichage Among us Cyan
                else if (client.getIdImage() == 4) {
                    // On choisit l'image selon l'état du client
                    String path_name = "ressources/amongus/cyan" + (client.getEtatclient() % 18 + 1) + ".png";
                    File fileClient = new File(path_name);
                    // On aura 18 images pour 18 états différents
                    BufferedImage imageclient = null;
                    // On récupère ces images
                    try {
                        imageclient = ImageIO.read(fileClient);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    g.drawImage(imageclient, 20, 20, 260, 260, null);
                }
            }
        }
    }

    public void dessiner2(Graphics g, int x, int y, Client client) throws IOException {
        // Affichage Among us Violet
        if (client.getIdImage() == 0) {
            // On choisit l'image selon l'état du client
            String path_name = "ressources/amongus/violetw" + (client.getEtatclient() % 18 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 4 images pour 4 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, x, y, 150, 150, null);
        }

        // Affichage Among us Rouge
        else if (client.getIdImage() == 1) {
            // On choisit l'image selon l'état du client
            String path_name = "ressources/amongus/redw" + (client.getEtatclient() % 16 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 9 images pour 9 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, x, y, 150, 150, null);
        }

        // Affichage Among us Vert
        else if (client.getIdImage() == 2) {
            // On choisit l'image selon l'état du client
            String path_name = "ressources/amongus/greenw" + (client.getEtatclient() % 18 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 4 images pour 4 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, x, y, 150, 150, null);
        }

        // Affichage Among us Jaune
        else if (client.getIdImage() == 3) {
            // On choisit l'image selon l'état du client
            String path_name = "ressources/amongus/yelloww" + (client.getEtatclient() % 18 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 6 images pour 6 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, x, y, 150, 150, null);
        }

        // Affichage Among us Cyan
        else if (client.getIdImage() == 4) {
            // On choisit l'image selon l'état du client
            String path_name = "ressources/amongus/cyan" + (client.getEtatclient() % 18 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 18 images pour 18 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, x, y, 150, 150, null);
        }
    }
}

