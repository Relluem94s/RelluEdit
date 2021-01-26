package de.relluem94.relluedit.api.ToolBox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.undo.UndoManager;

import de.relluem94.relluedit.api.ressources.Colors;
import de.relluem94.relluedit.images.images;

public class Variables extends Colors {

    public static ResourceBundle bundle = changeLocale(setLanguage());
    public static String optionsname = "options.properties";
    public static String Pfad = System.getProperty("user.home");

    public Color rellu_orange = getColor("o_color_rellu_orange");
    public Color rellu_grey = getColor("o_color_rellu_grey");
    public Color rellu_red = getColor("o_color_rellu_red");

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public Dimension minFrameSize = new Dimension(714, 864);
    public static int WIDTH = 1200;
    public static int HEIGHT = 980;
    public int SearchPos = 0; //For Search

    public String content, s0, t0, r0, name, pfad, size = "";
    public String title = "Rellu's Editor";
    public String Programmversion = "0.0.11"; // Version

    public File Datei = null;
    public File tempDatei = null;

    public JLabel statusbar_size = new JLabel();
    public JLabel statusbar_pfad = new JLabel();

    public UndoManager unma = new UndoManager();

    public JTextPane textPane = new JTextPane();
    public JTextPane textPaneVersion = new JTextPane();

    public JTextArea textArea = new JTextArea();
    public Thread reader;
    public Thread reader2;
    public boolean quit;
    public String console_content;

    public final PipedInputStream pin = new PipedInputStream();
    public final PipedInputStream pin2 = new PipedInputStream();

    public List<JInternalFrame> iframelist = new ArrayList<>();

    public JInternalFrame iFrame = new JInternalFrame("Editor");
    public JFrame frame = new JFrame(title + " - [" + bundle.getString("l_unnamed") + "]");
    public JDesktopPane desktopPane = new JDesktopPane() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private Image image = images.getImage("logo_rellus_editor.png");

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(rellu_grey);
            g.fillRect(0, 0, getWidth(), getHeight());

            g.drawImage(images.getImage("bg.png"), 0, 0, getWidth(), getHeight(), this);
            g.setColor(rellu_orange);
            g.drawString("v" + Programmversion, 10, 14);
            //g.drawLine(9, 16, 76, 16);

            g.drawImage(image, getWidth() / 3, getHeight() / 3, 2042 / 3, 408 / 3, this);
        }
    };

    public JMenuItem meunItem = null;
    public JMenu datei = new JMenu(bundle.getString("l_file"));
    public JMenu edit = new JMenu(bundle.getString("l_edit"));
    public JMenu ueber = new JMenu(bundle.getString("l_about"));

    public HashMap<Integer, JMenuItem> ListMenu = new HashMap<Integer, JMenuItem>();

    public JMenuBar bar = new JMenuBar();
    public Border border = new LineBorder(Color.DARK_GRAY);

}
