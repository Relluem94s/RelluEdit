package de.relluem94.relluedit.api.toolbox;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.charset.Charset;

import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import de.relluem94.relluedit.functions.Frames;
import de.relluem94.rellulib.utils.FileUtils;
import de.relluem94.rellulib.utils.LogUtils;
import java.io.IOException;

public class MenuItems extends Frames {

    public void FileOpener() {
        try {
            JFileChooser chooser = new JFileChooser();
            // Dialog zum Oeffnen von Dateien anzeigen
            chooser.showOpenDialog(null);
            name = chooser.getSelectedFile().getName();
            File file = chooser.getSelectedFile();

            pfad = file.getPath();
            size = file.length() + " Bytes";

            statusbar_pfad.setText(pfad);
            statusbar_size.setText(size);

            this.file = file;
            content = FileUtils.readTextString(file.getPath(), Charset.defaultCharset());
            textPane.setText(content);
            frame.setTitle(title + " - [" + name + "]");
        } catch (IOException | NullPointerException es) {
            LogUtils.error(es.getMessage());
        }
    }

    public JMenuItem open() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_open"));
        meunItem.addActionListener((ActionEvent e) -> {
            try {
                FileOpener();
            } catch (NullPointerException es) {
                LogUtils.error(es.getMessage());
            }
        });
        return meunItem;
    }

    public JMenuItem newFile() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_new"));
        meunItem.addActionListener((ActionEvent e) -> {
            textPane.setText("");
            file = null;
            frame.setTitle(title + " - [" + bundle.getString("l_unnamed") + "]");

            statusbar_pfad.setText("");
            statusbar_size.setText("");
        });
        return meunItem;
    }

    public JMenuItem save() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_save"));
        meunItem.addActionListener((ActionEvent e) -> {
            if (file != null) {
                File file = this.file;

                content = textPane.getText();

                try {
                    FileUtils.writeText(file, content, charset);
                } catch (IOException ex) {
                    LogUtils.error(ex.getMessage());
                }

                name = file.getName();
                pfad = file.getPath();
                size = file.length() + " Bytes";

                statusbar_pfad.setText(pfad);
                statusbar_size.setText(size);

                frame.setTitle(title + " - [" + name + "]");

            } else {
                try {
                    JFileChooser chooser = new JFileChooser();
                    chooser.showSaveDialog(null);

                    File file = chooser.getSelectedFile();

                    content = textPane.getText();

                    try {
                        FileUtils.writeText(file, content, charset);
                    } catch (IOException ex) {
                        LogUtils.error(ex.getMessage());
                    }

                    name = file.getName();
                    pfad = file.getPath();
                    size = file.length() + " Bytes";

                    statusbar_pfad.setText(pfad);
                    statusbar_size.setText(size);
                    this.file = file;
                    frame.setTitle(title + " - [" + name + "]");

                } catch (NullPointerException es) {
                    LogUtils.error(es.getMessage());
                }
            }
        });
        return meunItem;
    }

    public JMenuItem saveAs() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_saveas"));
        meunItem.addActionListener((ActionEvent e) -> {
            try {
                JFileChooser chooser = new JFileChooser();
                // Dialog zum Oeffnen von Dateien anzeigen
                chooser.showSaveDialog(null);

                File file = chooser.getSelectedFile();

                content = textPane.getText();

                try {
                    FileUtils.writeText(file, content, charset);
                } catch (IOException ex) {
                    LogUtils.error(ex.getMessage());
                }

                name = file.getName();
                pfad = file.getPath();
                size = file.length() + " Bytes";

                statusbar_pfad.setText(pfad);
                statusbar_size.setText(size);
                this.file = file;
                frame.setTitle(title + " - [" + name + "]");

            } catch (NullPointerException es) {
                LogUtils.error(es.getMessage());
            }
        });
        return meunItem;
    }

    public JMenuItem find() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_find"));
        meunItem.setMnemonic(KeyEvent.VK_F);
        meunItem.addActionListener((ActionEvent e) -> {
            findFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem replace() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_replace"));
        meunItem.setMnemonic(KeyEvent.VK_R);
        meunItem.addActionListener((ActionEvent e) -> {
            replaceFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem replaceLine() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_replaceline"));
        meunItem.setMnemonic(KeyEvent.VK_L);
        meunItem.addActionListener((ActionEvent e) -> {
            replaceLineFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem copy() {
        meunItem = new JMenuItem();
        Action copyAction = new DefaultEditorKit.CopyAction();
        copyAction.putValue(Action.NAME, bundle.getString("l_copy"));
        meunItem.setAction(copyAction);
        return meunItem;
    }

    public JMenuItem paste() {
        meunItem = new JMenuItem();
        Action pasteAction = new DefaultEditorKit.PasteAction();
        pasteAction.putValue(Action.NAME, bundle.getString("l_paste"));
        meunItem.setAction(pasteAction);
        return meunItem;
    }

    public JMenuItem cut() {
        meunItem = new JMenuItem();
        Action cutAction = new DefaultEditorKit.CutAction();
        cutAction.putValue(Action.NAME, bundle.getString("l_cut"));
        meunItem.setAction(cutAction);
        return meunItem;
    }

    public JMenuItem undo() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_undo"));
        meunItem.addActionListener((ActionEvent e) -> {
            try {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            } catch (CannotUndoException ev) {
                LogUtils.error(ev.getMessage());
            }
        });
        return meunItem;
    }

    public JMenuItem redo() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_redo"));
        meunItem.addActionListener((ActionEvent e) -> {
            try {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            } catch (CannotRedoException ev) {
                LogUtils.error(ev.getMessage());
            }
        });
        return meunItem;
    }

    public JMenuItem optionen() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_preferences"));
        meunItem.addActionListener((ActionEvent e) -> {
            preferencesFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem console() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_console"));
        meunItem.addActionListener((ActionEvent e) -> {
            consoleFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem version() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_version"));
        meunItem.addActionListener((ActionEvent e) -> {
            versionFrame.setVisible(true);
        });
        return meunItem;
    }

    public JMenuItem relluem94() {
        meunItem = new JMenuItem();
        meunItem.setText(bundle.getString("l_relluem94"));
        meunItem.addActionListener((ActionEvent e) -> {
            relluem94Frame.setVisible(true);
        });
        return meunItem;
    }

}
