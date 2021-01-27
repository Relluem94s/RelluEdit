package de.relluem94.relluedit.api.toolbox;

public class Toolbox extends Menus {
    public void setText(String text) {
        content = text;
        textPane.setText(content);
    }

    public String getText() {
        return textPane.getText();
    }
}
