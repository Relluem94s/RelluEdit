package de.relluem94.relluedit.api.ressources;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

public class Images {

    //TODO gangbar machen fuer den Plugin Pfad und intern fuer die rellu images
    public static ImageIcon getImageIcon(String path) {
        return new ImageIcon(path);
    }

    public static Image getImage(String path) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage(path);
        return img;
        //return new ImageIcon(this.getClass().getResource(path)).getImage();
    }

}
