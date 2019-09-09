package com.example.gui.events.mouse;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class MouseEventDemo4 extends Application {

    ImageView imageview;

    @Override
    public void start(Stage primaryStage) {

        imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.gif")));

        Group root = new Group();
        root.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(root);

        // Mouse Moved
        scene.setOnMouseMoved((MouseEvent e) -> {
            imageview.setX(e.getX());
            imageview.setY(e.getY());
        });

        // Set the title of Stage
        primaryStage.setTitle("Mouse Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
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
