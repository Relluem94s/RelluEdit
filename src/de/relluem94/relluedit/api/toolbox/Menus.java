package de.relluem94.relluedit.api.toolbox;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

public class Menus extends MenuItems {

    public void makeMenu(JMenu menu) {
        makeListMenu(menu);
        menu.removeAll();

        for (int i = 0; i < ListMenu.size(); i++) {
            if (ListMenu.get(i) == null) {
                menu.addSeparator();
            } else {
                menu.add(ListMenu.get(i));
            }
        }
    }

    public void addMenuItems() {

        makeMenu(fileMenu);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        makeMenu(editMenu);
        editMenu.setMnemonic(KeyEvent.VK_E);

        makeMenu(aboutMenu);
        aboutMenu.setMnemonic(KeyEvent.VK_A);
    }

    public void makeListMenu(JMenu menu) {
        if (menu == fileMenu) {
            ListMenu.clear();
            ListMenu.put(0, open());
            ListMenu.put(1, null);
            ListMenu.put(2, neu());
            ListMenu.put(3, null);
            ListMenu.put(4, save());
            ListMenu.put(5, saveAs());
        } else if (menu == editMenu) {
            ListMenu.clear();
            ListMenu.put(0, copy());
            ListMenu.put(1, paste());
            ListMenu.put(2, cut());
            ListMenu.put(3, null);
            ListMenu.put(4, find());
            ListMenu.put(5, replace());
            ListMenu.put(6, replaceLine());
            ListMenu.put(7, null);
            ListMenu.put(8, undo());
            ListMenu.put(9, redo());
        } else if (menu == aboutMenu) {
            ListMenu.clear();
            ListMenu.put(0, optionen());
            ListMenu.put(1, console());
            ListMenu.put(2, null);
            ListMenu.put(3, version());
            ListMenu.put(4, relluem94());
        } else {

        }
    }

    public void menuInit() {
        addMenuItems();

        menuBar.setBorder(border);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        frame.setJMenuBar(menuBar);
    }

}
