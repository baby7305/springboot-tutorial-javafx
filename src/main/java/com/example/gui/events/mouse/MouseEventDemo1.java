package com.example.gui.events.mouse;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class MouseEventDemo1 extends Application {

    ImageView imageview;

    @Override
    public void start(Stage primaryStage) {

        imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.gif")));

        Group group = new Group();
        group.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);

        // Mouse Moved
        scene.setOnMouseMoved(onMouseMovedEventHandler);

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

    EventHandler onMouseMovedEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            imageview.setX(e.getX());
            imageview.setY(e.getY());
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
