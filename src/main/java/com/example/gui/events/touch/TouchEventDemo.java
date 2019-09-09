package com.example.gui.events.touch;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class TouchEventDemo extends Application {

    long id = -1;
    double posX, posY;

    @Override
    public void start(Stage primaryStage) {

        final ImageView imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.png")));
        imageview.setTranslateX(80);
        imageview.setTranslateY(80);

        // Touch Pressed
        imageview.setOnTouchPressed((TouchEvent e) -> {
            if (id == -1) {
                id = e.getTouchPoint().getId();
                posX = e.getTouchPoint().getSceneX() - imageview.getTranslateX();
                posY = e.getTouchPoint().getSceneY() - imageview.getTranslateY();
            }
            e.consume();
        });

        // Touch Released
        imageview.setOnTouchReleased((TouchEvent e) -> {
            if (e.getTouchPoint().getId() == id) {
                id = -1;
            }
            e.consume();
        });

        // Touch Moved
        imageview.setOnTouchMoved((TouchEvent e) -> {
            if (e.getTouchPoint().getId() == id) {
                imageview.setTranslateX(e.getTouchPoint().getSceneX() - posX);
                imageview.setTranslateY(e.getTouchPoint().getSceneY() - posY);
            }
            e.consume();
        });

        Group group = new Group();
        group.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);

        // Set the title of Stage
        primaryStage.setTitle("Touch Event Demo");
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
