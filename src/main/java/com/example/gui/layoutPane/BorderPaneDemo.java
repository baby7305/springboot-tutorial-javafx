package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class BorderPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Define Button
        Button button1 = new Button("Top");
        button1.setPrefSize(70, 20);

        Button button2 = new Button("Bottom");
        button2.setPrefSize(70, 20);

        Button button3 = new Button("Left");
        button3.setPrefSize(70, 20);

        Button button4 = new Button("Right");
        button4.setPrefSize(70, 20);

        Button button5 = new Button("Center");
        button5.setPrefSize(70, 20);

        // Define BorderPane
        BorderPane borderpane = new BorderPane();
        borderpane.setTop(button1);
        borderpane.setBottom(button2);
        borderpane.setLeft(button3);
        borderpane.setRight(button4);
        borderpane.setCenter(button5);

        // Set the alighment for BorderPane
        BorderPane.setAlignment(button1, Pos.CENTER);
        BorderPane.setAlignment(button2, Pos.CENTER);
        BorderPane.setAlignment(button3, Pos.CENTER);
        BorderPane.setAlignment(button4, Pos.CENTER);
        BorderPane.setAlignment(button5, Pos.CENTER);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(borderpane);
        // Set the title of Stage
        primaryStage.setTitle("Border Pane Demo");
        // Set the width of Stage
        primaryStage.setWidth(250);
        // Set the height of Stage
        primaryStage.setHeight(250);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);

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
