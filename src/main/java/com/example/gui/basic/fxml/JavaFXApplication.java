package com.example.gui.basic.fxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Leo Huang
 */
public class JavaFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/basic/fxml/FXMLDocument.fxml"));
//      GridPane fxmlRoot = (GridPane) FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            // Set the Layout Pane of Scene
            Scene scene = new Scene(root);
            // Set the title of Stage
            primaryStage.setTitle("JavaFX 8 Hello World");
            primaryStage.setScene(scene);

            // Show Stage
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
