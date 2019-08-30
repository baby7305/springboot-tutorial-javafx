package com.example.gui.basic.theme;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class JavaFXThemeDemo extends Application {

    String menulabel[] = {"File", "Edit", "Theme", "Help"};

    String menuitemlabel[][] = {
            {"New|N|new.gif", "Open|O|open.gif", "-", "Save|S|save.gif", "Save As...|A", "-", "Level", "-", "Exit|X"},
            {"Cut|T|cut.gif", "Copy|C|copy.gif", "Paste|P|paste.gif"},
            {"Modena|M", "Caspian|C"},
            {"Index|I", "Use Help|U", "-", "About|A|about.gif"}
    };

    String submenuitemlabel[] = {"Basic|B", "Intermediate|M", "Advance|V"};

    Menu menu[];
    MenuItem menuitem[][] = new MenuItem[4][9];
    CheckMenuItem checkmenuitem[] = new CheckMenuItem[2];
    RadioMenuItem radiomenuitem1[] = new RadioMenuItem[3];
    RadioMenuItem radiomenuitem2[] = new RadioMenuItem[2];

//  Label label = new Label();

    @Override
    public void start(Stage primaryStage) {

        // Create Menu Bar
        MenuBar menubar = createMenuBar();

        VBox vbox = new VBox();

        vbox.getChildren().add(menubar);

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, 5));

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(vbox);
        borderpane.setBottom(hbox);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);

        // Set the title of Stage
        primaryStage.setTitle("Theme Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
        primaryStage.setScene(scene);

        // Show Stage
        primaryStage.show();
    }

    private MenuBar createMenuBar() {
        // Create Menu Bar
        MenuBar menubar = new MenuBar();

        menu = new Menu[menulabel.length];

        // Create Menu
        for (int i = 0; i < menulabel.length; i++) {
            menu[i] = new Menu(menulabel[i]);

            // Add Menu to Menu Bar
            menubar.getMenus().add(menu[i]);
        }

        ToggleGroup togglegroup1 = new ToggleGroup();
        ToggleGroup togglegroup2 = new ToggleGroup();

        for (int i = 0; i < menulabel.length; i++) {
            for (int j = 0; j < menuitemlabel[i].length; j++) {
                if (i == 0 && j == 6) { // Sub Menu
                    // Sub Menu
                    Menu submenu = new Menu(menuitemlabel[i][j]);

                    // Sub Menu Item
                    for (int k = 0; k < submenuitemlabel.length; k++) {
                        // Radio Menu Item
                        if (submenuitemlabel[k].contains("|"))
                            radiomenuitem1[k] = new RadioMenuItem(submenuitemlabel[k].substring(0, submenuitemlabel[k].indexOf("|")));
                        else
                            radiomenuitem1[k] = new RadioMenuItem(submenuitemlabel[k]);

                        // Set Accelerator
                        radiomenuitem1[k].setAccelerator(KeyCombination.keyCombination("Ctrl+" + submenuitemlabel[k].split("\\|")[1].charAt(0)));

                        // Set Toggle Group
                        radiomenuitem1[k].setToggleGroup(togglegroup1);

                        if (k == 0)
                            radiomenuitem1[k].setSelected(true);

                        // Add Radio Menu Item to Menu
                        submenu.getItems().add(radiomenuitem1[k]);
                    }

                    menu[i].getItems().add(submenu);
                } else if (menuitemlabel[i][j].equals("-")) {
                    // Add Separator Menu Item
                    menu[i].getItems().add(new SeparatorMenuItem());
                } else {
                    if (i != 2) {
                        // Menu Item
                        if (menuitemlabel[i][j].contains("|"))
                            menuitem[i][j] = new MenuItem(menuitemlabel[i][j].substring(0, menuitemlabel[i][j].indexOf("|")));
                        else
                            menuitem[i][j] = new MenuItem(menuitemlabel[i][j]);

                        // Set Accelerator
                        menuitem[i][j].setAccelerator(KeyCombination.keyCombination("Ctrl+" + menuitemlabel[i][j].split("\\|")[1].charAt(0)));

                        // Set Image
                        if (menuitemlabel[i][j].endsWith(".gif")) {
                            Image image = new Image(getClass().getResourceAsStream("/basic/theme/images/" + menuitemlabel[i][j].substring(menuitemlabel[i][j].lastIndexOf("|") + 1)));

                            menuitem[i][j].setGraphic(new ImageView(image));
                        }

                        // Add Menu Item to Menu
                        menu[i].getItems().add(menuitem[i][j]);
                    } else { // Theme Menu
                        radiomenuitem2[j] = new RadioMenuItem(menuitemlabel[i][j].substring(0, menuitemlabel[i][j].indexOf("|")));
                        // Set Accelerator
                        radiomenuitem2[j].setAccelerator(KeyCombination.keyCombination("Ctrl+" + menuitemlabel[i][j].split("\\|")[1].charAt(0)));
                        // Set Toggle Group
                        radiomenuitem2[j].setToggleGroup(togglegroup2);

                        if (j == 0)
                            radiomenuitem2[j].setSelected(true);

                        radiomenuitem2[j].setOnAction((ActionEvent e) -> {
                            RadioMenuItem mnuitem = (RadioMenuItem) e.getSource();

                            if (mnuitem.getText().equals("Modena")) {
                                // Modena Theme
                                setUserAgentStylesheet(STYLESHEET_MODENA);
                            } else {
                                // Caspian Theme
                                setUserAgentStylesheet(STYLESHEET_CASPIAN);
                            }
                        });

                        // Add Menu Item to Menu
                        menu[i].getItems().add(radiomenuitem2[j]);
                    }
                }
            }
        }

        return menubar;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
