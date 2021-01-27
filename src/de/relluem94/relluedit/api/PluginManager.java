package de.relluem94.relluedit.api;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import de.relluem94.relluedit.functions.Funktionen;
import de.relluem94.rellulib.utils.LogUtils;

public class PluginManager extends Funktionen {

    de.relluem94.relluedit.RelluEdit main;

    public PluginManager(de.relluem94.relluedit.RelluEdit instance) {
        super(instance);
        main = instance;
    }

    public String path = System.getProperty("user.home");

    public void checkPluginDir() {
        File pluginDir = new File(path + "/RelluEdit/Plugins");
        if (pluginDir.exists()) {

        } else {
            pluginDir.mkdirs();
        }
    }

    @SuppressWarnings("unused")
    public void loadPlugin(String s) {
        File PluginDir = new File(path + "/RelluEdit/Plugins");
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
                    LogUtils.error(e.getMessage());
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
