package de.relluem94.relluedit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import de.relluem94.relluedit.api.PluginManager;
import de.relluem94.relluedit.api.toolbox.Toolbox;
import de.relluem94.relluedit.functions.SplashScreen;
import de.relluem94.relluedit.functions.Gui;

public class RelluEdit extends Toolbox {

    public static de.relluem94.relluedit.RelluEdit main;

    public RelluEdit(de.relluem94.relluedit.RelluEdit instance) {
        main = instance;
    }

    public static void checkTempDir() {
        File PluginDir = new File(Pfad + "/RelluEdit/Temp");
        if (!PluginDir.exists()) {
            PluginDir.mkdirs();
        }
    }

    public static void checkBinDir() {
        File PluginDir = new File(Pfad + "/RelluEdit/Bin");
        if (!PluginDir.exists()) {
            PluginDir.mkdirs();
        }
    }

    public static void checkDirs() {
        PluginManager pm = new PluginManager(main);
        pm.checkPluginDir();

        checkBinDir();
        checkTempDir();
    }

    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(getLookAndFeel());

        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }
    }

    public static String getLookAndFeel() {
        ResourceBundle options = getRessourceBundle("rellu_options");
        return options.getString("o_rellu_lookandfeel");
    }

    public static boolean existOptions() {
        File file = new File(Pfad + "/RelluEdit/" + optionsname);
        if (file.exists() == true) {
            return true;
        } else {
            return false;
        }
    }

    public static void createOptions() {
        PrintWriter writer;
        try {
            writer = new PrintWriter(Pfad + "/RelluEdit/" + optionsname, "UTF-8");
            writer.println("#Colors:");
            writer.println("o_color_rellu_orange = 243, 125, 0, 255");
            writer.println("o_color_rellu_grey = 121, 116, 114, 255");
            writer.println("o_color_rellu_red = 227, 59, 46, 255");
            writer.println("#################################################################################");
            writer.println("#English and German");
            writer.println("o_language = German");
            writer.println("#################################################################################");
            writer.println("#Look And Feel");
            writer.println("o_rellu_lookandfeel = com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            writer.println("#################################################################################");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        SplashScreen sc = new SplashScreen();
        sc.setVisible(true);

        Thread.sleep(9980);
        sc.dispose();

        if (existOptions() == false) {
            createOptions();
        }
        checkDirs();
        setLookAndFeel();

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                //dann muss das Plugin abgerufen werden
                Gui GuI = new Gui(main);
                GuI.initGUI();

            }
        });
    }

}
