package com.example.gui.layoutPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * @author Leo Huang
 */
public class FlowPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Define Button
        Button button1 = new Button("OK");
        button1.setPrefSize(60, 20);

        Button button2 = new Button("Cancel");
        button2.setPrefSize(60, 20);

        Button button3 = new Button("Yes");
        button3.setPrefSize(60, 20);

        Button button4 = new Button("No");
        button4.setPrefSize(60, 20);

        // Define FlowPane
        FlowPane flowpane = new FlowPane();
        // Set Hgap for FlowPane
        flowpane.setHgap(5);
        // Set Vgap for FlowPane
        flowpane.setVgap(5);

        // Add Button to FlowPane
        flowpane.getChildren().addAll(button1, button2, button3, button4);

        // Set the Layout Pane of Scene
        Scene scene = new Scene(flowpane);

        // Set the title of Stage
        primaryStage.setTitle("Flow Pane Demo");
        // Set the width of Stage
        primaryStage.setWidth(300);
        // Set the height of Stage
        primaryStage.setHeight(150);
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
