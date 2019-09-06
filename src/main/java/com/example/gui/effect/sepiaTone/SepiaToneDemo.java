package com.example.gui.effect.sepiaTone;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class SepiaToneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        SepiaTone sepiatone = new SepiaTone();
        sepiatone.setLevel(1.0);

        ImageView imageview = new ImageView(new Image(getClass().getResourceAsStream("/effect/images/JavaFX.png")));
        imageview.setEffect(sepiatone);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Sepia Tone Demo");
        // Set the width of Stage
        primaryStage.setWidth(300);
        // Set the height of Stage
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

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
