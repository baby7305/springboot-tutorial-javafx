package com.example.gui.basic.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class JavaFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("JavaFX 8 Hello World");
        text.setX(50);
        text.setY(50);

        Group group = new Group();
        group.getChildren().add(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);
        // Set the title of Stage
        primaryStage.setTitle("JavaFX 8 Hello World");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(150);
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
