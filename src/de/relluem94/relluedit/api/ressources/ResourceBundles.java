package de.relluem94.relluedit.api.ressources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles extends Images {

    public static ResourceBundle getRessourceBundle(String s) {
        ResourceBundle bundle = ResourceBundle.getBundle(s);

        return bundle;
    }

    public static ResourceBundle changeLocale(String lang) {
        Locale germanLocale = new Locale("de", "DE");
        Locale englishLocale = new Locale("en", "US");

        if (lang.equalsIgnoreCase("german")) {
            ResourceBundle bundle = ResourceBundle.getBundle("rellu", germanLocale);
            return bundle;
        } else if (lang.equalsIgnoreCase("english")) {
            ResourceBundle bundle = ResourceBundle.getBundle("rellu", englishLocale);
            return bundle;
        } else {
            ResourceBundle bundle = ResourceBundle.getBundle("rellu", englishLocale);
            return bundle;
        }
    }

    public static String setLanguage() {
        ResourceBundle options = getRessourceBundle("rellu_options");
        return options.getString("o_language");
    }

}
