package com.example.gui.effect.gradient;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class RadialGradientDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        Stop[] stops = new Stop[]{
                new Stop(0.0, Color.RED),
                new Stop(0.5, Color.ORANGE),
                new Stop(1.0, Color.YELLOW)
        };

        RadialGradient radialgradient1 = new RadialGradient(0.0, 0.0, 0.5, 0.5, 0.1, true, CycleMethod.REFLECT, stops);

        Text text1 = new Text();
        text1.setText("Radial Gradient");
        text1.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text1.setFill(radialgradient1);

        RadialGradient radialgradient2 = new RadialGradient(180.0, 5.0, 10.0, 10.0, 10.0, true, CycleMethod.REFLECT, stops);

        Text text2 = new Text();
        text2.setText("Radial Gradient");
        text2.setFont(Font.font("Arial Black", FontWeight.BOLD, 60));

        text2.setFill(radialgradient2);

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(text1, text2);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(vbox);
        // Set the title of Stage
        primaryStage.setTitle("Radial Gradient Demo");
        // Set the width of Stage
        primaryStage.setWidth(550);
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
