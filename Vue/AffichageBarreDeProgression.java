package Vue;

import javax.swing.*;
import java.awt.*;

public class AffichageBarreDeProgression extends JProgressBar {


    public AffichageBarreDeProgression() {

        this.setPreferredSize(new Dimension(320, 35));
        this.setMinimum(0);
        this.setMaximum(35);
        this.setStringPainted(true);
        //texte sur la barre
        this.setString("PATIENCE");

    }
}
