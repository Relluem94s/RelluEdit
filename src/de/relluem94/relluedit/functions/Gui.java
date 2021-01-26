package de.relluem94.relluedit.functions;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import de.relluem94.relluedit.RelluEdit;
import de.relluem94.relluedit.images.images;

public class Gui extends Funktionen {

    de.relluem94.relluedit.RelluEdit main;

    public Gui(RelluEdit instance) {
        super(instance);
    }

    public void addFrames() {
        addFrameToList(WierdThingFrame);
        addFrameToList(preferencesFrame);
        addFrameToList(findFrame);
        addFrameToList(consoleFrame);
        addFrameToList(replaceLineFrame);
        addFrameToList(replaceFrame);
        addFrameToList(Relluem94Frame);
        addFrameToList(VersionFrame);
        addFrameToList(editorFrame);
    }

    public void initGUI() {
        menuInit();
        EditorPaneInit();
        addFrames();

        frame.setIconImage(images.getImage("icon_rellus_editor.png"));
        frame.setVisible(true);
        desktopPane.setVisible(true);

        frame.setSize(WIDTH, HEIGHT - 20);
        frame.setMinimumSize(minFrameSize);
        frame.setMaximumSize(screenSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        desktopPane.setSize(WIDTH, HEIGHT - 20);
        desktopPane.setPreferredSize(new Dimension(WIDTH - 200, HEIGHT - 20));
        desktopPane.setMaximumSize(new Dimension(WIDTH - 200, HEIGHT - 20));
        desktopPane.setMinimumSize(new Dimension(WIDTH - 200, HEIGHT - 20));

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 24));
        statusPanel.setLayout(new BorderLayout());
        statusPanel.add(statusbar_size, BorderLayout.EAST);
        statusPanel.add(statusbar_pfad, BorderLayout.WEST);

        for (int i = 0; i < iframelist.size(); i++) {
            desktopPane.add(iframelist.get(i));
        }

        frame.add(statusPanel, BorderLayout.SOUTH);
        frame.add(desktopPane);
    }
}
