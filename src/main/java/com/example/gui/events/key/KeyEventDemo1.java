package com.example.gui.events.key;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class KeyEventDemo1 extends Application {

    Stage stage;

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

        stage = new Stage();
        stage = primaryStage;

        // Key Pressed
        scene.setOnKeyPressed(onKeyPressedEventHandler);

        // Key Released
        scene.setOnKeyReleased(onKeyReleasedEventHandler);

        // Key Typed
        scene.setOnKeyTyped(onKeyTypedEventHandler);

        // Set the title of Stage
        primaryStage.setTitle("Key Event Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);

        // Show Stage
        primaryStage.show();
    }

    // Key Pressed
    EventHandler onKeyPressedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            int dx = 0;
            int dy = 0;

            if (e.isAltDown())
                label.setText("Press Alt key");

            if (e.isControlDown())
                label.setText("Press Control key");

            if (e.isShiftDown())
                label.setText("Press Shift key");

            label.setText("Press " + e.getCode().getName());

            if (e.getCode() == KeyCode.UP)
                dy = -5;
            else if (e.getCode() == KeyCode.DOWN)
                dy = 5;
            else if (e.getCode() == KeyCode.LEFT)
                dx = -5;
            else if (e.getCode() == KeyCode.RIGHT)
                dx = 5;
            else if (e.getCode() == KeyCode.PAGE_UP)
                dy = -100;
            else if (e.getCode() == KeyCode.PAGE_DOWN)
                dy = 100;

            stage.setX(stage.getX() + dx);
            stage.setY(stage.getY() + dy);
        }
    };

    // Key Released
    EventHandler onKeyReleasedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            if (e.isAltDown())
                label.setText("Release Alt key");

            if (e.isControlDown())
                label.setText("Release Control key");

            if (e.isShiftDown())
                label.setText("Release Shift key");

            label.setText("Release " + e.getCode().getName());
        }
    };

    // Key Typed
    EventHandler onKeyTypedEventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent e) {
            if (e.isAltDown())
                label.setText("Type Alt key");

            if (e.isControlDown())
                label.setText("Type Control key");

            if (e.isShiftDown())
                label.setText("Type Shift key");

            label.setText("Type " + e.getCode().getName());
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
