package com.example.gui.basic.swing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Leo Huang
 */
public class JavaSwingDemo extends javax.swing.JFrame implements ActionListener {

    JRadioButtonMenuItem[] jrbmenuitem = new JRadioButtonMenuItem[7];

    String item[] = {"Metal", "CDE/Motif", "Windows XP", "Windows Classic", "Nimbus", "GTK+", "Mac"};

    String classname[] = {
            "javax.swing.plaf.metal.MetalLookAndFeel",
            "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
            "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel",
            "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel",
            "com.sun.java.swing.plaf.gtk.GTKLookAndFeel",
            "com.sun.java.swing.plaf.mac.MacLookAndFeel"};

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("swing.boldMetal", Boolean.FALSE);

            try {
                // Metal Look and Feel
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }

            new JavaSwingDemo();
        });
    }

    // Constructor
    public JavaSwingDemo() {
        super("JFXPanel Demo");

        // Create Java Swing MenuBar
        JMenuBar jmenubar = createJMenuBar();
        this.setJMenuBar(jmenubar);

        // Creat JavaFX Panel
        final JFXPanel jfxPanel = new JFXPanel();

        Platform.runLater(() -> {
            initFX(jfxPanel);
        });

        this.add(jfxPanel);
        // Set the size of Java Swing
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Center the frame of Java Swing
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        if (frameSize.height > screenSize.height)
            frameSize.height = screenSize.height;

        if (frameSize.width > screenSize.width)
            frameSize.width = screenSize.width;

        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Create JavaFX Panel
    private static void initFX(JFXPanel jfxPanel) {

        TitledPane titledpane[] = new TitledPane[5];

        for (int i = 0; i < titledpane.length; i++) {
            HBox hbox = new HBox();
            hbox.getChildren().add(new ImageView(new Image(JavaSwingDemo.class.getResourceAsStream("/basic/swing/images/pic" + (i + 1) + ".jpg"))));
            hbox.setAlignment(Pos.CENTER);

            titledpane[i] = new TitledPane();
            titledpane[i].setText("Picture " + (i + 1));
            titledpane[i].setContent(hbox);
            titledpane[i].setAnimated(true);
            titledpane[i].setCollapsible(true);
        }

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(titledpane);
        accordion.setExpandedPane(titledpane[0]);

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.getChildren().setAll(accordion);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(hbox, 300, 300);

        // Set the Scene of JFXPanel
        jfxPanel.setScene(scene);
    }

    // Create Java Swing menubar
    private JMenuBar createJMenuBar() {
        JMenuBar jmenubar = new JMenuBar();

        JMenu jmenuFile = new JMenu("File");

        JMenuItem jmenuFileExit = new JMenuItem("Exit");
        jmenuFileExit.addActionListener((ActionEvent e) -> {
            JOptionPane joptionpane = new JOptionPane();

            int iResult = joptionpane.showConfirmDialog(null, "Are you sure to quit?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (iResult == 0) {
                System.exit(0);
            }
        });
        jmenuFile.add(jmenuFileExit);

        JMenu jmenuLF = new JMenu("L & F");

        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < item.length; i++) {
            jrbmenuitem[i] = new JRadioButtonMenuItem(item[i]);
            jrbmenuitem[i].setEnabled(isLookAndFeelSupported(classname[i]));

            jmenuLF.add(jrbmenuitem[i]);
            group.add(jrbmenuitem[i]);

            jrbmenuitem[i].addActionListener(this);

            if (i == 0)
                jrbmenuitem[i].setSelected(true);
        }

        jmenubar.add(jmenuFile);
        jmenubar.add(jmenuLF);

        return jmenubar;
    }

    private boolean isLookAndFeelSupported(String lnfname) {
        try {
            Class lnfclass = Class.forName(lnfname);
            javax.swing.LookAndFeel lnf = (LookAndFeel) (lnfclass.newInstance());

            return lnf.isSupportedLookAndFeel();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < item.length; i++) {
                if (e.getActionCommand().equals(item[i])) {
                    UIManager.setLookAndFeel(classname[i]);
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(this);
    }
}
