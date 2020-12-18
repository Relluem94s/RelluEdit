package de.relluem94.relluedit.api;

import javax.swing.JInternalFrame;

public abstract interface PluginGui extends PluginMenu {

    public void addFrameToList(JInternalFrame frame);

}
