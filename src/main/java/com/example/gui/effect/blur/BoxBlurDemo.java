package com.example.gui.effect.blur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class BoxBlurDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        BoxBlur boxblur = new BoxBlur();
        boxblur.setWidth(10.0);
        boxblur.setHeight(10.0);
        boxblur.setIterations(3);

        Text text = new Text();
        text.setText("Box Blur");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text.setEffect(boxblur);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Box Blur Demo");
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
