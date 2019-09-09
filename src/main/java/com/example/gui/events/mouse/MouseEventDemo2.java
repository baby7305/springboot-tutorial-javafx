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
public class MouseEventDemo2 extends Application {

    ImageView imageview;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    @Override
    public void start(Stage primaryStage) {

        imageview = new ImageView(new Image(getClass().getResourceAsStream("/events/images/duke.gif")));

        // Mouse Pressed
        imageview.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                orgSceneX = e.getSceneX();
                orgSceneY = e.getSceneY();
                orgTranslateX = ((ImageView) (e.getSource())).getTranslateX();
                orgTranslateY = ((ImageView) (e.getSource())).getTranslateY();
            }
        });

        // Mouse Dragged
        imageview.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                double offsetX = e.getSceneX() - orgSceneX;
                double offsetY = e.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView) (e.getSource())).setTranslateX(newTranslateX);
                ((ImageView) (e.getSource())).setTranslateY(newTranslateY);
            }
        });

        Group group = new Group();
        group.getChildren().add(imageview);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);

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
