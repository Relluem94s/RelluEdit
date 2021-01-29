package de.relluem94.relluedit.api.ressources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundles extends Images {

    public static ResourceBundle getRessourceBundle(String s) {
        return ResourceBundle.getBundle(s);
    }

    public static ResourceBundle changeLocale(String lang) {
        switch (lang) {
            case "german":
                return ResourceBundle.getBundle("rellu", new Locale("de", "DE"));
            default:
                return ResourceBundle.getBundle("rellu", new Locale("en", "US"));
        }
    }

    public static String setLanguage() {
        return getRessourceBundle("rellu_options").getString("o_language");
    }

    public static String getVersion() {
        return getRessourceBundle("app").getString("version");
    }

}
