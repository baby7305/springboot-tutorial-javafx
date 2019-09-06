package com.example.gui.effect.shadow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class InnerShadowDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        InnerShadow innershadow = new InnerShadow();
        innershadow.setColor(Color.BLACK);
        innershadow.setChoke(0.5);
        innershadow.setOffsetX(2.0);
        innershadow.setOffsetY(2.0);
        innershadow.setRadius(5.0);

        Text text = new Text();
        text.setText("Inner Shadow");
        text.setFill(Color.web("#BBBBBB"));
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text.setEffect(innershadow);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Inner Shadow Demo");
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
