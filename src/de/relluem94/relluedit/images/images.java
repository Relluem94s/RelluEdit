package de.relluem94.relluedit.images;

import java.net.URL;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

import de.relluem94.relluedit.RelluEdit;

public class images {

    public static ImageIcon getImageIcon(String path) {
        return new ImageIcon(getImage(path));
    }

    public static Image getImage(String path) {
        URL url = RelluEdit.class.getResource("/" + path);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage(url);

        return img;
    }

}
