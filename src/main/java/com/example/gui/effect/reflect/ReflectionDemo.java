package com.example.gui.effect.reflect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class ReflectionDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Reflection reflection = new Reflection();
        reflection.setTopOffset(0.0);
        reflection.setFraction(1.0);
        reflection.setTopOpacity(0.5);
        reflection.setBottomOpacity(0.0);

        Text text = new Text();
        text.setText("Reflection");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text.setEffect(reflection);

        AnchorPane anchorpane = new AnchorPane();
        AnchorPane.setTopAnchor(text, 30.0);
        AnchorPane.setLeftAnchor(text, 85.0);
        anchorpane.getChildren().add(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(anchorpane);
        // Set the title of Stage
        primaryStage.setTitle("Reflection Demo");
        // Set the width of Stage
        primaryStage.setWidth(500);
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
