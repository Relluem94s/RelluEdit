package de.relluem94.relluedit.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import de.relluem94.relluedit.functions.Funktionen;

public class PluginManager extends Funktionen {

    de.relluem94.relluedit.rellu main;

    public PluginManager(de.relluem94.relluedit.rellu instance) {
        super(instance);
        main = instance;
    }

    public String Pfad = System.getProperty("user.home");

    public void checkPluginDir() {
        File PluginDir = new File(Pfad + "/RelluEdit/Plugins");
        if (PluginDir.exists()) {

        } else {
            PluginDir.mkdirs();
        }
    }

    @SuppressWarnings("unused")
    public void loadPlugin(String s) {
        File PluginDir = new File(Pfad + "/RelluEdit/Plugins");
        File f = new File(PluginDir + "/" + s);
        if (f.exists() == true) {
            if (f.canExecute() == true) {
                Commands.Output("Plugin wird ausgefuehrt");
                Process proc;
                try {
                    proc = Runtime.getRuntime().exec("java -jar " + f);
                    InputStream in = proc.getInputStream();
                    InputStream err = proc.getErrorStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                Commands.ErrorOutput("Plugin kann nicht ausgefuehrt werden");
            }
        } else {
            Commands.ErrorOutput("Plugin wurde nicht gefunden");
            Commands.ErrorOutput(f.getAbsolutePath() + "");
        }
    }

}
