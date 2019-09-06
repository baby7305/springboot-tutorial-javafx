package com.example.gui.effect.blur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class GaussianBlurDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        GaussianBlur gaussianblur = new GaussianBlur();
        gaussianblur.setRadius(15.0);

        Text text = new Text();
        text.setText("Gaussian Blur");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text.setEffect(gaussianblur);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Gaussian Blur Demo");
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
