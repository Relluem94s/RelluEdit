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

        makeMenu(datei);
        datei.setMnemonic(KeyEvent.VK_F);

        makeMenu(edit);
        edit.setMnemonic(KeyEvent.VK_E);

        makeMenu(ueber);
        ueber.setMnemonic(KeyEvent.VK_A);
    }

    public void makeListMenu(JMenu menu) {
        if (menu == datei) {
            ListMenu.clear();
            ListMenu.put(0, open());
            ListMenu.put(1, null);
            ListMenu.put(2, neu());
            ListMenu.put(3, null);
            ListMenu.put(4, save());
            ListMenu.put(5, saveAs());
        } else if (menu == edit) {
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
        } else if (menu == ueber) {
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

        bar.setBorder(border);
        bar.add(datei);
        bar.add(edit);
        bar.add(ueber);

        frame.setJMenuBar(bar);
    }

}
