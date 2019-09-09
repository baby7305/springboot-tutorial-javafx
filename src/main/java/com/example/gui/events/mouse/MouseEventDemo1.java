package com.example.gui.events.mouse;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class MouseEventDemo1 extends Application {

    Label label = new Label();

    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(0, 0, 0, 5));
        hbox.getChildren().add(label);

        BorderPane borderpane = new BorderPane();
        borderpane.setBottom(hbox);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);

        // Mouse Clicked
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Clicked: " + e.getButton());
            }
        });

        // Mouse Entered
        scene.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Entered: X: " + e.getX() + ", Y: " + e.getY());
            }
        });

        // Mouse Exited
        scene.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Exited: X: " + e.getX() + ", Y: " + e.getY());
            }
        });

        // Mouse Moved
        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Moved: X: " + e.getX() + ", Y: " + e.getY());
            }
        });

        // Mouse Pressed
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Pressed: " + e.getButton());
            }
        });

        // Mouse Released
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                label.setText("Mouse Released: " + e.getButton());
            }
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
