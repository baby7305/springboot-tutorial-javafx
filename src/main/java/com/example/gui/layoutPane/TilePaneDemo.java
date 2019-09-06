package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.geometry.Insets;
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
        tilepane.setPadding(new Insets(10, 10, 10, 10));
        tilepane.setHgap(5);
        tilepane.setVgap(5);
        tilepane.setPrefRows(4);

        ImageView images[] = new ImageView[8];

        for (int i = 0; i < 8; i++) {
            images[i] = new ImageView(new Image(getClass().getResourceAsStream("/layoutPane/images/duke" + i + ".gif")));

            // Add ImageView objects to TilePane
            tilepane.getChildren().add(images[i]);
        }

        // Set the Layout Pane of Scene
        Scene scene = new Scene(tilepane);

        // Set the title of Stage
        primaryStage.setTitle("Tile Pane Demo");
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
