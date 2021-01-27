package de.relluem94.relluedit.functions;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import de.relluem94.relluedit.images.images;
import de.relluem94.rellulib.utils.LogUtils;

public class SplashScreen extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static JProgressBar pbar;
    private final Image img;
    private static JLabel label;
    private static JLabel imglabel;

    public SplashScreen() {

        super("RelluEdit");
        setSize(425, 155);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setIconImage(images.getImage("icon_rellus_editor.png"));
        setLocationRelativeTo(null);
        setUndecorated(true);
        img = images.getImage("logo_rellus_editor.png");
        Image newimg = img.getScaledInstance(518/2, 183/2, java.awt.Image.SCALE_SMOOTH);
        getContentPane().setBackground(new Color(10, 10, 10, 0));
        setLayout(null);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.GRAY);
        pbar.setBackground(Color.LIGHT_GRAY);
        add(pbar);
        //pbar.setPreferredSize(new Dimension(410, 30));
        pbar.setBounds(15, 125, 393, 20);

        label = new JLabel();
        label.setText("Loading..");
        label.setForeground(Color.GRAY);
        add(label);
        label.setBounds(15, 105, 384, 20);

        imglabel = new JLabel(new ImageIcon(newimg));
        add(imglabel);
        imglabel.setBounds(10, 10, 404, 75);

        //TODO hier werden die Plugins geladen?
        Thread t = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i <= 100) {
                    pbar.setValue(i);
                    try {
                        sleep(90);
                    } catch (InterruptedException e) {
                        LogUtils.error(e.getMessage());
                    }
                    i++;
                }
            }
        };
        t.start();
    }

}
