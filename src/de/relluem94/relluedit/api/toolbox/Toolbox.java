package de.relluem94.relluedit.api.toolbox;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class Toolbox extends Menus {

    public String ArryToString(String[] m) {
        String message = "";
        String[] arrayOfString1;
        int j = (arrayOfString1 = m).length;
        for (int i = 0; i < j; i++) {
            String arg = arrayOfString1[i];

            message = message + arg + " ";
        }
        return message;
    }

    public static String static_ArryToString(String[] m) {
        String message = "";
        String[] arrayOfString1;
        int j = (arrayOfString1 = m).length;
        for (int i = 0; i < j; i++) {
            String arg = arrayOfString1[i];

            message = message + arg + " ";
        }
        return message;
    }

    public static void writeFile(File file, String content) {
        try {
            FileUtils.writeStringToFile(file, content);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static String readFile(String path, Charset encoding) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, encoding);
        } catch (IOException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public void setText(String text) {
        content = text;
        textPane.setText(content);
    }

    public String getText() {
        return textPane.getText();
    }

}
