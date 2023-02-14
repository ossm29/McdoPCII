package Vue;

import Modele.Client;
import Vue.AffichageClient;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VueClients {

    /* Attributs */
    ArrayList<Client>listeClients;

    /* Constructeur */
    public VueClients(AffichageClient affichageClient){

        /* On initialise l'affichage et la liste des clients vide */
        this.listeClients = new ArrayList<Client>();
        this.addClient(new Client(0));
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
        for(Client client : listeClients) {
            // On choisit l'image selon l'état du client
            String path_name = "Vue/Client"+ (client.getEtat()%12 + 1) + ".png";
            File fileClient = new File(path_name);
            // On aura 12 images pour 12 états différents
            BufferedImage imageclient = null;
            // On récupère ces images
            try {
                imageclient = ImageIO.read(fileClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // On affiche l'image
            g.drawImage(imageclient, 25, 25, 350, 300,null);
        }
    }
}

