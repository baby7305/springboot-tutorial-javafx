package com.example.gui.effect.perspective;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class PerspectiveTransformDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        PerspectiveTransform perspectiveTrasform = new PerspectiveTransform();
        perspectiveTrasform.setUlx(50.0);
        perspectiveTrasform.setUly(10.0);
        perspectiveTrasform.setUrx(450.0);
        perspectiveTrasform.setUry(60.0);
        perspectiveTrasform.setLrx(450.0);
        perspectiveTrasform.setLry(120.0);
        perspectiveTrasform.setLlx(50.0);
        perspectiveTrasform.setLly(230.0);

        Text text = new Text();
        text.setText("Perspective Transform");
        text.setFill(Color.BLACK);
        text.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        Group group = new Group();
        group.setCache(true);
        group.getChildren().add(text);

        group.setEffect(perspectiveTrasform);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(group);
        // Set the title of Stage
        primaryStage.setTitle("Perspective Transform Demo");
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
