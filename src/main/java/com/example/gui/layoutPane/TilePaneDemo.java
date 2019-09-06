package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


/**
 * @author Leo Huang
 */
public class TilePaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        TilePane tilepane = new TilePane(Orientation.VERTICAL);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(tilepane);

        // Read the content of CSS file
        scene.getStylesheets().add(getClass().getResource("/layoutPane/LayoutPane.css").toString());

        // Set the CSS styling for StackPane
        tilepane.getStyleClass().addAll("pane", "tilepane");

        ImageView images[] = new ImageView[8];

        for (int i = 0; i < 8; i++) {
            images[i] = new ImageView(new Image(getClass().getResourceAsStream("/layoutPane/images/duke" + i + ".gif")));

            // Add ImageView objects to TilePane
            tilepane.getChildren().add(images[i]);
        }

        // Set the title of Stage
        primaryStage.setTitle("Tile Pane with CSS Demo");
        // Set the width of Stage
        primaryStage.setWidth(340);
        // Set the height of Stage
        primaryStage.setHeight(260);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);

        // Show Stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
