package de.relluem94.relluedit.api.toolbox;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import de.relluem94.relluedit.functions.WindowSnapper;

public class InternalFrames extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    private final Dimension minSize;
    private final Dimension maxSize;
    private final Dimension prefSize;
    private final Dimension size;
    private final boolean iconifiable;
    private final boolean isResizable;
    private final boolean isCloseable;
    private final boolean dispose;
    private final boolean snapper;

    private final JInternalFrame frame;

    public InternalFrames(String title, Dimension minSize, Dimension maxSize, Dimension prefSize, Dimension size,
            boolean iconifiable, boolean resizable, boolean closeable, boolean dispose, boolean snapper) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        this.prefSize = prefSize;
        this.size = size;
        this.iconifiable = iconifiable;
        this.isResizable = resizable;
        this.isCloseable = closeable;
        this.dispose = dispose;
        this.snapper = snapper;
        this.frame = new JInternalFrame(title);
    }

    public void disposeFrame() {
        frame.dispose();
    }

    public JInternalFrame makeFrame(Container pane) {
        frame.setSize(size);
        frame.setPreferredSize(prefSize);
        frame.setMaximumSize(maxSize);
        frame.setMinimumSize(minSize);
        frame.add(pane);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setIconifiable(iconifiable);
        frame.setResizable(isResizable);
        frame.setClosable(isCloseable);
        frame.setVisible(true);
        if (snapper) {
            frame.addComponentListener(new WindowSnapper());
        }

        if (dispose) {
            frame.dispose();
        } else {
            frame.show();
        }

        return frame;
    }

    @Override
    public Dimension getSize() {
        return size;
    }
}
