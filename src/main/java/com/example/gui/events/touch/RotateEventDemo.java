package com.example.gui.events.touch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.RotateEvent;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class RotateEventDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        final ImageView imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.png")));
        imageview.setTranslateX(80);
        imageview.setTranslateY(80);

        // Rotation Started
        imageview.setOnRotationStarted((RotateEvent e) -> {
            imageview.setEffect(new DropShadow());
            e.consume();
        });

        // Rotate
        imageview.setOnRotate((RotateEvent e) -> {
            imageview.setRotate(imageview.getRotate() + e.getAngle());
            e.consume();
        });

        // Rotation Finished
        imageview.setOnRotationFinished((RotateEvent e) -> {
            imageview.setEffect(null);
            e.consume();
        });

        Group group = new Group();
        group.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);

        // Set the title of Stage
        primaryStage.setTitle("Rotate Event Demo");
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
