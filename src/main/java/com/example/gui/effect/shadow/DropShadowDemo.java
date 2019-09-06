package com.example.gui.effect.shadow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class DropShadowDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        DropShadow dropshadow = new DropShadow();
        dropshadow.setColor(Color.GREY);
        dropshadow.setOffsetX(5.0);
        dropshadow.setOffsetY(5.0);
        dropshadow.setRadius(5.0);

        Text text = new Text();
        text.setText("Drop Shadow");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text.setEffect(dropshadow);

        BorderPane borderpane = new BorderPane();
        borderpane.setCenter(text);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Drop Shadow Demo");
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
