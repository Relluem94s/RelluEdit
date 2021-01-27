package de.relluem94.relluedit.functions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.Document;

import de.relluem94.relluedit.api.CommandExecutor;
import de.relluem94.relluedit.api.Commands;
import de.relluem94.relluedit.api.toolbox.InternalFrames;
import de.relluem94.relluedit.api.toolbox.Toolbox;
import de.relluem94.relluedit.api.toolbox.Variables;
import de.relluem94.relluedit.images.images;

public class Panes implements Runnable, CommandExecutor {

    Variables f;
    InternalFrames i;

    public Panes(Variables f, InternalFrames i) {
        this.f = f;
        this.i = i;
    }

    public Container getFind() {
        Container contentPane = new Container();
        contentPane.setLayout(null);

        Border bo = new LineBorder(Color.DARK_GRAY);

        JTextField source = new JTextField(40);
        Component Source = new JLabel(Funktionen.bundle.getString("l_reSource"));

        source.setBorder(bo);
        source.setText("");

        JButton rp = new JButton();
        rp.setText(Funktionen.bundle.getString("l_find"));

        rp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String find = source.getText().toLowerCase();
                f.textPane.requestFocusInWindow();
                if (find != null && find.length() > 0) {
                    Document document = f.textPane.getDocument();
                    int findLength = find.length();
                    try {
                        boolean found = false;

                        if (f.SearchPos + findLength > document.getLength()) {
                            f.SearchPos = 0;
                        }

                        while (f.SearchPos + findLength <= document.getLength()) {

                            String match = document.getText(f.SearchPos, findLength).toLowerCase();

                            if (match.equals(find)) {
                                found = true;
                                break;
                            }
                            f.SearchPos++;
                        }

                        if (found) {

                            Rectangle viewRect = f.textPane.modelToView(f.SearchPos);
                            f.textPane.scrollRectToVisible(viewRect);
                            f.textPane.setCaretPosition(f.SearchPos + findLength);
                            f.textPane.moveCaretPosition(f.SearchPos);
                            f.SearchPos += findLength;
                        }

                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }

                }
            }
        });

        rp.setBounds(5, 125, 140, 30);
        Source.setBounds(5, 5, 430, 20);
        source.setBounds(5, 35, 430, 20);

        contentPane.add(source);
        contentPane.add(Source);
        contentPane.add(rp);

        return contentPane;
    }

    public Container getRelluem94() {
        Container contentPane = new Container();

        contentPane.setLayout(null);

        Component Text = new JLabel("www.relluem94.de");
        JButton ok = new JButton();
        ok.setText("OK");

        contentPane.add(ok);
        contentPane.add(Text);
        Text.setBounds(5, 5, 400, 30);
        ok.setBounds(5, 125, 140, 30);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i.disposeFrame();
            }
        });

        return contentPane;
    }

    public Container getEditor() {
        Container contentPane = new Container();

        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JScrollPane scroll = new JScrollPane(f.textPane);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        TextLineNumber tln = new TextLineNumber(f.textPane);
        scroll.setRowHeaderView(tln);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 2;
        contentPane.add(scroll, c);

        return contentPane;
    }

    public Container getPreferences() {
        Container contentPane = new Container();
        contentPane.setLayout(null);

        Component Text = new JLabel("Nothing is there.. return later..");
        JButton ok = new JButton();
        ok.setText("OK");

        contentPane.add(ok);
        contentPane.add(Text);

        Text.setBounds(5, 5, 400, 30);
        ok.setBounds(5, 125, 140, 30);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                i.disposeFrame();
            }
        });
        return contentPane;
    }

    public Container getVersion() {
        Container contentPane = new Container();
        contentPane.setLayout(null);

        Component Text = new JLabel("<html><span style='font-size:20px; color:#797472;'>" + f.Programmversion + "</span></html>");

        Image img = images.getImageIcon("logo_rellus_editor.png").getImage();
        Image newimg = img.getScaledInstance(250, 50, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);

        JLabel label = new JLabel();
        label.setIcon(newIcon);
        JButton ok = new JButton();
        ok.setText("OK");

        Component Text2 = new JLabel("Thanks to:");

        f.textPaneVersion.setEditable(false);
        f.textPaneVersion.setText("Text Component Line Number by Rob Camick"
                + "\n" + ""
                + "\n" + ""
                + "\n" + "");

        JScrollPane scroll = new JScrollPane(f.textPaneVersion);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        contentPane.add(scroll);
        contentPane.add(Text2);
        Text2.setBounds(5, 110, 140, 30);
        scroll.setBounds(5, 140, 420, 80);

        contentPane.add(ok);
        contentPane.add(Text);
        contentPane.add(label);

        Text.setBounds(275, 42, 440, 30);
        label.setBounds(5, 20, 250, 50);
        ok.setBounds(5, 225, 140, 30);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i.disposeFrame();
            }
        });

        return contentPane;
    }

    public Container getReplace() {
        Container contentPane = new Container();
        contentPane.setLayout(null);

        Border bo = new LineBorder(Color.DARK_GRAY);

        JTextField replace = new JTextField(40);
        Component Replace = new JLabel(Funktionen.bundle.getString("l_reReplace"));
        JTextField source = new JTextField(40);
        Component Source = new JLabel(Funktionen.bundle.getString("l_reSource"));

        source.setBorder(bo);
        source.setText("");

        replace.setBorder(bo);
        replace.setText("");

        JButton rp = new JButton();
        rp.setText(Funktionen.bundle.getString("l_replace"));

        rp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f.content = f.textPane.getText();
                f.s0 = source.getText();
                f.t0 = replace.getText();
                f.content = f.content.replaceFirst(f.s0, f.t0);
                f.textPane.setText(f.content);
            }
        });

        JButton rpa = new JButton();
        rpa.setText(Funktionen.bundle.getString("l_replaceall"));

        rpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f.content = f.textPane.getText();

                f.s0 = source.getText();
                f.t0 = replace.getText();

                f.content = f.content.replaceAll(f.s0, f.t0);
                f.textPane.setText(f.content);
            }
        });

        rp.setBounds(5, 125, 140, 30);
        rpa.setBounds(150, 125, 140, 30);

        Source.setBounds(5, 5, 430, 20);
        Replace.setBounds(5, 65, 430, 20);
        source.setBounds(5, 35, 430, 20);
        replace.setBounds(5, 95, 430, 20);

        contentPane.add(source);
        contentPane.add(replace);
        contentPane.add(Replace);
        contentPane.add(Source);
        contentPane.add(rp);
        contentPane.add(rpa);

        return contentPane;
    }

    public Container getReplaceLine() {
        Container contentPane = new Container();
        contentPane.setLayout(null);

        JTextField replace = new JTextField(40);
        Component Replace = new JLabel(Funktionen.bundle.getString("l_reReplace"));
        JTextField from = new JTextField(40);
        Component From = new JLabel(Funktionen.bundle.getString("l_reLiFrom"));
        JTextField to = new JTextField(40);
        Component To = new JLabel(Funktionen.bundle.getString("l_reLiTo"));

        from.setBorder(f.border);
        from.setText("");

        to.setBorder(f.border);
        to.setText("");

        replace.setBorder(f.border);
        replace.setText("");

        JButton rp = new JButton();
        rp.setText(Funktionen.bundle.getString("l_replaceline"));

        rp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                f.content = f.textPane.getText();

                f.s0 = from.getText();
                f.t0 = to.getText();
                f.r0 = replace.getText();

                String[] lines = f.content.split("\n");

                // Debugging
                //ErrorOutput("Lines to Replace: " + lines.length);
                //TODO Lags bei langen Texten
                for (int i = 0; i < lines.length; i++) {
                    if (lines[i].startsWith(f.s0) && lines[i].endsWith(f.t0)) {
                        if (f.r0.equals("*dl*")) {
                            // Debugging
                            Commands.Output("Gefunden " + lines[i] + " " + f.s0 + " " + f.t0);
                            lines[i] = "";
                            lines[i].replace("\n", "");
                        } else {
                            // Debugging
                            Commands.Output("Gefunden " + lines[i] + " " + f.s0 + " " + f.t0);
                            lines[i] = f.r0;
                        }
                        //TODO funzt nicht mehr
                    } else {
                        // Debugging
                        Commands.Output("Nicht gefunden " + lines[i] + " " + f.s0 + " " + f.t0);
                    }
                }

                String message = "";
                String[] arrayOfString1;
                int j = (arrayOfString1 = lines).length;
                for (int i = 0; i < j; i++) {
                    String arg = arrayOfString1[i];

                    message = message + arg + "\n";
                }

                f.content = message;
                f.textPane.setText(f.content);
            }
        });

        contentPane.add(from);
        contentPane.add(to);
        contentPane.add(replace);
        contentPane.add(Replace);
        contentPane.add(From);
        contentPane.add(To);
        contentPane.add(rp);

        rp.setBounds(5, 185, 180, 30);

        From.setBounds(5, 5, 430, 20);
        To.setBounds(5, 65, 430, 20);
        Replace.setBounds(5, 125, 430, 20);

        from.setBounds(5, 35, 430, 20);
        to.setBounds(5, 95, 430, 20);
        replace.setBounds(5, 155, 430, 20);

        return contentPane;
    }

    public Container getConsole() {
        //Container contentPane = new Container();

        JPanel contentPane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        f.textArea.setEditable(false);
        f.textArea.setForeground(Color.WHITE);
        f.textArea.setBackground(Color.BLACK);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_START;
        c.ipady = 400;
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(new JScrollPane(f.textArea), c);

        JButton button = new JButton(Funktionen.bundle.getString("l_consoleClear"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.2;
        c.weighty = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.PAGE_END;
        c.ipady = 10;
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(button, c);

        JTextField input = new JTextField(40);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.weighty = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.PAGE_END;
        c.ipady = 10;
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(input, c);

        input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = input.getText();
                if (text.equals("")) {

                } else {
                    String[] args = text.split(" ");

                    execute(args);
                    input.setText("");
                }
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.textArea.setText("");
            }
        });

        try {
            PipedOutputStream pout = new PipedOutputStream(f.pin);
            System.setOut(new PrintStream(pout, true));
        } catch (java.io.IOException io) {
            f.textArea.append("Couldn't redirect STDOUT to this console\n" + io.getMessage());
        } catch (SecurityException se) {
            f.textArea.append("Couldn't redirect STDOUT to this console\n" + se.getMessage());
        }

        try {
            PipedOutputStream pout2 = new PipedOutputStream(f.pin2);
            System.setErr(new PrintStream(pout2, true));
        } catch (java.io.IOException io) {
            f.textArea.append("Couldn't redirect STDERR to this console\n" + io.getMessage());
        } catch (SecurityException se) {
            f.textArea.append("Couldn't redirect STDERR to this console\n" + se.getMessage());
        }

        f.quit = false;

        f.reader = new Thread(this);
        f.reader.setDaemon(true);
        f.reader.start();
        //
        f.reader2 = new Thread(this);
        f.reader2.setDaemon(true);
        f.reader2.start();

        return contentPane;
    }

    public synchronized void run() {
        try {
            while (Thread.currentThread() == f.reader) {
                try {
                    this.wait(100);
                } catch (InterruptedException ie) {
                }
                if (f.pin.available() != 0) {
                    String input = this.readLine(f.pin);
                    f.textArea.append(input);
                }
                if (f.quit) {
                    return;
                }
            }

            while (Thread.currentThread() == f.reader2) {
                try {
                    this.wait(100);
                } catch (InterruptedException ie) {
                }
                if (f.pin2.available() != 0) {
                    String input = this.readLine(f.pin2);
                    f.textArea.append(input);
                }
                if (f.quit) {
                    return;
                }
            }
        } catch (Exception e) {
            f.textArea.append("\nConsole reports an Internal error.");
            f.textArea.append("The error is: " + e);
        }

    }

    public synchronized String readLine(PipedInputStream in) throws IOException {
        String input = "";
        do {
            int available = in.available();
            if (available == 0) {
                break;
            }
            byte b[] = new byte[available];
            in.read(b);
            input = input + new String(b, 0, b.length);
        } while (!input.endsWith("\n") && !input.endsWith("\r\n") && !f.quit);
        return input;
    }

    @Override
    public void execute(String[] args) {
        String s = Toolbox.static_ArryToString(args);
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("help")) {
                Commands.CMDOutput(args[0]);
                Commands.Output("List of Commands:");
                Commands.Output("   - help");
                Commands.Output("   - loadPlugin");
                Commands.Output("    ");
                Commands.Output("   - test");
                Commands.Output("   - rellu");
                Commands.Output("	");
                Commands.Output("   - exit");
            } else if (args[0].equalsIgnoreCase("show")) {
                Commands.CMDOutput(args[0]);
                Commands.Output("Liste");
            } else if (args[0].equalsIgnoreCase("hide")) {
                Commands.CMDOutput(args[0]);
                Commands.Output("Liste");
            } else if (args[0].equalsIgnoreCase("exit")) {
                Commands.CMDOutput(args[0]);
                Commands.ErrorOutput("Closing...");
                System.exit(0);
            } else if (args[0].equalsIgnoreCase("loadPlugin")) {
                Commands.CMDOutput(args[0], "Laedt ein Plugin || loadPlugin <name.jar>");
            } else if (args[0].equalsIgnoreCase("rellu")) {
                Commands.CMDOutput(args[0], "Ungueltiger Befehl..");
            } else if (args[0].equalsIgnoreCase("test")) {
                Commands.CMDOutput(args[0], "Test Befehl und so!");
                Frames.WierdThingFrame.setVisible(true);
            } else {
                Commands.ErrorOutput("The command \" " + s + "\" does not exist");
            }
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("help")) {
                if (args[1].equalsIgnoreCase("test")) {
                    Commands.CMDOutput(s, "Ein Test Befehl um Funktionen zu testen");
                } else if (args[1].equalsIgnoreCase("rellu")) {
                    Commands.CMDOutput(s, "Ein Befehl um da zu sein");
                } else if (args[1].equalsIgnoreCase("noob")) {
                    Commands.CMDOutput(s, "Ein Befehl der nicht existiert");
                } else {
                    Commands.ErrorOutput("The command \" " + s + "\" does not exist");
                }
            } else if (args[0].equalsIgnoreCase("show")) {
                // /show editor 0/1
                if (args[1].equalsIgnoreCase("editor")) {
                    Frames f = new Frames();
                    f.editorFrame.setVisible(true);
                    Commands.CMDOutput("Visibility of Editor is now true");
                }
            } else if (args[0].equalsIgnoreCase("hide")) {
                // /show editor 0/1
                if (args[1].equalsIgnoreCase("editor")) {
                    Frames f = new Frames();
                    f.editorFrame.setVisible(false);

                    Commands.CMDOutput("Visibility of Editor is now false");
                }
            } else if (args[0].equalsIgnoreCase("loadPlugin")) {

            } else {
                Commands.ErrorOutput("The command \" " + s + "\" does not exist");
            }
        } else if (args.length == 3) {
            if (args[0].equalsIgnoreCase("help")) {
                if (args[1].equalsIgnoreCase("test")) {
                    if (args[2].equalsIgnoreCase("test")) {
                        Commands.CMDOutput(s, "Ein Befehl der nicht existiert");
                    } else {
                        Commands.ErrorOutput("The command \" " + s + "\" does not exist");
                    }
                } else {
                    Commands.ErrorOutput("The command \" " + s + "\" does not exist");
                }
            } else {
                Commands.ErrorOutput("The command \" " + s + "\" does not exist");
            }
        }
    }
}
