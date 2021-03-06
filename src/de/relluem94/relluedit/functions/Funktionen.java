package de.relluem94.relluedit.functions;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import de.relluem94.relluedit.RelluEdit;
import de.relluem94.relluedit.api.toolbox.Toolbox;
import de.relluem94.rellulib.utils.FileUtils;
import de.relluem94.rellulib.utils.LogUtils;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Funktionen extends Toolbox {

    public Funktionen(RelluEdit instance) {
        main = instance;
    }

    de.relluem94.relluedit.RelluEdit main;

    public void EditorPaneInit() {

        Document doc = textPane.getDocument();

        doc.addUndoableEditListener((UndoableEditEvent evt) -> {
            undoManager.addEdit(evt.getEdit());
        });

        textPane.getActionMap().put("Undo", new AbstractAction("Undo") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                } catch (CannotUndoException e) {
                    LogUtils.error(e.getMessage());
                }
            }
        });
        textPane.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

        textPane.getActionMap().put("Redo", new AbstractAction("Redo") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undoManager.canRedo()) {
                        undoManager.redo();
                    }
                } catch (CannotRedoException e) {
                    LogUtils.error(e.getMessage());
                }
            }
        });
        textPane.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");

        textPane.getActionMap().put("Replace",
                new AbstractAction("Replace") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                content = textPane.getText();
                replaceFrame.setVisible(true);
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control R"), "Replace Line");

        textPane.getActionMap().put("Replace Line",
                new AbstractAction("Replace Line") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                content = textPane.getText();
                replaceLineFrame.setVisible(true);
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control L"), "Replace Line");

        textPane.getActionMap().put("Find",
                new AbstractAction("Find") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                content = textPane.getText();
                findFrame.setVisible(true);
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control F"), "Find");

        textPane.getActionMap().put("New",
                new AbstractAction("New") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                textPane.setText("");
                file = null;
                statusbar_pfad.setText("");
                statusbar_size.setText("");

                frame.setTitle(title + " - [" + bundle.getString("l_unnamed") + "]");
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control W"), "New");

        textPane.getActionMap().put("SaveAs",
                new AbstractAction("SaveAs") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    JFileChooser chooser = new JFileChooser();
                    // Dialog zum Oeffnen von Dateien anzeigen
                    chooser.showSaveDialog(null);
                    name = chooser.getSelectedFile().getName();
                    content = textPane.getText();
                    pfad = chooser.getSelectedFile().getPath();
                    size = chooser.getSelectedFile().length() + " Bytes";

                    statusbar_pfad.setText(pfad);
                    statusbar_size.setText(size);

                    frame.setTitle(title + " - [" + name + "]");
                    file = chooser.getSelectedFile();

                    FileUtils.writeText(file, content, charset);
                } catch (IOException ex) {
                    LogUtils.error(ex.getMessage());
                }
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control shift S"), "SaveAs");

        textPane.getActionMap().put("Save",
                new AbstractAction("Save") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {

                if (file != null) {
                    try {
                        content = textPane.getText();

                        FileUtils.writeText(file, content, charset);

                        name = file.getName();
                        pfad = file.getPath();
                        size = file.length() + " Bytes";

                        statusbar_pfad.setText(pfad);
                        statusbar_size.setText(size);

                        frame.setTitle(title + " - [" + name + "]");
                    } catch (IOException ex) {
                        LogUtils.error(ex.getMessage());
                    }

                } else {
                    try {
                        JFileChooser chooser = new JFileChooser();
                        chooser.showSaveDialog(null);
                        name = chooser.getSelectedFile().getName();
                        content = textPane.getText();
                        pfad = chooser.getSelectedFile().getPath();
                        size = chooser.getSelectedFile().length() + " Bytes";

                        statusbar_pfad.setText(pfad);
                        statusbar_size.setText(size);

                        frame.setTitle(title + " - [" + name + "]");
                        file = chooser.getSelectedFile();

                        FileUtils.writeText(file, content, charset);
                    } catch (IOException ex) {
                        LogUtils.error(ex.getMessage());
                    }
                }

            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control S"), "Save");

        textPane.getActionMap().put("Open",
                new AbstractAction("Open") {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent evt) {
                FileOpener();
            }
        });

        textPane.getInputMap().put(KeyStroke.getKeyStroke("control O"), "Open");

        textPane.setSelectedTextColor(Color.WHITE);
        textPane.setSelectionColor(rellu_grey);

        textPane.setEditable(true);
        textPane.setBorder(border);
        textPane.setDropTarget(new DropTarget() {

            private static final long serialVersionUID = 1L;

            @Override
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    @SuppressWarnings("unchecked")
                    List<File> droppedFiles = (List<File>) evt
                            .getTransferable().getTransferData(
                                    DataFlavor.javaFileListFlavor);
                    for (File droppedFile : droppedFiles) {

                        content = FileUtils.readTextString(droppedFile.getPath(), Charset.defaultCharset());
                        textPane.setText(content);
                        name = droppedFile.getName();
                        pfad = droppedFile.getPath();
                        size = droppedFile.length() + " Bytes";
                        file = droppedFile;
                        statusbar_pfad.setText(pfad);
                        statusbar_size.setText(size);
                        frame.setTitle(title + " - [" + name + "]");
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    LogUtils.error(ex.getMessage());
                }
            }
        });
    }

}
