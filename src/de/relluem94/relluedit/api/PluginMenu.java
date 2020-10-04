package de.relluem94.relluedit.api;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public abstract interface PluginMenu {
	
	public void addMenuItem(JMenu menu, JMenuItem jmi);

}
