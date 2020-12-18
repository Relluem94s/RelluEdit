package de.relluem94.relluedit.api.ressources;

import java.awt.Color;
import java.util.ResourceBundle;

public class Colors extends ResourceBundles {

    public Color getColor(String s) {
        ResourceBundle options = getRessourceBundle("rellu_options");
        String co = options.getString(s);
        String[] col = co.split(", ");
        int r = Integer.parseInt(col[0]);
        int g = Integer.parseInt(col[1]);
        int b = Integer.parseInt(col[2]);
        int a = Integer.parseInt(col[3]);
        // System.out.println(r + ", " + g  + ", " + b + ", " + a);
        return new Color(r, g, b, a);
    }

}
