package Vue;

import Modele.Client;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Clients {

    /* Attributs */
    ArrayList<Client>listeClients;
    miniAffichageClient miniAffichageClient;

    /* Constructeur */
    public Clients(miniAffichageClient miniAffichageClient){

        this.miniAffichageClient = miniAffichageClient;
        /* On initialise l'affichage et la liste des clients vide */
        this.listeClients = new ArrayList<Client>();
        this.addClient(new Client(0));
        this.addClient(new Client (1));
        for (Client client : listeClients) {
            client.start();
        }
    }

    /* Getters */
    public ArrayList<Client>getListeClients(){
        return this.listeClients;
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
        /* On initialise Le client en cours a dessiner */
        Client client = this.miniAffichageClient.getEtat().getClients().listeClients.get(this.miniAffichageClient.getEtat().getClient_en_cours());
        if (client.getIdentifiant() == 0 ) {
            // On choisit l'image selon l'état du client
            String path_name = "Vue/client" + (client.getEtat() % 12 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 12 images pour 12 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, 0, 0, 300, 300,null);
        }
        else {
            // On choisit l'image selon l'état du client
            String path_name = "Vue/angrybirds" + (client.getEtat() % 12 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 12 images pour 12 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(imageclient, 0, 0, 300, 300,null);
        }
    }
}

